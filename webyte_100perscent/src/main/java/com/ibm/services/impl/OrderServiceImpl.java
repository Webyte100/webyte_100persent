/**
* This class describes service Implementations for Orders.
* Methods for updating order items in cart, fetching user cart, quantity in cart & all orders, adding voucher to cart & placing order .
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.AddressModel;
import com.ibm.model.entities.OrderItemModel;
import com.ibm.model.entities.OrderModel;
import com.ibm.model.entities.PaymentMethodModel;
import com.ibm.model.entities.ProductModel;
import com.ibm.model.entities.TransactionModel;
import com.ibm.model.entities.UserModel;
import com.ibm.model.entities.dto.CartDto;
import com.ibm.model.entities.dto.CartRequestDto;
import com.ibm.model.entities.dto.CartVoucherDto;
import com.ibm.model.entities.dto.OrderDto;
import com.ibm.model.entities.dto.OrderPlaceDto;
import com.ibm.model.entities.enumerations.Status;
import com.ibm.repo.AddressRepository;
import com.ibm.repo.OrderRepository;
import com.ibm.repo.PaymentMethodRepository;
import com.ibm.repo.ProductRepository;
import com.ibm.repo.TransactionRepository;
import com.ibm.repo.UserRepository;
import com.ibm.services.MailService;
import com.ibm.services.OrderService;
import com.ibm.services.common.HelpService;

@Service
public class OrderServiceImpl extends HelpService implements OrderService {

	@Autowired
	private MailService mailService;
	
	/**Injecting repository for Order database interaction*/
	@Autowired
	private OrderRepository repo;
	
	/**Injecting repository for User database interaction*/
	@Autowired
	private UserRepository userRepo;
	
	/**Injecting repository for Product database interaction*/
	@Autowired
	private ProductRepository productRepo;
	
	/**Injecting repository for Address database interaction*/
	@Autowired
	private AddressRepository addressRepo;
	
	/**Injecting repository for Transaction database interaction*/
	@Autowired
	private TransactionRepository transactionRepo;
	
	/**Injecting repository for Payment Method database interaction*/
	@Autowired
	private PaymentMethodRepository methodRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	/** Method to Update Order Items into database table */
	@Transactional
	@Override
	public Integer updateOrderItems(CartRequestDto dto) {
		OrderModel order = repo.findCartByUserName(dto.userName);
		if(order == null) {
			order = createCartOrder(dto);
		}
		if(dto.quantity < 1) {
			return removeItemFromCart(order, dto.productId);
		}
		else {
			return addItemToCart(order, dto.productId, dto.quantity);			
		}
	}
	
	/** Method to get User Cart from database table */
	@Override
	public CartDto getUserCart(String userName) {
		OrderModel order = repo.findCartByUserName(userName);
		
		CartDto response = new CartDto();
		response.userName = userName;
		if(order != null) {
			mapper.map(order, response);			
		}
		return response;
	}
	
	/** Method to get Quantity In Cart from database table */
	@Override
	public Integer getQuantityInCart(String userName, String modelNo) {
		OrderModel order = repo.findCartByUserName(userName);
		OrderItemModel orderItem = getOrderItemByModelNo(order, modelNo).orElse(null);
		
		return (orderItem != null) ? orderItem.getQuantity() : 0;
	}
	
	/** Method to add Voucher to Cart into database table */
	@Override
	public boolean addVoucherToCart(CartVoucherDto dto) {
		OrderModel order = repo.findCartByUserName(dto.userName);
		if(order == null) {
			return false;
		}
		order.setVoucherDiscount(dto.voucherDiscount);
		repo.save(order);
		return true;
	}
	
	/** Method to Place Order into database table */
	@Override
	@Transactional
	public Integer placeOrder(OrderPlaceDto dto) {
		OrderModel order = repo.findCartByUserName(dto.userName);
		AddressModel address = addressRepo.findById(dto.addressId).orElse(null);
		PaymentMethodModel paymentMethod = methodRepo.findById(dto.transaction.paymentMethodId).orElse(null);
		if(order == null || address == null || paymentMethod == null) {
			return null;
		}
		TransactionModel transaction = getNewTransaction(paymentMethod, dto.transaction.amount);
		linkOrderWithTransaction(order, transaction);
		order.setOrderStatus(Status.PLACED);
		order.setPlacedAt(new Date());
		order.setAddress(address);
		mailService.sendOrderSuccessMail(order.getUser().getEmail(), order.getTransactions().getPrice());
		return order.getOrderId();
	}
	
	/** Method to get all Orders from database table */
	@Override
	public List<OrderDto> getAllOrders(String userName) {
		Sort sortByPlacedDate = Sort.by(Sort.Direction.ASC, "placedAt");
		List<OrderModel> orders = repo.findAllPreviousOrders(userName, sortByPlacedDate);
		List<OrderDto> response = orders.stream().map(ord -> mapper.map(ord, OrderDto.class)).collect(Collectors.toList());
		return response;
	}
	private OrderModel createCartOrder(CartRequestDto dto) {
		UserModel user = userRepo.findByUserName(dto.userName);
		OrderModel order = new OrderModel();
		order.setUser(user);
		order.setOrderStatus(Status.IN_CART);
		order = repo.save(order);
		return order;
	}
	
	private Integer addItemToCart(OrderModel order, Integer productId, Integer quantity) {
		OrderItemModel cartItem = getOrderItemByProductId(order, productId).orElse(null);
		if(cartItem == null) {
			cartItem = new OrderItemModel();
			Optional<ProductModel> product = productRepo.findById(productId);
			if(product.get() == null) {
				return 0;
			}
			cartItem.setProduct(product.get());
			linkCartWithCartItem(order, cartItem);
		}
		cartItem.setQuantity(quantity);
		cartItem.setBoughtAtDiscount((float)cartItem.getProduct().getDiscount());
		cartItem.setBoughtAtPrice(cartItem.getProduct().getPrice());
		return getNumOrderItems(order);
	}
	
	private Integer removeItemFromCart(OrderModel order, Integer productId) {
		OrderItemModel cartItem = getOrderItemByProductId(order, productId).orElse(null);
		if(cartItem != null) {
			unlinkCartWithCartItem(order, cartItem);
		}
		return getNumOrderItems(order);
	}
	
	private void linkCartWithCartItem(OrderModel order, OrderItemModel item) {
		order.getOrderItems().add(item);
		item.setOrder(order);		
	}
	
	private void unlinkCartWithCartItem(OrderModel order, OrderItemModel item) {
		order.getOrderItems().remove(item);
		item.setOrder(null);
	}
	
	private Integer getNumOrderItems(OrderModel order) {
		return order.getOrderItems().stream().mapToInt((item) -> item.getQuantity()).sum();
	}
	
	private TransactionModel getNewTransaction(PaymentMethodModel paymentMethod, Float amount) {
		TransactionModel transaction = new TransactionModel();
		transaction = transactionRepo.save(transaction);
		transaction.setPaymentMethod(paymentMethod);
		transaction.setPrice(amount);
		
		return transaction;
	}
	
	private void linkOrderWithTransaction(OrderModel order, TransactionModel transaction) {
		transaction.setOrder(order);
		order.setTransactions(transaction);
	}
}

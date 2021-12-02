/**
* This class describes services for Orders.
* Methods for updating order items in cart, fetching user cart, quantity in cart & all orders, adding voucher to cart & placing order .
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services;

import java.util.List;

import com.ibm.model.entities.dto.CartDto;
import com.ibm.model.entities.dto.CartRequestDto;
import com.ibm.model.entities.dto.CartVoucherDto;
import com.ibm.model.entities.dto.OrderDto;
import com.ibm.model.entities.dto.OrderPlaceDto;

public interface OrderService {

	public Integer updateOrderItems(CartRequestDto item);
	
	public CartDto getUserCart(String username);
	
	public Integer getQuantityInCart(String userName, String modelNo);
	
	public boolean addVoucherToCart(CartVoucherDto dto);
	
	public Integer placeOrder(OrderPlaceDto dto);
	
	public List<OrderDto> getAllOrders(String userName);
}

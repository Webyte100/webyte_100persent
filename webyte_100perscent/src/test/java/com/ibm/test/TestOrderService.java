package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.model.entities.BrandModel;
import com.ibm.model.entities.OrderItemModel;
import com.ibm.model.entities.OrderModel;
import com.ibm.model.entities.dto.CartDto;
import com.ibm.model.entities.dto.OrderDto;
import com.ibm.services.OrderService;

@ExtendWith(SpringExtension.class)
public class TestOrderService {
	
	@Autowired
	private OrderService service;
	
	@Test
	public void testUpdateOrderItems() {
		OrderItemModel o1 = new OrderItemModel();
		o1.setOrderItemId(1);
		o1.setOrder(null);
		o1.setProduct(null);
		o1.setQuantity(5);
		o1.setBoughtAtPrice(200);
		o1.setBoughtAtDiscount((float) 11);
	}

	@Test
	public void testFetchUserCart() {
		CartDto c1 = service.getUserCart("");
		assertNotNull(c1);
	}
	
	@Test
	public void testInvalidFetchUserCart() {
		CartDto c1 = service.getUserCart("");
		assertNull(c1);
	}
	
	@Test
	public  void testFetchQuantityInCart() {
		Integer c1 = service.getQuantityInCart(" ", " ");
		assertNotNull(c1);
	}
	
	@Test
	public  void testInvalidFetchQuantityInCart() {
		Integer c1 = service.getQuantityInCart(" ", " ");
		assertNull(c1);
	}

	@Test
	public  void testAddVoucherToCart() {
		boolean c1 = service.addVoucherToCart(null);
		assertTrue(c1);
	}
	
	@Test
	public  void testInvalidAddVoucherToCart() {
		boolean c1 = service.addVoucherToCart(null);
		assertFalse(c1);
	}
	
	@Test
	public  void testPlaceOrder() {
		Integer c1 = service.placeOrder(null);
		assertNotNull(c1);
	}
	
	@Test
	public  void testInvalidPlaceOrder() {
		Integer c1 = service.placeOrder(null);
		assertNull(c1);
	}
	
	@Test
	public void testFetchAllOrders() {
		List<OrderDto> orders = service.getAllOrders(" ");
		assertNotNull(orders);
	}
	
	@Test
	public void testInvalidFetchAllOrders() {
		List<OrderDto> orders = service.getAllOrders(" ");
		assertNull(orders);
	}
}

package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Order;
import com.ibm.service.OrderService;


@ExtendWith(SpringExtension.class)
public class TestOrderService {
	
	@Autowired
	private OrderService service;
	
	@Test
	public void testfindAllOrders() {
		List<Order> orders = service.findAllOrders();
		assertNotNull(orders);
	}
	
	@Test
	public void testInvalidfindAllOrders() {
		List<Order> orders = service.findAllOrders();
		assertNull(orders);
	}
}

package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Order;
import com.ibm.service.OrderService;
import com.ibm.service.OrderServiceImpl;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceImpl service;
	
	@GetMapping(value="/orders", produces="application/json")
	public List<Order> getOrders(){
		return service.getAll();
	}
}

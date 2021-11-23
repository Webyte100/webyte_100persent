package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Order;
import com.ibm.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping(value="/orders", produces="application/json")
	public List<Order> getAll(){
		return service.findAllOrders();
	}
}

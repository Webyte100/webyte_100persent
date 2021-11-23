package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ibm.entity.Order;
import com.ibm.entity.OrderItem;
import com.ibm.entity.Product;
import com.ibm.service.OrderItemServiceImpl;
import com.ibm.service.ProductServiceImpl;

@RestController
public class OrderItemController {
	@Autowired
	private OrderItemServiceImpl service;
	
	@GetMapping(value="/order_item", produces="application/json")
	public List<OrderItem> getOrder(){
		return service.getAll();
	}
	
	@PostMapping(value="/order_item", consumes="application/json")
	public void postOrder(OrderItem item) {
		service.save(item);
	}
	
	@DeleteMapping(value="/order_item")
	public void del(@RequestBody int order_id) {
		service.delete(order_id);
	}
	
	
	

}

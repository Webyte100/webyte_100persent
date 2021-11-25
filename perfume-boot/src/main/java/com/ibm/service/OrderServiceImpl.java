package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Order;
import com.ibm.repo.OrderRepository;

@Service
public class OrderServiceImpl {
	
	@Autowired
	private OrderRepository ord_repo;
	
	public Order find(int order_id) {
		return ord_repo.getById(order_id);
	}
	
	public List<Order> getAll(){
		return ord_repo.findAll();
	}
}

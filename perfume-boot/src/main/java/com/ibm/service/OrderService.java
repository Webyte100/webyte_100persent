package com.ibm.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Order;

public interface OrderService {
	
	List<Order> findAllOrders();
	
}

package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.OrderItem;
import com.ibm.entity.Product;
import com.ibm.repo.OrderItemRepository;

@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository repo;
	
	
	public List<OrderItem> getAll(){
		return repo.findAll();
	}
	@Override
	public void save(OrderItem i) {
		repo.save(i);
	}

	@Override
	public void delete(int product) {
		repo.deleteById(product);
	}

	@Override
	public void updatePrice(int id, long price) {
		OrderItem item = repo.findById(id).orElse(null);
		item.setPrice(price);
		repo.save(item);
	}

	
	
}

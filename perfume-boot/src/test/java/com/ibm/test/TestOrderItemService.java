package com.ibm.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.OrderItem;
import com.ibm.entity.Product;
import com.ibm.service.OrderItemService;
import com.ibm.service.OrderItemServiceImpl;

@ExtendWith(SpringExtension.class)
public class TestOrderItemService{

	@Autowired
	private OrderItemService service;
		 
	@Test
	public void testSave() {
		OrderItem item = new OrderItem();
		item.setItemId(1);
		item.setPrice(100);
		item.setQuantity(3);
		item.setSKU(10000);
		
		service.save(item);
	}
	
	@Test
	public void testDelete() {
		service.delete(1);
	}
	
	@Test
	public void testUpdatePrice() {
		OrderItem item = new OrderItem();
		item.setPrice();
		service.updatePrice(1, 100);
	}
	
}

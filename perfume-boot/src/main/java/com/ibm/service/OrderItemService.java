package com.ibm.service;

import java.util.List;

import com.ibm.entity.OrderItem;
import com.ibm.entity.Product;

public interface OrderItemService {
	
	void save(OrderItem item);
	
//	Product findAllProductsByorderId();
	
//	List<Product> findAllProducts();
	
	void delete(int product);
		
//	void updateProduct(int quantity);
		
	void updatePrice(int id, long price);

}





	
	
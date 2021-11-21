package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Product;
import com.ibm.service.ProductService;

@ExtendWith(SpringExtension.class)
public class TestProductService {

	@Autowired
	private ProductService service;
	
	@Test
	public void testSaveProduct() {
		Product p1 = new Product();
		p1.setProdName("Eva");
		p1.setProdDesc("");
		p1.setCategory("");
		p1.setSku(50);
		p1.setPrice(250);
		p1.setDiscount(10);
		p1.setQuantity(100);
		p1.setSummary("");
		
		service.saveProduct(p1);
	}
	
	@Test
	public void testFetchAllProducts() {
		List<Product> products = service.findAllProducts();
		assertNotNull(products);
	}
	
	@Test
	public void testFetchProductsByName() {
		List<Product> products = service.findAllProductsByName("Axe");
		assertNotNull(products);
	}
	
	@Test
	public void testInvalidFetchProductsByName() {
		List<Product> products = service.findAllProductsByName("Fogg");
		assertNull(products);
	}
	
	@Test
	public void testFetchProductsByPrice() {
		List<Product> products = service.findAllProductsByPrice(250);
		assertNotNull(products);
	}
	
	@Test
	public void testInvalidFetchProductsByPrice() {
		List<Product> products = service.findAllProductsByPrice(250);
		assertNull(products);
	}
	
	@Test
	public void testFetchProductsByCategory() {
		List<Product> products = service.findAllProductsByCategory("Female");
		assertNotNull(products);
	}
	
	@Test
	public void testInvalidFetchProductsByCategory() {
		List<Product> products = service.findAllProductsByCategory("Female");
		assertNull(products);
	}
	
	@Test
	public void testFetchProductsByDiscount() {
		List<Product> products = service.findAllProductsByDiscount(20);
		assertNotNull(products);
	}
	
	@Test
	public void testInvalidFetchProductsByDiscount() {
		List<Product> products = service.findAllProductsByDiscount(20);
		assertNull(products);
	}
}

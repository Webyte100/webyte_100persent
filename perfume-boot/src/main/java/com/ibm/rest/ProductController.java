package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Product;
import com.ibm.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(value="/product", consumes="application/json")
	public String addProduct(@RequestBody Product p) {
		service.saveProduct(p);
		return "Product Added in the list";
	}
	
	@GetMapping(value="/products", produces="application/json")
	public List<Product> getAll(){
		return service.findAllProducts();
	}
	
	@GetMapping(value="/products/{name}", produces="application/json")
	public List<Product> getProductByName(@PathVariable String prodName) {		//getProductByName
		return service.findAllProductsByName(prodName);
	}
	
	@GetMapping(value="/products/{price}", produces="application/json")
	public List<Product> getProductsByPrice(@PathVariable long price) {			//ByPrice
		return service.findAllProductsByPrice(price);
	}
	
	@GetMapping(value="/products/{category}", produces="application/json")
	public List<Product> getProductsByCategory(@PathVariable String category) {			//ByCategory
		return service.findAllProductsByCategory(category);
	}
	
	@GetMapping(value="/products/{discount}", produces="application/json")
	public List<Product> getProductsByDiscount(@PathVariable int discount) {			//ByDiscount
		return service.findAllProductsByDiscount(discount);
	}
}

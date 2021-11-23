package com.ibm.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.entity.Product;
import com.ibm.repo.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Qualifier("productRepository")
	@Autowired
	private ProductRepository prod_repo;

	@Transactional
	@Override
	public void saveProduct(Product product) {
		prod_repo.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		return prod_repo.findAll();
	}

	@Override
	public List<Product> findAllProductsByName(String prodName) {
		return prod_repo.findProductByProductName(prodName);
	}

	@Override
	public List<Product> findAllProductsByPrice(long price) {
		return prod_repo.findProductByPrice(price);
	}

	@Override
	public List<Product> findAllProductsByCategory(String category) {
		return prod_repo.findProductByCategory(category);
	}

	@Override
	public List<Product> findAllProductsByDiscount(int discount) {
		return prod_repo.findProductByDiscount(discount);
	}
	
	public List<Product> findByRange(int min, int max){
		List<Product> prod = new ArrayList<Product>();
		for( Product p: prod_repo.findAll() ) { 
			//Using a for-each loop to access all products
			if(p.getPrice()>=min && p.getPrice()<=max)
				prod.add(p);
			//Checking price and adding to list
		}
		return prod;
	}
	
}

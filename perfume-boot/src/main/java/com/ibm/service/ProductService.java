package com.ibm.service;

import java.util.List;
import com.ibm.entity.*;

public interface ProductService {
	
	    void saveProduct(Product product);

	    List<Product> findAllProducts();
	    
//	    List<Product> findAllProductsByPriceRange(String priceRange);
	    
	    List<Product> findAllProductsByName(String prodName);
	    
	    List<Product> findAllProductsByPrice(long price);
	    
	    List<Product> findAllProductsByCategory(String category);
	    
	    List<Product> findAllProductsByDiscount(int discount);   
}

package com.ibm.service;

import java.util.List;
import com.ibm.entity.*;

public interface ProductService {
	    void saveProduct(Product product);

	    List<Product> findAllProducts();

	    List<Product> findAllProductByName(String prodName);
	    
	    List<Product> findAllProductByPrice(long price);
	    
	    List<Product> findAllProductByCategory(String category);
	    
	    List<Product> findAllProductByDiscount(int discount);    

}

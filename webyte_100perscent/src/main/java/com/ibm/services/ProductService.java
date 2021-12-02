/**
* This class describes services for Product.
* Methods for adding products, list all products & fetching Product based on query, delete product, fetch products by model number and update products.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services;

import java.util.List;

import com.ibm.model.entities.ProductListModel;
import com.ibm.model.entities.ProductModel;
import com.ibm.model.entities.dto.ProductDto;
import com.ibm.model.request.ProductParams;

public interface ProductService {
	
	public boolean addProduct(ProductDto product);
	
	public List<ProductModel> getAllPerfumes();
	
	public List<ProductListModel> getPartialPerfumes(ProductParams query);
	
	public ProductModel getAllPerfumeByModel(String modelNo);
	
	public boolean deleteProduct(String modelNo);
	
	public List<ProductModel> getSimilarProducts(String modelNo);
	
	public boolean updateProduct(ProductDto dto);
}

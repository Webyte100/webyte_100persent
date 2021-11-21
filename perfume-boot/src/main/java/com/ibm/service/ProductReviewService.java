package com.ibm.service;

import java.util.List;

import com.ibm.entity.ProductReview;

public interface ProductReviewService {
	
	void saveReview(ProductReview review);
	
	List<ProductReview> findReviewByRating(int rating);
	
	//ProductReview findReviewByProduct(String prodName);			//Product is other entity
	
	//ProductReview findReviewByTitle(String Title);
	
	//Optional<ProductReview> findAllProductsByRating(int rating);
	

}

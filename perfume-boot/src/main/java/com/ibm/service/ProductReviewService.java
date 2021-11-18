package com.ibm.service;

import java.util.Optional;

import com.ibm.entity.ProductReview;

public interface ProductReviewService {
	
	Optional<ProductReview> findAllProductsByRating(int rating);
	

}

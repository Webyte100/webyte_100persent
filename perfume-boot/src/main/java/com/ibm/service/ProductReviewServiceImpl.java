package com.ibm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.entity.ProductReview;
import com.ibm.repo.ProductReviewRepository;

@Service("productReviewService")
public class ProductReviewServiceImpl implements ProductReviewService{

	@Qualifier("productReviewRepository")
	
	@Autowired
	private ProductReviewRepository prodrev_repo;
	
//	@Override
//	public Optional<ProductReview> findAllProductsByRating(int rating) {
//		return prodrev_repo.findProductByRating(rating) ;
//	}
	
	@Override
	public void saveReview(ProductReview review) {
		prodrev_repo.save(review);
		
	}
	@Override
	public List<ProductReview> findReviewByRating(int rating) {
		return prodrev_repo.findProductByRating(rating);
	}
}

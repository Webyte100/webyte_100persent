package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.ProductReview;
import com.ibm.service.ProductReviewService;

@ExtendWith(SpringExtension.class)
public class TestProductReviewService {

	@Autowired
	private ProductReviewService service;
	
	@Test
	public void testSaveReview() {
		ProductReview r1 = new ProductReview();
		r1.setTitle("");
		r1.setRating(9);
		r1.setRevDesc("");
		
		service.saveReview(r1);
	}
	
	@Test
	public void testFindReviewByRating() {
		List<ProductReview> review = service.findReviewByRating(9);
		assertNotNull(review);
	}
	
	@Test
	public void testInvalidFindReviewByRating() {
		List<ProductReview> review = service.findReviewByRating(9);
		assertNull(review);
	}
}

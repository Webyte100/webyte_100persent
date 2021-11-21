package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.ProductReview;
import com.ibm.service.ProductReviewService;

@RestController
public class ProductReviewController {

	@Autowired
	private ProductReviewService service;
	
	@PostMapping(value="/review", consumes="application/json")
	public String addReview(@RequestBody ProductReview r) {
		service.saveReview(r);
		return "Review has been created";
	}
	
	@GetMapping(value="/review/{rating}", produces="application/json")
	public List<ProductReview> getReview(@PathVariable int rating) {
		return service.findReviewByRating(rating);
	}
}

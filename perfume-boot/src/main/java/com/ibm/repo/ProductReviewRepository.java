package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entity.ProductReview;

@Repository("ProductReviewRepository")
public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {

	List<ProductReview> findProductByRating(int rating);
	
}

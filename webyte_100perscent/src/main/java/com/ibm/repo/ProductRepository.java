/**
* This class describes the repository of Product.
* Methods for finding all products, deleting & finding  products by model number, finding rating of a products are implemented
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.model.entities.ProductListModel;
import com.ibm.model.entities.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer>, JpaSpecificationExecutor<ProductModel>{
	
	public List<ProductModel> findAll();
	
	public List<ProductListModel> findAllBy();
	
	public Long deleteByModelNo(String modelNo);

	public ProductModel findByModelNo(String modelNo);
	
	@Query("SELECT w.starRating FROM ProductModel w WHERE w.modelNo = :modelNo")
	public float getRating(@Param("modelNo") String modelNo);
	
	public List<ProductModel> findByModelNoNotAndStarRatingBetweenOrderByStarRatingDesc(String modelNo, float lower, float higher, Pageable pager);
}

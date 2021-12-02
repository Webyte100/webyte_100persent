/**
* This class describes the repository of Product Brand.
* Method to find Product by Brand Name.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.entities.BrandModel;

@Repository
public interface BrandRepository extends JpaRepository<BrandModel, Integer> {
	BrandModel findByName(String brandName);
}

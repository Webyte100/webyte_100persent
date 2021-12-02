/**
* This class describes service Implementations for Brands.
* Methods for adding brands and getting brands.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.BrandModel;
import com.ibm.repo.BrandRepository;
import com.ibm.services.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	/**Injecting repository for Brand database interaction*/
	@Autowired
	private BrandRepository repo;
	
	/** Method to get All Brands from database table */
	@Override
	public List<BrandModel> getAllBrands() {
		return repo.findAll();
	}

	/** Method to Add Brands into database*/
	@Override
	public BrandModel addBrand(BrandModel brand) {
		return this.repo.save(brand);
	}
	
}

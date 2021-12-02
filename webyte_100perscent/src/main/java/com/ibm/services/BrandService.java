/**
* This class describes services for Brands.
* Methods for adding brands and getting brands.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services;

import java.util.List;

import com.ibm.model.entities.BrandModel;

public interface BrandService {
	
	public List<BrandModel> getAllBrands();
	
	public BrandModel addBrand(BrandModel brand);
}

/**
*This class describes Controllers for Brands 
*Adding brands by using PostMapping and fetching brands by GetMapping
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/


package com.ibm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.entities.BrandModel;
import com.ibm.services.BrandService;

@RestController
@CrossOrigin
@RequestMapping("brands")
public class BrandsController {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllBrands() {
		return ResponseEntity.ok(brandService.getAllBrands());
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addBrand(@RequestBody BrandModel brand) {
		return ResponseEntity.ok(brandService.addBrand(brand));
	}
}

package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.model.entities.BrandModel;
import com.ibm.services.BrandService;


@ExtendWith(SpringExtension.class)
public class TestBrandService {
	
	@Autowired
	private BrandService service;
	
	
	@Test
	public void testFetchAllBrands() {
		List<BrandModel> brands = service.getAllBrands();
		assertNotNull(brands);
	}
	
	@Test
	public void testInvalidFetchAllBrands() {
		List<BrandModel> brands = service.getAllBrands();
		assertNull(brands);
	}
	
	@Test
	public void testAddBrand() {
		BrandModel b1 = new BrandModel();
		b1.setBrandId(1);
		b1.setName("Versace");
		b1.setImageUrl("C:\\Users\\002JSP744\\Pictures\\case study\\v 2");
		b1.setShortDesc("women fragrance");
		
		service.addBrand(b1);
	}

}
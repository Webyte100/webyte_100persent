package com.ibm.test;

//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.ibm.model.entities.BrandModel;
//import com.ibm.model.entities.ProductListModel;
//import com.ibm.model.entities.ProductModel;
//import com.ibm.services.ProductService;
//
//@ExtendWith(SpringExtension.class)
//public class TestProductService {
//	
//	@Autowired
//	private ProductService service;
//	
//	@Test
//	public void testAddProduct() {
//		ProductModel p1 = new ProductModel();
//		p1.setName(" ");
//		p1.setPrice(2000);
//		p1.setSeries(" ");
//		p1.setModelNo("10");
//		p1.setCategory("deodorant");
//		p1.setStarRating(4);
//		p1.setDiscount(30);
//		p1.setExpiryDate(18);
//		p1.setImages(p1<id>);
//		p1.setBrand(" ");
//		p1.setCollection(" ");
//		
//		service.addProduct(p1);
//	}
//	
//	@Test
//	public void testFetchAllPerfumes() {
//		List<ProductModel> perfumes = service.getAllPerfumes();
//		assertNotNull(perfumes);
//	}
//	
//	@Test
//	public void testInvalidFetchAllBrands() {
//		List<ProductModel> perfumes = service.getAllPerfumes();
//		assertNull(perfumes);
//	}
//	
//	@Test
//	public void testFetchPartialPerfumes() {
//		List<ProductListModel> p_perfumes = service.getPartialPerfumes(null);
//		assertNotNull(p_perfumes);
//	}
//	
//	@Test
//	public void testInvalidFetchPartialPerfumes() {
//		List<ProductListModel> perfumes = service.getPartialPerfumes(null);
//		assertNull(perfumes);
//	}
//	
//	@Test
//	public void testFetchAllPerfumesByModel() {
//		ProductModel p1 = service.getAllPerfumeByModel("");
//		assertNotNull(p1);
//	}
//	
//	@Test
//	public void testInvalidFetchAllPerfumesByModel() {
//		ProductModel p1 = service.getAllPerfumeByModel("");
//		assertNull(p1);
//	}
//	
//	@Test
//	public void testDeleteProduct() {
//		service.deleteProduct("");
//	}
//	
//	@Test
//	public void testFetchSimilarProducts() {
//		List<ProductModel> s_perfumes = service.getSimilarProducts(null);
//		assertNotNull(s_perfumes);
//	}
//	
//	@Test
//	public void testInvalidFetchSimilarProducts() {
//		List<ProductModel> s_perfumes = service.getSimilarProducts(null);
//		assertNull(s_perfumes);
//	}
//	
//	@Test
//	public void testUpdateProduct() {
//		service.updateProduct(null);
//	}
//}

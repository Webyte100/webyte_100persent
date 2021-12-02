/**
*This class describes Controllers for Products 
*Adding products by using PostMapping and fetching all products, products & similar products by model number by GetMapping
*Fetch partial products according to query given using GetMapping, delete Products by DeleteMapping and updating Products by PutMapping
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.entities.ProductListModel;
import com.ibm.model.entities.ProductModel;
import com.ibm.model.entities.dto.ProductDto;
import com.ibm.model.request.ProductParams;
import com.ibm.services.ProductService;

@RestController
@RequestMapping("products")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addProduct(@RequestBody ProductDto product) {
		boolean isSaved = productService.addProduct(product);
		return ResponseEntity.ok(new Object() {public boolean result = isSaved;});
	}
	
	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProducts() {
		List<ProductModel> perfumes = productService.getAllPerfumes();
		return ResponseEntity.ok(perfumes);
	}
	
	@GetMapping(value = "{modelNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProduct(@PathVariable String modelNo) {
		ProductModel perfume = productService.getAllPerfumeByModel(modelNo);
		ProductDto response = mapper.map(perfume, ProductDto.class);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "similarProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSimilarProducts(@RequestParam String modelNo) {
		List<ProductModel> perfumes = productService.getSimilarProducts(modelNo);
		return ResponseEntity.ok(perfumes);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPartialProducts(ProductParams query) {
		List<ProductListModel> perfumes = productService.getPartialPerfumes(query);
		return ResponseEntity.ok(perfumes);
	}
	
	@DeleteMapping(value = "{modelNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteProduct(@PathVariable String modelNo) {
		boolean isDeleted = productService.deleteProduct(modelNo);
		return ResponseEntity.ok(new Object() {public boolean result = isDeleted;});
	}
	
	@PutMapping(value = "edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProduct(@RequestBody ProductDto dto) {
		try {
			boolean isUpdated = productService.updateProduct(dto);
			return ResponseEntity.ok(new Object() {public boolean result = isUpdated;});
		}
		catch(DataIntegrityViolationException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

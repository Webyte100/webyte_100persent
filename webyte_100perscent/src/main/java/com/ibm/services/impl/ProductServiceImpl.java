/**
* This class describes service Implementations for Product.
* Methods for adding products, list all products & fetching Product based on query, delete product, fetch products by model number and update products.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.BrandModel;
import com.ibm.model.entities.CollectionModel;
import com.ibm.model.entities.ProductListModel;
import com.ibm.model.entities.ProductModel;
import com.ibm.model.entities.dto.ProductDto;
import com.ibm.model.request.ProductParams;
import com.ibm.repo.BrandRepository;
import com.ibm.repo.CollectionRepository;
import com.ibm.repo.ProductRepository;
import com.ibm.services.ProductService;
import com.ibm.services.common.HelpService;

@Service
public class ProductServiceImpl extends HelpService implements ProductService {

	/**Injecting repository for Product database interaction*/
	@Autowired
	private ProductRepository repo;
	
	/**Injecting repository for Brand database interaction*/
	@Autowired
	private BrandRepository brandRepo;
	
	/**Injecting repository for Collection database interaction*/
	@Autowired
	private CollectionRepository collectionRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	private Pageable first4Products = PageRequest.of(0, 4);
	private static final float MAX_RATING = 5;
	private static final float MIN_RATING = 0;
	
	/** Method to add Product Details into database table */
	@Override
	public boolean addProduct(ProductDto dto) {
		ProductModel product = mapper.map(dto, ProductModel.class);
		
		if(dto.brand != null) {
			product.setBrand(getOrSaveBrand(dto.brand));
		}
		if(dto.collection != null) {
			product.setCollection(getOrSaveCollection(dto.collection));
		}
		
		repo.save(product);
		return true;
	}
	
	/** Method to get all Products from database table */
	@Override
	public List<ProductModel> getAllPerfumes() {
		return repo.findAll();
	}
	
	/** Method to get partial Products from database table by writing a query */
	@Override
	public List<ProductListModel> getPartialPerfumes(ProductParams query) {
		List<ProductModel> watches = repo.findAll(filterByBrandAndCollection(query.getBrandName(), query.getCollectionName()));
		return watches.stream().map(product -> mapper.map(product, ProductListModel.class))
		  .collect(Collectors.toList());
	}
	
	/** Method to delete Products by model number from database table */
	@Override
	@Transactional
	public boolean deleteProduct(String modelNo) {
		return repo.deleteByModelNo(modelNo) > 0;
	}
	
	/** Method to get all Products by model number from database table */
	@Override
	public ProductModel getAllPerfumeByModel(String modelNo) {
		return repo.findByModelNo(modelNo);
	}
	
	/** Method to get similar Products by model number from database table */
	@Override
	public List<ProductModel> getSimilarProducts(String modelNo) {
		float rating = repo.getRating(modelNo);
		float upperLimit = Math.min(MAX_RATING, rating + 1);
		float lowerLimit = Math.max(MIN_RATING, rating - 1);
		
		return repo.findByModelNoNotAndStarRatingBetweenOrderByStarRatingDesc(modelNo, lowerLimit, upperLimit, first4Products);
	}
	
	/** Method to update Products into database table */
	@Override
	public boolean updateProduct(ProductDto dto) {
		Optional<ProductModel> ref = repo.findById(dto.id);
		if(ref.isPresent()) {
			ProductModel original = ref.get();
			mapper.map(dto, original);
			repo.save(original);
			return true;
		}
		return false;
	}
	
	private BrandModel getOrSaveBrand(BrandModel brand) {
		BrandModel saved = brandRepo.findByName(brand.getName());
		if(saved == null) {
			saved = brandRepo.save(brand);
		}
		return saved;
	}
	
	private CollectionModel getOrSaveCollection(CollectionModel collection) {
		CollectionModel saved = collectionRepo.findByName(collection.getName());
		if(saved == null) {
			saved = collectionRepo.save(collection);
		}
		return saved;
	}
	
	private Specification<ProductModel> filterByBrandName(String brandName){
		  return (root, query, criteriaBuilder)-> criteriaBuilder.equal(root.join("brand").get("name"), brandName);
	}
	
	private Specification<ProductModel> filterByCollectionName(String collectionName){
		return (root, query, criteriaBuilder)-> criteriaBuilder.equal(root.join("collection").get("name"), collectionName);
	}
	
	private Specification<ProductModel> filterByBrandAndCollection(String brandName, String collectionName) {
		return Specification
				.where(brandName == null ? null : filterByBrandName(brandName))
				.and(collectionName == null ? null : filterByCollectionName(collectionName));
	}
}

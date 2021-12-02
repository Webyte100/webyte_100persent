package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.model.entities.CollectionModel;
import com.ibm.services.CollectionService;

@ExtendWith(SpringExtension.class)
public class TestCollectionService {

	@Autowired
	private CollectionService service;
	
	@Test
	public void testFetchAllCollectionModel() {
		List<CollectionModel> model = service.getAllCollections();
		assertNotNull(model);
	}
	
	@Test
	public void testInvalidFetchAllCollectionModel() {
		List<CollectionModel> model = service.getAllCollections();
		assertNull(model);
	}
	
	@Test 
	public void testAddCollection() {
		CollectionModel c1 = new CollectionModel();
		c1.setId(1);
		c1.setName("");
		
		service.addCollection(c1);
	}
}

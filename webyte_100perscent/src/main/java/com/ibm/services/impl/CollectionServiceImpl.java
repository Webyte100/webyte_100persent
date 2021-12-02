/**
* This class describes service Implementations for Collections.
* Methods for Adding and fetching Collections.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.CollectionModel;
import com.ibm.repo.CollectionRepository;
import com.ibm.services.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {

	/**Injecting repository for Collection database interaction*/
	@Autowired
	private CollectionRepository repo;
	
	/** Method to get all Collections from database table */
	@Override
	public List<CollectionModel> getAllCollections() {
		return repo.findAll();
	}

	/** Method to add Collection into database table */
	@Override
	public CollectionModel addCollection(CollectionModel collection) {
		return repo.save(collection);
	}
}

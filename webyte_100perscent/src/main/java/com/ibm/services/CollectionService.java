/**
* This class describes services for Collections.
* Methods for Adding and fetching Collections.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services;

import java.util.List;

import com.ibm.model.entities.CollectionModel;

public interface CollectionService {
	
	public List<CollectionModel> getAllCollections();
	
	public CollectionModel addCollection(CollectionModel collection);
}

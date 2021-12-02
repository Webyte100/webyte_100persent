/**
* This class describes the repository of Product Collection.
* Method to find Product by Collection Name.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.entities.CollectionModel;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionModel, Integer>{
	CollectionModel findByName(String name);
}
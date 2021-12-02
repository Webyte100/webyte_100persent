/**
* This class describes the repository of User Address.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.entities.AddressModel;

public interface AddressRepository extends JpaRepository<AddressModel, Integer> {

}

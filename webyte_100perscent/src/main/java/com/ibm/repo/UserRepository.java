/**
* This class describes the repository of User.
* Method to find User by Email and find by User name.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.entities.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

	UserModel findByEmail(String email);
	
	UserModel findByUserName(String username);
}

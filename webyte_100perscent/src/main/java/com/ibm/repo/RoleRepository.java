/**
* This class describes the repository of User Role.
* Method to find User by Role
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.model.entities.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Integer>{
	RoleModel findByRole(String role);
}

/**
* This class describes service Implementation for User Registration.
* Methods for adding user, deleting user and fetch user role.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.services.impl;

import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.RoleModel;
import com.ibm.model.entities.UserModel;
import com.ibm.model.entities.enumerations.Roles;
import com.ibm.model.exceptions.InvalidDataException;
import com.ibm.repo.RoleRepository;
import com.ibm.repo.UserRepository;
import com.ibm.security.encoder.BCryptEncoder;
import com.ibm.services.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	/**Injecting repository for User database interaction*/
	@Autowired
	private UserRepository repo;
	
	/**Injecting repository for Role database interaction*/
	@Autowired
	private RoleRepository roleRepo;

	/** Method to add User Details from database table */
	@Override
	public Boolean addUser(UserModel user) throws InvalidDataException {
		BCryptEncoder encoder = new BCryptEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.getRoles().add(getUserRole());
		try {
			repo.save(user);
			return true;
		} catch (Exception e) {
			throw new InvalidDataException();
		}
	}

	/** Method to delete User Details from database table */
	@Override
	public Boolean deleteUser(UserModel user) {
		if (repo.findById(user.getId()) != null) {
			repo.delete(user);
			return true;
		}
		return false;
	}
	
	private RoleModel getUserRole() {
		return roleRepo.findByRole(Roles.US.toString());
	}
}

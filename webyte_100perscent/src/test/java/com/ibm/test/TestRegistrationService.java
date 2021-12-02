package com.ibm.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.model.entities.UserModel;
import com.ibm.services.RegistrationService;

@ExtendWith(SpringExtension.class)
public class TestRegistrationService {

	@Autowired
	private RegistrationService service;
	
	@Test
	public void testAddUser() {
		UserModel u1 = new UserModel();
		u1.setUserName(" ");
		u1.setPassword(" ");
		u1.setEmail(" ");
		u1.setDateCreated(null);
		u1.setRoles(null);
		u1.setPhoneNo("9876543210");
		u1.setImage(" ");
		
		service.addUser(u1);
	}
	
	@Test
	public void testDeleteUser() {
		service.deleteUser(null);
	}
	

}

package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.model.entities.AddressModel;
import com.ibm.model.entities.UserModel;
import com.ibm.model.entities.dto.AddressDto;
import com.ibm.model.entities.dto.UserProfileDto;
import com.ibm.services.UserService;

@ExtendWith(SpringExtension.class)
public class TestUserService {

	@Autowired
	private UserService service;
	
	@Test
	public void testFetchUserDetails() {
		UserProfileDto u1 = service.getUserDetails("");
		assertNotNull(u1);
	}
	
	@Test
	public void testInvalidFetchUserDetails() {
		UserProfileDto u1 = service.getUserDetails("");
		assertNull(u1);
	}
	
	@Test
	public void testFetchUserAddresses() {
		List<AddressDto> addresses = service.getUserAddresses("");
		assertNotNull(addresses);
	}
	
	@Test
	public void testSaveAddress() {
		AddressModel a1 = new AddressModel();
		a1.setAddressId(10);
		a1.setUser(null);
		a1.setName("vv");
		a1.setType(null);
		a1.setAddress("ATP");
		a1.setState("A.P. ");
		a1.setCity("ATP");
		a1.setCountry("INDIA");
		a1.setPincode(515144);
		
		service.saveAddress(null, "vv");	
	}
	
	@Test
	public void testDeleteUserAddress() {
		service.deleteUserAddress(" ", 10);
	}
	
	@Test
	public void testAssignAdmin() {
		service.assignAdmin(" ");
		
	}
	
}
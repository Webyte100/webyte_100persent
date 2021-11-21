package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.User;
import com.ibm.service.UserService;

@ExtendWith(SpringExtension.class)
public class TestUserService {

	@Autowired
	private UserService service;
	
	@Test
	public void testSaveUser() {
		User u1 = new User();
		u1.setFullName("Payal");
		u1.setEmailId("payal@gmail.com");
		u1.setPasswd("payu0987");
		u1.setPhoneNo(1080909090);
		u1.setLineOne("123, Road 1");
		u1.setLineTwo("New Street");
		u1.setCity("Mumbai");
		u1.setState("Maharastra");
		u1.setPincode(109010);
		
		service.saveUser(u1);
	}
	
	@Test
	public void testFindUserByMailAndPassword() {
		User u1 = service.findUserByEmailAndPasswd("payal@gmail.com", "payu0987");
		assertNotNull(u1);
	}
	
	@Test
	public void testInvalidFindUserByMailAndPassword() {
		User u1 = service.findUserByEmailAndPasswd("payal@gmail.com", "payu789");
		assertNull(u1);
	}
	
	@Test
	public void testFindUserByPhone() {
		User u1 = service.findUserByPhoneNumber(1234214251);
		assertNotNull(u1);
	}
	
	@Test
	public void testInvalidFindUserByPhone() {
		User u1 = service.findUserByPhoneNumber(1234214251);
		assertNull(u1);
	}
	
	@Test
	public void testFetchAllUsers() {
		List<User> users = service.getAllUsers();
		assertNotNull(users);
	}
}

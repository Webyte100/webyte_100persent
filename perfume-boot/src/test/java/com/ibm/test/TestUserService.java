package com.ibm.test;

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
	private TestUserService service;
	
	@Test
	public void testSaveUser() {
		User u1 = new User();
		u1.setFullName("yashu");
		u1.setEmailId("yashu@gmail");
		u1.setPasswd("vihitha");
		u1.setPhoneNo(1234567890);
		u1.setLineOne("XYZ");
		u1.setLineTwo("ABC");
		u1.setCity("ATM");
		u1.setState("MH");
		u1.setPincode(123456);
		
		service.save(u1);
	}
	
	@Test
	public void testfindUserByEmailAndPasswd() {
		User u1 = service.findUserByEmailAndPasswd("yashu@gmail","vihitha");
	}


	

}

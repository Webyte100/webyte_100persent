package com.ibm.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.services.UserProfileUpdateService;

@ExtendWith(SpringExtension.class)
public class TestUserProfileUpdateService {
	
	@Autowired
	private UserProfileUpdateService service;
	
	@Test
	public void testUpdateProfileImage() {
		service.updateProfileImage(null);
		
	}

}

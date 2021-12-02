package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.services.DatabaseUserDetailsService;

@ExtendWith(SpringExtension.class)
public class TestDatabaseUserDetailsService {
	
	@Autowired
	private DatabaseUserDetailsService service;
	
	@Test
	public void testFindByUserName() {
		UserDetails u1 = service.loadUserByUsername(" ");
		assertNotNull(u1);
	}
	
	@Test
	public void testInvalidFindByUserName() {
		UserDetails u1 = service.loadUserByUsername(" ");
		assertNull(u1);
	}
	

}

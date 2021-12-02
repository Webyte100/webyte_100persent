package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.services.OtpService;

@ExtendWith(SpringExtension.class)
public class TestOtpService {
	
	@Autowired
	private OtpService service;
	
	@Test
	public void testGenerateOtp() {
		boolean otp1 = service.generateOtp(null);
		assertTrue(otp1);
	}
	
	@Test
	public void testInvalidGenerateOtp() {
		boolean otp1 = service.generateOtp(null);
		assertFalse(otp1);
	}
	
	@Test
	public void testValidateOtp() {
		boolean otp1 = service.validateOtp(null);
		assertTrue(otp1);
	}
	
	@Test
	public void testInvalidValidateOtp() {
		boolean otp1 = service.validateOtp(null);
		assertFalse(otp1);
	}

}

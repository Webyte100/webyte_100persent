/**
*This class describes Controllers for OTP 
*Generating OTP & Validating OTP by using PostMapping.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.entities.dto.OtpDto;
import com.ibm.services.OtpService;

@RestController
@RequestMapping("otp")
@CrossOrigin
public class OtpController {
	
	@Autowired
	private OtpService otpService;
	
	@PostMapping(value = "generate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> generateOtp(@RequestBody OtpDto dto) {
		if(otpService.generateOtp(dto)) {
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping(value = "validate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> validateOtp(@RequestBody OtpDto dto) {
		Object result = new Object() {
			public boolean result = otpService.validateOtp(dto);
		};
		return ResponseEntity.ok(result);
	}
}

/**
*This class describes Controllers for Email 
*Sending Mail using PostMapping.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.services.MailService;

@RestController
@RequestMapping("email")
public class EmailController {

	@Autowired
	private MailService mailService;
	
	@PostMapping(value = "send", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sendEmail(@RequestBody EmailDto dto) {
		try {
			mailService.sendOtpMail(dto.receiverEmail, 12345);
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getMessage());
		}
		
		return ResponseEntity.ok("Email Sent");
	}
}

class EmailDto {
	public String receiverEmail;
}

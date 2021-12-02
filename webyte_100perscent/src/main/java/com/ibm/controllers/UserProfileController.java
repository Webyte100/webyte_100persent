/**
*This class describes Controllers for User Profile 
*Updating Profile Image by using PutMapping
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.entities.dto.UserProfileDto;
import com.ibm.services.UserProfileUpdateService;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserProfileController {
	
	@Autowired
	UserProfileUpdateService service;
	
	@PutMapping(value="update", consumes="application/json", produces="application/json")
	public ResponseEntity<?> updateProfileImage(@RequestBody UserProfileDto user) {
		Boolean response = service.updateProfileImage(user);
		return ResponseEntity.ok(response);
	}
}

/**
*This class describes Controllers for User Registration 
*Adding User by using PostMapping.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.entities.UserModel;
import com.ibm.model.exceptions.InvalidDataException;
import com.ibm.services.RegistrationService;

@RestController
@CrossOrigin
class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	
	@PostMapping(value = "/register", consumes = "application/json", produces="application/json")
	public void addUser(@RequestBody UserModel user) throws InvalidDataException {
			registrationService.addUser(user);
	}
	

}
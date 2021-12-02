package com.ibm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.entities.dto.LoginDto;
import com.ibm.model.entities.dto.UserDto;
import com.ibm.model.exceptions.InvalidDataException;
import com.ibm.services.LoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto addUser(@RequestBody LoginDto user) {
		if(user.username != null && user.password != null) {
			return loginService.login(user);
		}
		else throw new InvalidDataException();
	}
}

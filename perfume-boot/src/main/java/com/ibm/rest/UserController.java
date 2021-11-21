package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.User;
import com.ibm.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value="/user",consumes="application/json")
	public String addUser(@RequestBody User u) {
		service.saveUser(u);
		return "User is successfully added!";
	}
	
	@GetMapping(value="/user/{emailId}/{passwd}", produces="application/json")
	public User getUserByMailAndPassword(@PathVariable String emailId, String passwd) {
		return service.findUserByEmailAndPasswd(emailId, passwd);
	}

	@GetMapping(value="/user/{phoneNo}", produces="application/json")
	public User getUserByPhoneNo(@PathVariable long PhoneNo) {
		return service.findUserByPhoneNumber(PhoneNo);
	}
	
	@GetMapping(value="/users", produces="application/json")
	public List<User> getAll(){
		return service.getAllUsers();
	}
	
}

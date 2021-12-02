/**
* This class describes service Implementations for Login.
* Methods for User Login.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.UserModel;
import com.ibm.model.entities.dto.LoginDto;
import com.ibm.model.entities.dto.UserDto;
import com.ibm.model.exceptions.InvalidCredentialException;
import com.ibm.repo.UserRepository;
import com.ibm.security.encoder.BCryptEncoder;
import com.ibm.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	/**Injecting repository for User database interaction*/
	@Autowired
	private UserRepository repo;
	
	private BCryptEncoder encoder = new BCryptEncoder();

	/** Method to Login */
	@Override
	public UserDto login(LoginDto dto) {
		UserModel user = repo.findByUserName(dto.username);
		if(encoder.matches(user.getPassword(), dto.password)) {
			return new UserDto(user);
		}
		else throw new InvalidCredentialException();
	}
}

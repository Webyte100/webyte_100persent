/**
* This class describes service Implementations for updating User Profile.
* Method to update profile Image of user.
* @version 1.8.0_311
**/


package com.ibm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.UserModel;
import com.ibm.model.entities.dto.UserProfileDto;
import com.ibm.repo.UserRepository;
import com.ibm.services.UserProfileUpdateService;

@Service
public class UserProfileUpdateServiceImpl implements UserProfileUpdateService {

	/**Injecting repository for User database interaction*/
	@Autowired
	private UserRepository userRepo;
	
	/** Method to update User Profile Image into database table */
	@Override
	public Boolean updateProfileImage(UserProfileDto user) {
		UserModel entity = userRepo.findByUserName(user.userName);
		System.out.println(entity);
		if(entity!=null) {
			entity.setImage(user.userImage);
			userRepo.save(entity);
			return true;
		}
		else
			return false;
	}

}

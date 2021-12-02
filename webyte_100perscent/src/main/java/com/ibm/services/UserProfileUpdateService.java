/**
* This class describes services for updating User Profile.
* Method to update profile Image of user.
* @version 1.8.0_311
**/

package com.ibm.services;

import com.ibm.model.entities.dto.UserProfileDto;

public interface UserProfileUpdateService {

	public Boolean updateProfileImage(UserProfileDto user);
}

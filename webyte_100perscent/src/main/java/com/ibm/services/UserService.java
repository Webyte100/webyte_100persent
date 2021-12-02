/**
* This class describes services for User.
* Methods for fetching User details, User address, save and delete User address and assign role for user.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.services;

import java.util.List;

import com.ibm.model.entities.dto.AddressDto;
import com.ibm.model.entities.dto.UserProfileDto;

public interface UserService {
	public UserProfileDto getUserDetails(String userName);
	public List<AddressDto> getUserAddresses(String userName);
	public boolean saveAddress(AddressDto dto, String userName);
	public boolean deleteUserAddress(String userName, Integer addressId);
	public boolean assignAdmin(String username);
}

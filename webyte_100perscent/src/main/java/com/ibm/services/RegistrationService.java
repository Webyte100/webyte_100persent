/**
* This class describes services for User Registration.
* Methods for adding and deleting User.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.services;

import com.ibm.model.entities.UserModel;
import com.ibm.model.exceptions.InvalidDataException;

public interface RegistrationService {

	Boolean addUser(UserModel user) throws InvalidDataException;
	
	Boolean deleteUser(UserModel user);

}

/**
* This class describes services for Login.
* Methods for User Login.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services;

import com.ibm.model.entities.dto.LoginDto;
import com.ibm.model.entities.dto.UserDto;

public interface LoginService {

	UserDto login(LoginDto dto);
}

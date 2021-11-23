/**
* This class describes services for User. Functionalities like 
* adding User, find User by Mail and Password, find User by Phone number and find all Users
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.service;

import java.util.List;

import com.ibm.entity.User;
//import com.ibm.Login;

public interface UserService {

	    void saveUser(User user);

	    User findUserByEmailAndPasswd(String emailId, String passwd);
	    
	    User findUserByPhoneNumber(long phoneNo);
	    
	    List<User> getAllUsers();
	    
	    //User authenticate(Login login);
	}



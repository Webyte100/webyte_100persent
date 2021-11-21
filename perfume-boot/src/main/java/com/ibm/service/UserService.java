package com.ibm.service;

import java.util.List;

import com.ibm.entity.User;
//import com.ibm.pojo.Login;

public interface UserService {

	    void saveUser(User user);

	    User findUserByEmailAndPasswd(String emailId, String passwd);
	    
	    User findUserByPhoneNumber(long phoneNo);
	    
	    List<User> getAllUsers();
	    
	    //User authenticate(Login login);
	}



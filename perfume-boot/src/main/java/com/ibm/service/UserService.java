package com.ibm.service;

import java.util.List;

import com.ibm.entity.User;
//import com.ibm.pojo.Login;

public interface UserService {

	    void save(User user);

	    User findUserByEmailAndPasswd(String email, String passwd);
	    
	    User findUserByPhoneNumber(long phoneNo);
	    
	    List<User>getAllUsers();
	    
	    //User authenticate(Login login);
	}



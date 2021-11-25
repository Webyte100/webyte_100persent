/**
* This class describes service implementations for User. Functionalities like 
* adding User, find User by Mail and Password find User by Phone number, finding all Users
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.entity.User;
import com.ibm.repo.UserRepository;

@Service("userService")

public class UserServiceImpl implements UserService {
	 @Qualifier("UserRepository")
	 
	 	/** Injecting repository for User database interaction*/
	    @Autowired
	    private UserRepository user_repo;

	    @Transactional
	    @Override
	    /**Method to save User into database table*/
	    public void saveUser(User user) {
	        user_repo.save(user);
	    }

//	    @Override
	    /**Method to find User by Mail ID and Password from database*/
//	    public User findUserByEmailAndPasswd(String email, String passwd) {
//	        return user_repo.findUserByEmailAndPasswd(email, passwd);
//	    }

		@Override
		/**Method to find User by Phone Number from database*/
		public User findUserByPhoneNumber(long phoneNo) {
			return user_repo.findUserByPhoneNumber(phoneNo);
		}

		@Override
		/**Method to find all Users from database*/
		public List<User> getAllUsers() {
			return user_repo.findAll();
		}
}

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
	 @Qualifier("userRepository")
	    @Autowired
	    private UserRepository user_repo;

	    @Transactional
	    @Override
	    public void save(User user) {
	        user_repo.save(user);
	    }

	    @Override
	    public User findUserByEmailAndPasswd(String email, String passwd) {
	        return user_repo.findUserByEmailAndPasswd(email, passwd);
	    }

		@Override
		public User findUserByPhoneNumber(long phoneNo) {
			return user_repo.findUserByPhoneNumber(phoneNo);
		}

		@Override
		public List<User> getAllUsers() {
			return user_repo.findAll();
		}
}

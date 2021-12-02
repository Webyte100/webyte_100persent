/**
* This class describes services for Database User Details.
* Methods for User Data.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.UserModel;
import com.ibm.repo.UserRepository;
import com.ibm.security.authentication.UserDetailsMapper;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

	@Autowired
  private UserRepository userRepository;
	
	@Autowired
  private  UserDetailsMapper userDetailsMapper;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserModel user = userRepository.findByUserName(username);
    return userDetailsMapper.toUserDetails(user);
  }
}
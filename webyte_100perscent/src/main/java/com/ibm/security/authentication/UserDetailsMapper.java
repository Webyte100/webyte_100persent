/**
* This class describes the Mapping of User Details.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.security.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ibm.model.entities.UserModel;

@Component
public class UserDetailsMapper {

  public UserDetails toUserDetails(UserModel user) {

    return User.withUsername(user.getUserName())
        .password(user.getPassword())
        .build();
  }
}

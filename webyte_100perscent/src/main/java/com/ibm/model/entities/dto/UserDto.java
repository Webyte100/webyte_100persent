/**
* This class describes list of DTO of User.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.model.entities.dto;

import java.util.Date;
import java.util.Set;

import com.ibm.model.entities.RoleModel;
import com.ibm.model.entities.UserModel;

public class UserDto {
	public String userName;
	public String email;
	public Date dateCreated;
	public String phoneNo;
	public Set<RoleModel> roles;
	public String userImage;
	
	public UserDto(UserModel model) {
		userName = model.getUserName();
		email = model.getEmail();
		dateCreated = model.getDateCreated();
		phoneNo = model.getPhoneNo();
		userImage = model.getImage();
		roles = model.getRoles();
	}
}

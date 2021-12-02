/**
* This class describes service Implementations for User.
* Methods for fetching User details, User address, save and delete User address and assign role for user.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.entities.AddressModel;
import com.ibm.model.entities.RoleModel;
import com.ibm.model.entities.UserModel;
import com.ibm.model.entities.dto.AddressDto;
import com.ibm.model.entities.dto.UserProfileDto;
import com.ibm.model.entities.enumerations.Roles;
import com.ibm.repo.AddressRepository;
import com.ibm.repo.RoleRepository;
import com.ibm.repo.UserRepository;
import com.ibm.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	/**Injecting repository for User database interaction*/
	@Autowired
	private UserRepository userRepo;
	
	/**Injecting repository for Address database interaction*/
	@Autowired
	private AddressRepository addressRepo;
	
	/**Injecting repository for Role database interaction*/
	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private ModelMapper mapper;
	
	/** Method to get User Details from database table */
	@Override
	public UserProfileDto getUserDetails(String userName) {
		UserModel entity = userRepo.findByUserName(userName);
		return mapper.map(entity, UserProfileDto.class);
	}
	
	/** Method to get User Address from database table */
	@Override
	public List<AddressDto> getUserAddresses(String userName) {
		UserModel entity = userRepo.findByUserName(userName);
		return entity.getSavedAddresses().stream().map(addEnt -> mapper.map(addEnt, AddressDto.class)).collect(Collectors.toList());
	}

	/** Method to save User Address into database table */
	@Override
	@Transactional
	public boolean saveAddress(AddressDto dto, String userName) {
		UserModel userEntity = userRepo.findByUserName(userName);
		AddressModel addEntity = editOrCreateAddress(userEntity, dto);
		if(addEntity.isDefault()) {
			this.setAllAddressNotDefault(userEntity);
			addEntity.setDefault(true);
		}
		return true;
	}
	
	/** Method to delete User Address from database table */
	@Override
	@Transactional
	public boolean deleteUserAddress(String userName, Integer addressId) {
		UserModel userEntity = userRepo.findByUserName(userName);
		AddressModel address = userEntity.getSavedAddresses().stream().filter(add -> add.getAddressId() == addressId).findFirst().orElse(null);
		if (address == null) {
			return false;
		}
		unlinkAddressToUser(userEntity, address);
		return true;
	}
	
	/** Method to assign role to user into database*/
	@Override
	public boolean assignAdmin(String userName) {
		UserModel userEntity = userRepo.findByUserName(userName);
		RoleModel adminRole = getAdminRole();
		if(adminRole == null) {
			return false;
		}
		userEntity.getRoles().add(adminRole);
		userRepo.save(userEntity);
		return true;
	}

	private AddressModel editOrCreateAddress(UserModel user, AddressDto dto) {
		AddressModel addEntity = null;
		if(dto.id != null && dto.id > 0) {
			addEntity = user.getSavedAddresses()
							.stream()
							.filter(add -> add.getAddressId() == dto.id)
							.findFirst()
							.orElse(null);
		}
		if(addEntity == null) {
			addEntity = mapper.map(dto, AddressModel.class);
			addEntity = addressRepo.save(addEntity);
			linkAddressToUser(user, addEntity);
		}
		else {
			mapper.map(dto, addEntity);
		}
		return addEntity;
	}
	
	private void setAllAddressNotDefault(UserModel user) {
		user.getSavedAddresses().stream().forEach(add -> add.setDefault(false));
	}
	
	private void linkAddressToUser(UserModel user, AddressModel address) {
		user.getSavedAddresses().add(address);
		userRepo.save(user);
		address.setUser(user);
	}
	
	private void unlinkAddressToUser(UserModel user, AddressModel address) {
		user.getSavedAddresses().remove(address);
		address.setUser(null);
	}
	
	private RoleModel getAdminRole() {
		return roleRepo.findByRole(Roles.AD.toString());
	}

}

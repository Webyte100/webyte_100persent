/**
* This class describes service Implementations for Payment Method.
* Methods for fetching the saved cards, saving the new card details and deleting the earlier used card information.
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

import com.ibm.model.entities.PaymentMethodModel;
import com.ibm.model.entities.UserModel;
import com.ibm.model.entities.dto.PaymentMethodDto;
import com.ibm.repo.PaymentMethodRepository;
import com.ibm.repo.UserRepository;
import com.ibm.services.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

	/**Injecting repository for PaymentMethod database interaction*/
	@Autowired
	private PaymentMethodRepository methodRepo;
	
	/**Injecting repository for User database interaction*/
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	/** Method to get Saved Cards from database table */
	@Override
	public List<PaymentMethodDto> getSavedCards(String userName) {
		UserModel savedUser = userRepo.findByUserName(userName);
		if(savedUser == null)
			return null;
		return savedUser.getSavedPaymentMethods()
				.stream()
				.map(method -> mapper.map(method, PaymentMethodDto.class))
				.collect(Collectors.toList());
	}

	/** Method to save Card into database table */
	@Override
	@Transactional
	public Integer saveCard(String userName, PaymentMethodDto dto) {
		UserModel userEntity = userRepo.findByUserName(userName);
		PaymentMethodModel addEntity = editOrCreateCard(userEntity, dto);
		return addEntity.getPaymentMethodId();
	}
	
	/** Method to delete Card from database table */
	@Override
	@Transactional
	public boolean deleteCard(String userName, Integer cardId) {
		UserModel userEntity = userRepo.findByUserName(userName);
		PaymentMethodModel card = userEntity.getSavedPaymentMethods().stream().filter(add -> add.getPaymentMethodId() == cardId).findFirst().orElse(null);
		if (card == null) {
			return false;
		}
		unlinkCardToUser(userEntity, card);
		return true;
	}
	
	private PaymentMethodModel editOrCreateCard(UserModel user, PaymentMethodDto dto) {
		PaymentMethodModel addEntity = null;
		if(dto.paymentMethodId != null && dto.paymentMethodId > 0) {
			addEntity = user.getSavedPaymentMethods()
							.stream()
							.filter(card -> card.getPaymentMethodId() == dto.paymentMethodId)
							.findFirst()
							.orElse(null);
		}
		if(addEntity == null) {
			addEntity = mapper.map(dto, PaymentMethodModel.class);
			addEntity = methodRepo.save(addEntity);
			linkCardToUser(user, addEntity);
		}
		else {
			mapper.map(dto, addEntity);
		}
		return addEntity;
	}
	
	private void linkCardToUser(UserModel user, PaymentMethodModel card) {
		user.getSavedPaymentMethods().add(card);
		userRepo.save(user);
		card.setUser(user);
	}
	private void unlinkCardToUser(UserModel user, PaymentMethodModel card) {
		user.getSavedPaymentMethods().remove(card);
		card.setUser(null);
	}

}

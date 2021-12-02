/**
* This class describes services for Payment Method.
* Methods for fetching the saved cards, saving the new card details and deleting the earlier used card information.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services;

import java.util.List;

import com.ibm.model.entities.dto.PaymentMethodDto;

public interface PaymentMethodService {
	
	public List<PaymentMethodDto> getSavedCards(String userName);
	
	public Integer saveCard(String userName, PaymentMethodDto dto);
	
	public boolean deleteCard(String userName, Integer cardId);
}

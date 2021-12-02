package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.TemporalType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.model.entities.PaymentMethodModel;
import com.ibm.model.entities.dto.PaymentMethodDto;
import com.ibm.services.PaymentMethodService;

@ExtendWith(SpringExtension.class)
public class TestPaymentMethodService {
	
	@Autowired
	private PaymentMethodService service;
	
	@Test
	public void testFetchSavedCards() {
		List<PaymentMethodDto> payments = service.getSavedCards("");
		assertNotNull(payments);
	}
	
	@Test
	public void testInvalidFetchSavedCards() {
		List<PaymentMethodDto> payments = service.getSavedCards("");
		assertNull(payments);
	}
	
	@Test
	public void testSaveCard() {
		PaymentMethodModel card1 = new PaymentMethodModel();
		card1.setUser(null);
		card1.setPaymentMethodId(1);
		card1.setCardNumber("");
		card1.setNameOnCard("");
		card1.setExpiryDate(null);
		card1.setCvvNo(123);
		
		service.saveCard("", null);
	}
	
	@Test
	public void testDeleteCard() {
		service.deleteCard("xyz", 2);
	}

}

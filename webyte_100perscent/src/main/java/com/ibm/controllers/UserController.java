/**
*This class describes Controllers for User
*Adding User Address, Saving Card & Assigning admin by using PostMapping and fetching User Details, Address & Saving Cards by GetMapping
*Delete User Address & delete Card by using DeleteMapping
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.entities.dto.AddressDto;
import com.ibm.model.entities.dto.PaymentMethodDto;
import com.ibm.model.entities.dto.UserProfileDto;
import com.ibm.services.PaymentMethodService;
import com.ibm.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private PaymentMethodService paymentMethodService;
	
	@GetMapping(value = "{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserDetails(@PathVariable String userName) {
		UserProfileDto response = userService.getUserDetails(userName);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{userName}/address", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserAddresses(@PathVariable String userName) {
		List<AddressDto> addresses = userService.getUserAddresses(userName);
		return ResponseEntity.ok(addresses);
	}
	
	@PostMapping(value = "{userName}/address", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUserAddress(@PathVariable String userName, @RequestBody AddressDto dto) {
		boolean response = userService.saveAddress(dto, userName);
		return ResponseEntity.ok(new Object() {public boolean result = response; });
	}
	@DeleteMapping(value = "{userName}/address/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUserAddress(@PathVariable String userName, @PathVariable Integer addressId) {
		boolean response = userService.deleteUserAddress(userName, addressId);
		return ResponseEntity.ok(new Object() {public boolean result = response;});
	}
	
	@GetMapping(value = "{userName}/cards", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSavedCards(@PathVariable String userName) {
		List<PaymentMethodDto> methods = paymentMethodService.getSavedCards(userName);
		
		return ResponseEntity.ok(methods);
	}
	
	@PostMapping(value = "{userName}/cards", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCard(@PathVariable String userName, @RequestBody PaymentMethodDto dto) {
		Integer savedId = paymentMethodService.saveCard(userName, dto);
		
		return ResponseEntity.ok(new Object() {public Integer id = savedId;});
	}
	
	@DeleteMapping(value = "{userName}/cards/{cardId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCard(@PathVariable String userName, @PathVariable Integer cardId) {
		boolean response = paymentMethodService.deleteCard(userName, cardId);
		return ResponseEntity.ok(new Object() {public boolean result = response;});
	}
	
	@PostMapping(value = "{userName}/assignAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> assignAdmin(@PathVariable String userName) {
		boolean response = userService.assignAdmin(userName);
		return ResponseEntity.ok(new Object() {public boolean result = response;});
	}
}

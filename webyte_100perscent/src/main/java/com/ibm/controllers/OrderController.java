/**
*This class describes Controllers for Order 
*Updating OrderItems, adding voucher & placing Order by using PostMapping and fetching User Cart, Quantity in Cart & all orders by GetMapping
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/
package com.ibm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.entities.dto.CartRequestDto;
import com.ibm.model.entities.dto.CartVoucherDto;
import com.ibm.model.entities.dto.OrderDto;
import com.ibm.model.entities.dto.OrderPlaceDto;
import com.ibm.services.OrderService;

@RestController
@CrossOrigin
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping(value = "cart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateOrderItems(@RequestBody CartRequestDto item) {
		int numCartItems = service.updateOrderItems(item);
		
		return ResponseEntity.ok(new Object() {public int cartItems = numCartItems;});
	}
	
	@GetMapping(value = "cart", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserCart(@RequestParam String userName) {
		
		return ResponseEntity.ok(service.getUserCart(userName));
	}
	@GetMapping(value = "cart/quantity", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserCartQuantity(@RequestParam String userName, @RequestParam String modelNo) {
		Integer quantity = service.getQuantityInCart(userName, modelNo);
		return ResponseEntity.ok(new Object() {public Integer quantityInCart = quantity;});
	}
	
	@PostMapping(value = "cart/addVoucher", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addVoucherToCart(@RequestBody CartVoucherDto dto) {
		boolean response = service.addVoucherToCart(dto);
		return ResponseEntity.ok(new Object() {public boolean result = response;});
	}
	
	@PostMapping(value = "placeOrder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> placeOrder(@RequestBody OrderPlaceDto dto) {
		Integer orderId = service.placeOrder(dto);
		return ResponseEntity.ok(new Object() {
			public boolean result = orderId != null && orderId > 0;
			public Integer id = orderId;
		});

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getOrderHistory(@RequestParam String userName) {
		List<OrderDto> orders = service.getAllOrders(userName);
		return ResponseEntity.ok(orders);
	}
}

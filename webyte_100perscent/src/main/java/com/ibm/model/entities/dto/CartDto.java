/**
* This class describes list of DTO of Cart and Cart Item.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.model.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

	public String userName;
	public Float voucherDiscount;
	public List<CartItemDto> orderItems = new ArrayList<>();
}

class CartItemDto {
	public ProductDto product;
	public Integer quantity;
}
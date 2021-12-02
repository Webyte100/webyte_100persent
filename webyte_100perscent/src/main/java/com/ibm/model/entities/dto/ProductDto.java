/**
* This class describes list of DTO of Product.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.model.entities.dto;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ibm.model.entities.BrandModel;
import com.ibm.model.entities.CollectionModel;
import com.ibm.model.entities.enumerations.DeliverySpeed;
import com.ibm.model.entities.enumerations.Gender;

public class ProductDto {
	public Integer id;
	public String name;
	public Integer price;
	public String series;
	public String modelNo;
	public String category;
	public Gender gender;
	public DeliverySpeed deliverySpeed;
	public Float starRating;
	public Integer discount;
	public Integer expiryDate;
	public Set<String> features = new HashSet<>();
	public Set<String> images = new HashSet<>();
	public BrandModel brand;
	public CollectionModel collection;
	
	@JsonInclude(Include.NON_NULL)
	public Integer quantity;
}

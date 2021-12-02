/**
* This class describes list of DTO of Address.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.model.entities.dto;

import com.ibm.model.entities.enumerations.AddressType;

public class AddressDto {

	public Integer id;
	public String name;
	public AddressType type;
	public boolean isDefault;
	public String address;
	public String city;
	public String state;
	public String country;
	public Integer pincode;
	public String phoneNo;
}

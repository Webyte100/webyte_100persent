/**
* This class describes list of DTO of Payment Method.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.model.entities.dto;

import java.util.Date;

public class PaymentMethodDto {

	public Integer paymentMethodId;
	public String nameOnCard;
	public String cardNumber;
	public Date expiry;
	public Integer cvvNo;
}

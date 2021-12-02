/**
* This class describes services for OTP.
* Methods for generating OTP and validating OTP.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.services;

import com.ibm.model.entities.dto.OtpDto;

public interface OtpService {
	public boolean generateOtp(OtpDto dto);
	public boolean validateOtp(OtpDto dto);
}

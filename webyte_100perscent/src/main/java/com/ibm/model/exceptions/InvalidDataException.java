/**
* This class describes the exceptions when Invalid Data is given.
* @author K.Vihitha, T.M.Yasaswini
* @version 1.8.0_311
**/

package com.ibm.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST , reason = "Invalid Parameters")
public class InvalidDataException extends RuntimeException{

	public InvalidDataException(){
		super();
	}
	
	public InvalidDataException(String message){
		super(message);
	}
}

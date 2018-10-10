package com.bootLogisticSystem.exception;

public class InvalidParameterException extends Exception {

	public InvalidParameterException() {
		super();
	};
	
	public InvalidParameterException(String errorMsg) {
		super(errorMsg);		
	}
	
}

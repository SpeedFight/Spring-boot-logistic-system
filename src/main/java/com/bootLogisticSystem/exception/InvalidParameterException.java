/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.exception;

public class InvalidParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7602159364552880537L;

	public InvalidParameterException() {
		super();
	};
	
	public InvalidParameterException(String errorMsg) {
		super(errorMsg);		
	}
	
}

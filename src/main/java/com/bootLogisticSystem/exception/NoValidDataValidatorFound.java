/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.exception;

public class NoValidDataValidatorFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5515939702346473576L;

	public NoValidDataValidatorFound() {
		super();
	}

	public NoValidDataValidatorFound(String message) {
		super(message);
	}
}

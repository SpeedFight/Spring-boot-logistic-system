/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.exception;

public class NoValidDataParserFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2079273486371968286L;

	public NoValidDataParserFoundException() {
		super();
	}

	public NoValidDataParserFoundException(String message) {
		super(message);
	}

}

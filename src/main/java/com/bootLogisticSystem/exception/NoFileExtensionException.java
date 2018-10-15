/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.exception;

public class NoFileExtensionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312898590506497006L;

	public NoFileExtensionException() {
		super();
	}

	public NoFileExtensionException(String message) {
		super(message);
	}


}

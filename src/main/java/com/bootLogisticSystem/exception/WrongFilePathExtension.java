/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.exception;

public class WrongFilePathExtension extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8687995797369832603L;

	public WrongFilePathExtension() {
		super();
	}

	public WrongFilePathExtension(String message) {
		super(message);
	}

}

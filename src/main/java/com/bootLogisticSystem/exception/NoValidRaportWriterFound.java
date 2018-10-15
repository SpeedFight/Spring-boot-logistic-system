/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.exception;

public class NoValidRaportWriterFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4093022055583687679L;

	public NoValidRaportWriterFound() {
		super();
	}

	public NoValidRaportWriterFound(String message) {
		super(message);
	}
}

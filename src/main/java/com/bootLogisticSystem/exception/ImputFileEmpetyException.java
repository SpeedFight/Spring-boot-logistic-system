/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.exception;

public class ImputFileEmpetyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7059150326074304981L;

	public ImputFileEmpetyException() {
		super();
	}

	public ImputFileEmpetyException(String message) {
		super(message);
	}
}

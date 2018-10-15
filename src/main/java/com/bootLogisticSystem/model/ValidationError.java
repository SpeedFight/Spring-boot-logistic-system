/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.model;

import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component
public class ValidationError {

	private static List<String> errors;
	
	public ValidationError() {
		if(errors == null) {
			errors = new ArrayList<>();			
		}
	}

	public List<String> getErrors() {
		return errors;
	}
	
	public void showErrors() {
		for (String error : errors) {
			Logger.warn(error);
		}
	}
}

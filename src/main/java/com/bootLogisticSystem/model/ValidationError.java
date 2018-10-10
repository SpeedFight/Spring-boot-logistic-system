package com.bootLogisticSystem.model;

import java.util.ArrayList;
import java.util.List;

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
}
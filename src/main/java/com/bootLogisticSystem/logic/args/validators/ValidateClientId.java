package com.bootLogisticSystem.logic.args.validators;

import java.io.File;
import java.util.List;

import com.bootLogisticSystem.exception.InvalidParameterException;

public class ValidateClientId {
	
	public ValidateClientId() {};

	public String validate(String clientId) throws InvalidParameterException{
		return clientId;
	}
}

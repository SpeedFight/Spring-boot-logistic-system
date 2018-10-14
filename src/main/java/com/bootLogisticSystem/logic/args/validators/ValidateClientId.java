package com.bootLogisticSystem.logic.args.validators;

import com.bootLogisticSystem.exception.InvalidParameterException;

public class ValidateClientId {
	
	public ValidateClientId() {};

	public String validate(String clientId) throws InvalidParameterException{
		//no rules to validate client at this moment.
		return clientId;
	}
}

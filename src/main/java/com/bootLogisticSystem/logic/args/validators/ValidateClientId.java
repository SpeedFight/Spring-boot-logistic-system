/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.args.validators;

import com.bootLogisticSystem.exception.InvalidParameterException;

/**
 * Class privide validation of client id.
 * 
 * @author Karol Łukasiewicz
 *
 */
public class ValidateClientId {

	public ValidateClientId() {
	};

	/**
	 * Validate client id
	 * 
	 * @param clientId
	 * @return validated client id
	 * @throws InvalidParameterException
	 */
	public String validate(String clientId) throws InvalidParameterException {
		// no rules to validate client at this moment.
		return clientId;
	}
}

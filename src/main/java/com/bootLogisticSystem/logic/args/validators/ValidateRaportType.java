/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.args.validators;

import java.util.Optional;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.model.RaportType;

/**
 * 
 * @author Karol Łukasiewicz
 *
 */
public class ValidateRaportType {

	public ValidateRaportType() {};
	
	public RaportType validate(String raportType) throws InvalidParameterException{
		
		Optional<RaportType> selectedRaportType = Optional.empty();
		
		for (RaportType raport : RaportType.values()) {
			if(raport.getCode().equalsIgnoreCase(raportType)) {
				selectedRaportType = Optional.of(raport);
			}			
		}
		
		if(!selectedRaportType.isPresent()) {
			throw new InvalidParameterException("Parameter 'report', can't accept argument: " + raportType);
		}
		
		return selectedRaportType.get();
	}
}

package com.bootLogisticSystem.logic.data;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.exception.NoValidDataValidatorFound;
import com.bootLogisticSystem.model.ValidationError;

public class DataValidatorFactory {

	public static <T extends GenerateAble> DataValidator getDataValidator(Class<T> pojo, ValidationError validationError) throws NoValidDataValidatorFound{
		
		if (pojo.getClass().isInstance(Request.class)) {
			return new RequestDataValidator(validationError);
		} else {
			throw new NoValidDataValidatorFound("No data validator found for: " + pojo.getTypeName() + " type "); 
		}
	}
}

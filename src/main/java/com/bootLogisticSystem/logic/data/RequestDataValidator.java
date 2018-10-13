package com.bootLogisticSystem.logic.data;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.model.ValidationError;

public class RequestDataValidator implements DataValidator<Request>{
	
	private final String formatString = "Error in client id:'%s' request id:'%s'. Wrong value:'%s' = '%s' because: '%s'";
	private final List<String> errors;
	ValidatorFactory validatorFactory;
	Validator validator;
	
	@Autowired
	private RequestDataValidator(ValidationError validationError) {
		errors = validationError.getErrors();
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();	
	}

	/**
	 * Parse input Request list and return only correct elements
	 * @param listToValidate request list to validate
	 * @return list that contain only correct request
	 */
	@Override
	public List<Request> validate(List<Request> listToValidate) {	
		
		//validate every element in list
		//in one time:
		//	1) filter request with no error
		//	2) fill errors list with messages that describe why validation failed
		List<Request> validatedList = listToValidate.parallelStream().filter(request -> {
			errors.addAll(validator.validate(request).stream()
				.map(constraintViolation -> String.format(formatString, 
				((Request)constraintViolation.getRootBean()).getClientId(), 
				((Request)constraintViolation.getRootBean()).getRequestId(),
				constraintViolation.getPropertyPath(),
				constraintViolation.getInvalidValue(), 
				constraintViolation.getMessage()
				))
			.collect(Collectors.toList()));
			
			return validator.validate(request).isEmpty();
		}).collect(Collectors.toList());

		return validatedList;
	};
}

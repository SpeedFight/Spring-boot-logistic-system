package com.bootLogisticSystem.component.validator;

import java.util.List;

public interface CustomInputValidator<T> {

	List<T> validate(List<T> listToValidate);
}

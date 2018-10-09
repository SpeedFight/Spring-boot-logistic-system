package com.bootLogisticSystem.utils.validator;

import java.util.List;

public interface Validator<T> {

	List<T> validate(List<T> listToValidate);
}

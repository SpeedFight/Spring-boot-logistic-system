package com.bootLogisticSystem.component.validator;

import java.util.List;

public interface DataValidator<T> {

	List<T> validate(List<T> listToValidate);
}

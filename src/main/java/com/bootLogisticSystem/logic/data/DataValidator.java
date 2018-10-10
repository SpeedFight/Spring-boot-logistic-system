package com.bootLogisticSystem.logic.data;

import java.util.List;

public interface DataValidator<T> {

	List<T> validate(List<T> listToValidate);
}

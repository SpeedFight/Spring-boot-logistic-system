package com.bootLogisticSystem.logic.data;

import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;

public interface DataValidator {

	<T extends GenerateAble> List<T> validate(List<T> listToValidate);
}

/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.data;

import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;

public interface DataValidator {

	<T extends GenerateAble> List<T> validate(List<T> listToValidate);
}

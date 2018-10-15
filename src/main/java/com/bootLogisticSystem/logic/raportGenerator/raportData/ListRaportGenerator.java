/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.raportGenerator.raportData;

import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;

public interface ListRaportGenerator<T extends GenerateAble> {

	List<T> generate();
	List<T> generateByClientId(String clientId);
	
}

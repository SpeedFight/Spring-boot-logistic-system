/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.raportGenerator.raportData;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;

public abstract class SingleValueRaportGenerator extends GenerateAble{

	abstract OneValueReport generate();
	abstract OneValueReport generateByClientId(String userId);
	
	protected OneValueReport formRaport(String value, String description){
		return new OneValueReport(description, value);
	}
}

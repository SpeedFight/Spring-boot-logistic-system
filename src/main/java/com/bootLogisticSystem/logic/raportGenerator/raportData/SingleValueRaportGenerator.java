package com.bootLogisticSystem.logic.raportGenerator.raportData;

import com.bootLogisticSystem.model.raportTemplates.OneValueReport;

public abstract class SingleValueRaportGenerator {

	abstract OneValueReport generate();
	abstract OneValueReport generateByClientId(String userId);
	
	protected OneValueReport formRaport(String value, String description){
		return new OneValueReport(description, value);
	}
}

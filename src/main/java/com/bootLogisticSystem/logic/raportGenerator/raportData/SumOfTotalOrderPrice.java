/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.raportGenerator.raportData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;
import com.bootLogisticSystem.repository.RequestRepository;

@Component
public class SumOfTotalOrderPrice extends SingleValueRaportGenerator {

	@Autowired
	private RequestRepository orderRepository;
	

	@Override
	public OneValueReport generate() {
		String value = Double.toString(orderRepository.getSumOfTotalOrderPrice());
		String description = RaportType.C.getDescription();
		
		return formRaport(value, description);
	}

	@Override
	public OneValueReport generateByClientId(String clientId) {
		String value = Double.toString(orderRepository.getSumOfOrderPriceFromClient(clientId));
		String description = RaportType.D.getDescription();
		
		return formRaport(value, description);
	}
}

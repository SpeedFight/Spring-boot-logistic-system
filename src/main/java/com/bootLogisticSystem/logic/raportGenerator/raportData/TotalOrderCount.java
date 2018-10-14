package com.bootLogisticSystem.logic.raportGenerator.raportData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;
import com.bootLogisticSystem.repository.RequestRepository;

@Component
public class TotalOrderCount extends SingleValueRaportGenerator {

	@Autowired
	private RequestRepository orderRepository;
	

	@Override
	public OneValueReport generate() {
		String value = Long.toString(orderRepository.count());
		String description = RaportType.A.getDescription();
		
		return formRaport(value, description);
	}

	@Override
	public OneValueReport generateByClientId(String clientId) {
		String value = Long.toString(orderRepository.countByClientId(clientId));
		String description = RaportType.B.getDescription();
		
		return formRaport(value, description);
	}
}

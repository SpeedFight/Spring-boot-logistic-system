package com.bootLogisticSystem.logic.raportGenerator.raportData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;
import com.bootLogisticSystem.repository.RequestRepository;

@Component
public class TotalAverageOrderPrice extends SingleValueRaportGenerator {

	@Autowired
	private RequestRepository orderRepository;
	

	@Override
	public OneValueReport generate() {
		String value = Double.toString(orderRepository.getTotalAverageOrderPrice());
		String description = RaportType.G.getDescription();
		
		return formRaport(value, description);
	}

	@Override
	public OneValueReport generateByClientId(String clientId) {
		String value = Double.toString(orderRepository.getAverageOrderPriceFromClient(clientId));
		String description = RaportType.H.getDescription();
		
		return formRaport(value, description);
	}
}

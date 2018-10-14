package com.bootLogisticSystem.logic.raportGenerator.raportData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.repository.RequestRepository;

@Component
public class OrdersList implements ListRaportGenerator<Request> {

	@Autowired
	private RequestRepository orderRepository;
	
	@Override
	public List<Request> generate() {
		
		List<Request> collection = new ArrayList<>();
		orderRepository.findAll().forEach(collection::add);
		
		return collection;
	}

	@Override
	public List<Request> generateByClientId(String clientId) {
		return orderRepository.findByClientId(clientId);
	}

	
}

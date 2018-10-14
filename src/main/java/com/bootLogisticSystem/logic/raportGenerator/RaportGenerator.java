package com.bootLogisticSystem.logic.raportGenerator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.repository.RequestRepository;

@Component
public class RaportGenerator {

	@Autowired
	private RequestRepository orderRepository;
	
	public <T extends GenerateAble> List<T> generate(RaportType raportType){
		
		switch (raportType) {
		case A:		
			break;
		case B:
			break;
		case C:
			break;
		case D:
			break;
		case E:
			break;
		case F:
			break;
		case G:
			break;
		case H:
			break;
		default:
			break;
		}
		
		return null;
	}
}

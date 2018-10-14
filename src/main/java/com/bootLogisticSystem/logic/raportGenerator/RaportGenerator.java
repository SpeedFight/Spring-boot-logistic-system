package com.bootLogisticSystem.logic.raportGenerator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoValidRaportDataGeneratorFoundException;
import com.bootLogisticSystem.logic.raportGenerator.raportData.SumOfTotalOrderPrice;
import com.bootLogisticSystem.logic.raportGenerator.raportData.TotalOrderCount;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;
import com.bootLogisticSystem.repository.RequestRepository;

@Component
public class RaportGenerator {

	@Autowired
	private RequestRepository orderRepository;

	@Autowired
	private TotalOrderCount totalOrderCount;
	
	@Autowired
	private SumOfTotalOrderPrice sumOfTotalOrderPrice;

	public OneValueReport generateSingleValueRaport(InputArgument inputArgument)
			throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {

		RaportType selectedRaportType = inputArgument.getRaportType();

		if (selectedRaportType.isRequireClientId() && inputArgument.isClientIdSelected()) {
			if(orderRepository.existsByRequestId(inputArgument.getClientId())) {
				
				throw new InvalidParameterException("Selected report type to generate: "
						+ "for raport type with code: " + selectedRaportType.getCode() 
						+ ", and description:" + selectedRaportType.getDescription() 
						+ ", can't be generate because there's no user:  " 
						+ inputArgument.isClientIdSelected());
			}
		}

		switch (selectedRaportType) {
		case A:
			return totalOrderCount.generate();
		case B:
			return totalOrderCount.generateByClientId(inputArgument.getClientId());
		case C:
			return sumOfTotalOrderPrice.generate();
		case D:
			return sumOfTotalOrderPrice.generateByClientId(inputArgument.getClientId());
		case E:
			break;
		case F:
			break;
		case G:
			break;
		case H:
			break;
		default:
			throw new NoValidRaportDataGeneratorFoundException(
					"Valid raport generator for raport type with code: " + selectedRaportType.getCode()
							+ ", and description:" + selectedRaportType.getDescription() + " not found");
		}
	}
}

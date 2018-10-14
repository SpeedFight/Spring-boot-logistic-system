package com.bootLogisticSystem.logic.raportGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoValidRaportDataGeneratorFoundException;
import com.bootLogisticSystem.logic.raportGenerator.raportData.ListRaportGenerator;
import com.bootLogisticSystem.logic.raportGenerator.raportData.OrdersList;
import com.bootLogisticSystem.logic.raportGenerator.raportData.SingleValueRaportGenerator;
import com.bootLogisticSystem.logic.raportGenerator.raportData.SumOfTotalOrderPrice;
import com.bootLogisticSystem.logic.raportGenerator.raportData.TotalAverageOrderPrice;
import com.bootLogisticSystem.logic.raportGenerator.raportData.TotalOrderCount;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.model.ReasultsContainer;
import com.bootLogisticSystem.repository.RequestRepository;

@Component
public class RaportGenerator {

	@Autowired
	private RequestRepository orderRepository;

	@Autowired
	private TotalOrderCount totalOrderCount;
	
	@Autowired
	private SumOfTotalOrderPrice sumOfTotalOrderPrice;
	
	@Autowired
	private TotalAverageOrderPrice totalAverageOrderPrice;
	
	@Autowired
	private OrdersList ordersList;

	public ReasultsContainer generateSingleValueRaport(InputArgument inputArgument)
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
		
		ReasultsContainer reasult = new ReasultsContainer();

		switch (selectedRaportType) {
		case A:
			reasult.set(totalOrderCount.generate(), SingleValueRaportGenerator.class);
			break;
		case B:
			reasult.set(totalOrderCount.generateByClientId(inputArgument.getClientId()), SingleValueRaportGenerator.class);
			break;
		case C:
			reasult.set(sumOfTotalOrderPrice.generate(), SingleValueRaportGenerator.class);
			break;
		case D:
			reasult.set(sumOfTotalOrderPrice.generateByClientId(inputArgument.getClientId()), SingleValueRaportGenerator.class);
			break;
		case E:
			reasult.set(ordersList.generate(), ListRaportGenerator.class);
			break;
		case F:
			reasult.set(ordersList.generateByClientId(inputArgument.getClientId()), ListRaportGenerator.class);
			break;
		case G:
			reasult.set(totalAverageOrderPrice.generate(), SingleValueRaportGenerator.class);
			break;
		case H:
			reasult.set(totalAverageOrderPrice.generateByClientId(inputArgument.getClientId()), SingleValueRaportGenerator.class);
			break;
		default:
			throw new NoValidRaportDataGeneratorFoundException(
					"Valid raport generator for raport type with code: " + selectedRaportType.getCode()
							+ ", and description:" + selectedRaportType.getDescription() + " not found");
		}
		
		return reasult;
	}
}

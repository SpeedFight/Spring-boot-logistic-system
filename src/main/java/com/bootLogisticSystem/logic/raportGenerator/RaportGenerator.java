/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.raportGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoValidRaportDataGeneratorFoundException;
import com.bootLogisticSystem.logic.raportGenerator.raportData.OrdersList;
import com.bootLogisticSystem.logic.raportGenerator.raportData.SumOfTotalOrderPrice;
import com.bootLogisticSystem.logic.raportGenerator.raportData.TotalAverageOrderPrice;
import com.bootLogisticSystem.logic.raportGenerator.raportData.TotalOrderCount;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.model.ReasultsContainer;
import com.bootLogisticSystem.repository.RequestRepository;

/**
 * Generate raport data
 * 
 * @author Karol Łukasiewicz
 *
 */
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

	/**
	 * Check if input data contain all data needed to generate report.
	 * 
	 * @param inputArgument Input arguments
	 * @return True if can generate report otherwise it thrown exception
	 * @throws InvalidParameterException When not enough data to generate report
	 */
	private boolean isCanGenerateRaport(InputArgument inputArgument) throws InvalidParameterException {

		RaportType selectedRaportType = inputArgument.getRaportType();

		if (selectedRaportType.isRequireClientId()) {

			if (!inputArgument.isClientIdSelected()) {
				throw new InvalidParameterException("Selected report type to generate: " + "for raport type with code: "
						+ selectedRaportType.getCode() + ", and description: " + selectedRaportType.getDescription()
						+ ", can't be generate because there's no client id selected");
			}

			if (orderRepository.existsByClientId(inputArgument.getClientId())) {
				return true;
			} else {
				throw new InvalidParameterException("Selected report type to generate: " + "for raport type with code: "
						+ selectedRaportType.getCode() + ", and description: " + selectedRaportType.getDescription()
						+ ", can't be generate because there's no client id: " + inputArgument.getClientId());
			}

		}

		return true;
	}

	/**
	 * Generate report from data in database.
	 * 
	 * @param inputArgument Input arguments
	 * @return obejct with data
	 * @throws NoValidRaportDataGeneratorFoundException thrown when not found report
	 *                                                  generator to generate
	 *                                                  selected report
	 * @throws InvalidParameterException                thrown when some data is
	 *                                                  invalid
	 */
	public ReasultsContainer generateRaport(InputArgument inputArgument)
			throws NoValidRaportDataGeneratorFoundException, InvalidParameterException {

		isCanGenerateRaport(inputArgument);

		RaportType selectedRaportType = inputArgument.getRaportType();

		ReasultsContainer reasult;

		switch (selectedRaportType) {
		case A:
			reasult = new ReasultsContainer(totalOrderCount.generate());
			break;
		case B:
			reasult = new ReasultsContainer(totalOrderCount.generateByClientId(inputArgument.getClientId()));
			break;
		case C:
			reasult = new ReasultsContainer(sumOfTotalOrderPrice.generate());
			break;
		case D:
			reasult = new ReasultsContainer(sumOfTotalOrderPrice.generateByClientId(inputArgument.getClientId()));
			break;
		case E:
			reasult = new ReasultsContainer(ordersList.generate());
			break;
		case F:
			reasult = new ReasultsContainer(ordersList.generateByClientId(inputArgument.getClientId()));
			break;
		case G:
			reasult = new ReasultsContainer(totalAverageOrderPrice.generate());
			break;
		case H:
			reasult = new ReasultsContainer(totalAverageOrderPrice.generateByClientId(inputArgument.getClientId()));
			break;
		default:
			throw new NoValidRaportDataGeneratorFoundException(
					"Valid raport generator for raport type with code: " + selectedRaportType.getCode()
							+ ", and description:" + selectedRaportType.getDescription() + " not found");
		}

		return reasult;
	}
}

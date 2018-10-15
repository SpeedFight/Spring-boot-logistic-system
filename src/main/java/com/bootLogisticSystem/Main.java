package com.bootLogisticSystem;

import java.util.List;

import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.logic.args.InputArgumentParser;
import com.bootLogisticSystem.logic.data.DataValidator;
import com.bootLogisticSystem.logic.data.DataValidatorFactory;
import com.bootLogisticSystem.logic.dataReader.DataReader;
import com.bootLogisticSystem.logic.raportGenerator.RaportFileGenerator;
import com.bootLogisticSystem.logic.raportGenerator.RaportGenerator;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.ReasultsContainer;
import com.bootLogisticSystem.model.ValidationError;
import com.bootLogisticSystem.repository.RequestRepository;

/**
 * This class main class of this program, that contain all logic.
 * 
 * @author speedfight
 *
 */
@Component
public class Main {


	
	@Autowired
	private DataReader dataReader;
	
	@Autowired
	private ValidationError validationError;
	
	@Autowired
	private RequestRepository orderRepository;
	
	@Autowired
	private RaportGenerator raportGenerator;

	@Autowired
	private RaportFileGenerator raportFileGenerator;

	/**
	 * Main program activity: <br>
	 * 1) Parse program agrs and keep all parameters in InputArgument class <br>
	 * 2)	Read and parse input files (only validate syntax in files) <br>
	 * 3) Validate input data (validate by rule defined in entity) <br>
	 * 4) Put input data to database <br>
	 * ) Generate selected report type from database <br>
	 * ) Save report <br>
	 * 
	 * @param args Program input arguments
	 */
	public void main(String[] args) {

		InputArgument inputArgument;

		try {
			// 1)
			inputArgument = new InputArgumentParser().parseArgs(args);
			
			// 2)
			List<Request> parsedData = dataReader.parse(inputArgument, Request.class);
			
			// 3)
			DataValidator dataValidator = DataValidatorFactory.getDataValidator(Request.class, validationError);
			List<Request> validatedData = dataValidator.validate(parsedData);
			validationError.showErrors();
			
			// 4)
			orderRepository.saveAll(validatedData);
			
			// 5)
			ReasultsContainer reasult = raportGenerator.generateRaport(inputArgument);
			
			// 6)
			raportFileGenerator.save(inputArgument, reasult);

		} catch (InvalidParameterException e) {
			/*
			 * heh I was almost forced to face the fact that my argument validation was bad,
			 * but I see here that you made a typo hahaha, tough luck pal.
			 */
			Logger.error(e.getMessage());
			new InputArgumentParser().printHelp();
		} catch (Exception e) {
			/*
			 * It is my fault now.
			 */
			Logger.error(e.getMessage());
		}
	}

}

package com.bootLogisticSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.logic.args.InputArgumentParser;
import com.bootLogisticSystem.logic.dataReader.DataReader;
import com.bootLogisticSystem.logic.raportGenerator.RaportGenerator;
import com.bootLogisticSystem.model.InputArgument;

/**
 * This class main class of this program, that contain all logic.
 * 
 * @author speedfight
 *
 */
@Component
public class Main {

//	@Autowired
//	private RequestRepository orderRepository;
	
	@Autowired
	DataReader dataReader;

	@Autowired
	private RaportGenerator raportGenerator;

	/**
	 * Main program activity: <br>
	 * 1) Parse program agrs and keep all parameters in InputArgument class <br>
	 *  	-	Read and parse input files (only validate syntax in files)
	 * 2) Validate input data (validate by rule defined in entity)
	 * 3) Put input data to database
	 * 4) Check if it is possible to generate selected report
	 * 5) Generate selected report type from database
	 * 6) Save report
	 * 7) Fin
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
			
			
			
			// 6)
//			raportGenerator.save(inputArgument, data);

		} catch (InvalidParameterException e) {
			/*
			 * heh I was almost forced to face the fact that my argument validation was bad,
			 * but I see here that you made a typo hahaha, tough luck pal.
			 */
		} catch (Exception e) {
			/*
			 * It is my fault now.
			 */
			e.printStackTrace();
		}
	}

}

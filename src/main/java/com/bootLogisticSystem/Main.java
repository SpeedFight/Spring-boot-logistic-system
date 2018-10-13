package com.bootLogisticSystem;

import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.logic.args.InputArgumentParser;
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

	/**
	 * Main program activity: <br>
	 * 1) Parse program agrs and keep all parameters in InputArgument class <br>
	 * 2) Read and parse input files (only validate syntax in files)
	 * 4) Validate input data (validate by rule defined in entity)
	 * 5) Put input data to database
	 * 6) Check if it is possible to generate selected report
	 * 7) Generate selected report type from database
	 * 8) Save report
	 * 9) Fin
	 * 
	 * @param args Program input arguments
	 */
	public void main(String[] args) {

		InputArgument inputArgument;

		try {
			inputArgument = new InputArgumentParser().parseArgs(args);

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

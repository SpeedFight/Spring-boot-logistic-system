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
//
//	@Autowired
//	private DataParser requestXmlParser;
//
//	@Autowired
//	private DataParser requestCsvParser;

	public void main(String[] args) {
		
		InputArgument inputArgument;
		
		
		try {

			System.out.println("parse args:");
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

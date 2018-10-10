package com.bootLogisticSystem.utils;

import java.io.File;
import java.util.List;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;

public class InputArgumentValidator {
	
	private InputArgumentValidator() {};

	public static InputArgument validate(String[] inputPaths, 
			String outputPath, 
			String raportType, 
			String clientId) throws InvalidParameterException{
		
		return new InputArgument(validateInputPaths(inputPaths), 
				validateOutputFile(outputPath), 
				validateRaportType(raportType), 
				validateClientId(clientId));
	}
	
	private static List<File> validateInputPaths(String[] inputPaths) throws InvalidParameterException{
		return null;
	}
	
	private static File validateOutputFile(String outputPath) throws InvalidParameterException{
		return null;
	}
	
	private static RaportType validateRaportType(String raportType) throws InvalidParameterException{
		return null;
	}
	
	private static String validateClientId(String clientId) throws InvalidParameterException{
		return clientId;
	}
	
}

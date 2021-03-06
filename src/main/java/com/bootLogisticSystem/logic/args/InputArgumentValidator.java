/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.args;

import java.io.File;
import java.util.List;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.logic.args.validators.ValidateClientId;
import com.bootLogisticSystem.logic.args.validators.ValidateInputPaths;
import com.bootLogisticSystem.logic.args.validators.ValidateOutputPath;
import com.bootLogisticSystem.logic.args.validators.ValidateRaportType;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.RaportType;

/**
 * Class provide all input argument validation
 * 
 * @author Karol Łukasiewicz
 *
 */
public class InputArgumentValidator {

	private ValidateClientId validateClientId;
	private ValidateInputPaths validateInputPaths;
	private ValidateOutputPath validateOutputPath;
	private ValidateRaportType validateRaportType;

	public InputArgumentValidator() {
		// set dependency
		validateClientId = new ValidateClientId();
		validateInputPaths = new ValidateInputPaths();
		validateOutputPath = new ValidateOutputPath();
		validateRaportType = new ValidateRaportType();
	};

	/**
	 * Validate input parameters to return correct InputArgument object which contain
	 * only correct data.
	 * 
	 * @param inputPaths Paths to input files
	 * @param outputPath Path to input file (can be null)
	 * @param raportType Type of report to generate
	 * @param clientId   Client id if needed
	 * @return Validated InputArgument object
	 * @throws InvalidParameterException throw when too much data is invalid
	 */
	public InputArgument validate(String[] inputPaths, String outputPath, String raportType, String clientId)
			throws InvalidParameterException {

		return new InputArgument(validateInputPaths(inputPaths), validateOutputFile(outputPath),
				validateRaportType(raportType), validateClientId(clientId));
	}

	private List<File> validateInputPaths(String[] inputPaths) throws InvalidParameterException {
		return validateInputPaths.validate(inputPaths);
	}

	private File validateOutputFile(String outputPath) throws InvalidParameterException {
		return validateOutputPath.validate(outputPath);
	}

	private RaportType validateRaportType(String raportType) throws InvalidParameterException {
		return validateRaportType.validate(raportType);
	}

	private String validateClientId(String clientId) throws InvalidParameterException {
		return validateClientId.validate(clientId);
	}

}

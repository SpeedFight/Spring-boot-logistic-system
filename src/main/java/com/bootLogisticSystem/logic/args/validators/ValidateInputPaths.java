/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.args.validators;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.utils.Utils;

/**
 * Class provide validation of input paths.
 * 
 * @author Karol Łukasiewicz
 *
 */
public class ValidateInputPaths {

	public ValidateInputPaths() {
	};

	/**
	 * Validate input paths
	 * 
	 * @param inputPaths array of input paths
	 * @return validated list of input paths
	 * @throws InvalidParameterException thrown when all paths are empety.
	 */
	public List<File> validate(String[] inputPaths) throws InvalidParameterException {

		List<File> validFiles = new ArrayList<>();

		for (String inputPath : inputPaths) {

			try {
				if (checkFilePath(inputPath)) {
					validFiles.add(new File(inputPath));
				}

			} catch (InvalidParameterException | NoFileExtensionException | WrongFilePathExtension e) {
				Logger.warn(e.getMessage());
				Logger.warn("File: " + inputPath + " is removed from input files list, and will be not use.");
			}
		}

		if (validFiles.size() > 0) {
			return validFiles;
		} else {
			throw new InvalidParameterException("No valid input files");
		}

	}

	private boolean checkFilePath(String inputPath)
			throws InvalidParameterException, NoFileExtensionException, WrongFilePathExtension {
		Path path = Paths.get(inputPath);

		if (!Files.exists(path) && !Files.isRegularFile(path)) {
			throw new InvalidParameterException("Path to input file: " + inputPath + " is wrong or file not exist");
		}
		if (!Files.isReadable(path)) {
			throw new InvalidParameterException("Path to input file: " + inputPath + " is unreadable.");
		}

		Utils.isFileExtensionSupported(inputPath);

		return true;
	}
}

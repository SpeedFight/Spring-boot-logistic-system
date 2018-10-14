package com.bootLogisticSystem.logic.args.validators;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import com.bootLogisticSystem.exception.InvalidParameterException;

import jdk.internal.jline.internal.Log;

public class ValidateInputPaths {

	public ValidateInputPaths() {
	};

	public List<File> validate(String[] inputPaths) throws InvalidParameterException {

		List<File> validFiles = new ArrayList<>();

		for (String inputPath : inputPaths) {

			try {
				checkFilePath(inputPath);
				validFiles.add(new File(inputPath));
			} catch (InvalidParameterException e) {
				Logger.warn(e.getMessage());
			}
		}

		return null;
	}

	private void checkFilePath(String inputPath) throws InvalidParameterException {
		Path path = Paths.get(inputPath);

		if (!Files.exists(path) && !Files.isRegularFile(path)) {
			throw new InvalidParameterException("Path to input file: " + inputPath + " is wrong or file not exist");
		}
		if (!Files.isReadable(path)) {
			throw new InvalidParameterException("Path to input file: " + inputPath + " is unreadable.");
		}
	}
}

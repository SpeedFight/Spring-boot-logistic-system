/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.args.validators;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.pmw.tinylog.Logger;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.utils.Utils;

/**
 * Class provide validation of output path.
 * 
 * @author Karol Łukasiewicz
 *
 */
public class ValidateOutputPath {

	public ValidateOutputPath() {
	};

	/**
	 * Validate output path
	 * @param outputPath oput path to validate
	 * @return validated output file
	 * @throws InvalidParameterException Thrown when path is unreadable or too wrong
	 */
	public File validate(String outputPath) throws InvalidParameterException {

		if (outputPath == null) {
			return null;
		}

		File file = new File(outputPath);

		Path path = Paths.get(outputPath);

		if (Files.isDirectory(path)) {
			try {
				Files.createDirectories(path.getParent());
				outputPath = Utils.getPathToFileWithDefaultName(outputPath);
			} catch (IOException e) {
				throw new InvalidParameterException(
						"Can't create directories to: " + outputPath + " because: " + e.getMessage());
			}
		}

		try {
			if (!Files.exists(path)) {
				Files.createDirectories(path.getParent());
			}
		} catch (Exception e) {

		}

		try {
			Utils.isFileExtensionSupported(outputPath);
		} catch (NoFileExtensionException | WrongFilePathExtension e) {
			String tmpOutputPath = outputPath;
			outputPath = Utils.addDefaultFileExtension(outputPath);

			Logger.warn("Output file: " + tmpOutputPath + " is invalid, so now is" + " changed to: " + outputPath);
		}

		return file;
	}
}

/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.utils;

import java.io.File;
import java.util.Optional;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.model.SupportedFileExtension;

/**
 * Class contains public static methods for many non categorised mechanics, used
 * in project.
 * 
 * @author Karol Łukasiewicz
 *
 */
public class Utils {

	private Utils() {
	};

	/**
	 * Parse input String and return file extension.
	 * 
	 * @param filePath Path to file
	 * @return File extension, eg. 'xml' or 'csv'.
	 * @throws NoFileExtensionException When there's no file extension in file name.
	 */
	public static String getFileExtensionFromPath(String filePath) throws NoFileExtensionException {
		Optional<String> extension = Optional.empty();

		try {
			extension = Optional.of(filePath.substring(filePath.lastIndexOf(".")));
		} catch (StringIndexOutOfBoundsException e) {
			throw new NoFileExtensionException("No file extension");
		}

		if (!extension.isPresent()) {
			throw new NoFileExtensionException("No file extension");
		}

		// eg. convert '.xml' to 'xml'
		return extension.get().substring(1);
	}

	/**
	 * Add default file extension defined in 'SupportedFileExtension' to end of file
	 * name.
	 * 
	 * @param filePath Path to file.
	 * @return Input file path with default file extension added at the end.
	 */
	public static String addDefaultFileExtension(String filePath) {

		if (!filePath.endsWith(".")) {
			filePath = filePath.concat(".");
		}
		return filePath.concat(SupportedFileExtension.getDefaultFileExtension());
	}

	/**
	 * Check if file extension is supported.
	 * 
	 * @param filePath Path to file.
	 * @return True if file extension is supported, otherwise false.
	 * @throws NoFileExtensionException When file extension is not supported.
	 * @throws WrongFilePathExtension   When there's no valid file name.
	 */
	public static boolean isFileExtensionSupported(String filePath)
			throws NoFileExtensionException, WrongFilePathExtension {
		String fileExtension = getFileExtensionFromPath(filePath);

		for (SupportedFileExtension supportedFileExtension : SupportedFileExtension.values()) {
			if (supportedFileExtension.getFileExtension().equals(fileExtension)) {
				return true;
			}
		}

		throw new WrongFilePathExtension(
				"File extension:" + fileExtension + " for file: " + filePath + " not supported");
	}

	/**
	 * Set default file name, and default extension (defined in
	 * 'SupportedFileExtension') to end of file path. It also check last character
	 * of file path to add system default file separator when needed.
	 * 
	 * @param pathToDirectory Path to file.
	 * @return Path to file with default name and extension.
	 */
	public static String getPathToFileWithDefaultName(String pathToDirectory) {
		if (!pathToDirectory.endsWith(File.separator)) {
			pathToDirectory = pathToDirectory.concat(File.separator);
		}

		return pathToDirectory.concat("output.").concat(SupportedFileExtension.getDefaultFileExtension());
	}
}

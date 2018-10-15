/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.dataReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.exception.ImputFileEmpetyException;
import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidDataParserFoundException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;

/**
 * Provide functionality to read single file.
 * 
 * @author Karol Łukasiewicz
 *
 */
@Component
public class SingleFileReader {

	@Autowired
	private DataParserFactory dataParserFactory;

	/**
	 * Read and parse single file
	 * 
	 * @param fileToParse   Path to correct input file
	 * @param inputDataPojo pojo data represents parsed data
	 * @return list with parsed objects
	 * @throws ImputFileEmpetyException thrown when file is empty
	 */
	public <T extends GenerateAble> List<T> parse(File fileToParse, Class<T> inputDataPojo)
			throws ImputFileEmpetyException {

		Optional<List<T>> parsedData = Optional.empty();

		try {
			DataParser dataParser = dataParserFactory.getDataParser(fileToParse.getPath());
			parsedData = Optional.of(dataParser.parse(fileToParse));
		} catch (NoFileExtensionException | WrongFilePathExtension | NoValidDataParserFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (parsedData.isPresent() && parsedData.get().size() > 0) {
			return parsedData.get();
		} else {
			throw new ImputFileEmpetyException("File: " + fileToParse.getPath() + " is empety");
		}
	}
}

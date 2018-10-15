/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.dataReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidDataParserFoundException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.utils.Utils;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Factory that can return correct DataParser to parse certain file
 * 
 * @author Karol Łukasiewicz
 *
 */
@Component
public class DataParserFactory {

	@Autowired
	private XmlMapper xmlMapper;

	@Autowired
	private CsvMapper csvMapper;

	/**
	 * Return correct DataParser
	 * 
	 * @param pathTofile Path to file that parser should be returned
	 * @return parser to file
	 * @throws NoFileExtensionException        thrown when there's no file extension
	 *                                         in pathToFile
	 * @throws WrongFilePathExtension          thrown when file extension is
	 *                                         unsupported
	 * @throws NoValidDataParserFoundException thrown when given file is not
	 *                                         supported
	 */
	public DataParser getDataParser(String pathTofile)
			throws NoFileExtensionException, WrongFilePathExtension, NoValidDataParserFoundException {

		Utils.isFileExtensionSupported(pathTofile);

		switch (Utils.getFileExtensionFromPath(pathTofile)) {
		case "csv":
			return new CsvDataParser(csvMapper);
		case "xml":
			return new XmlDataParser(xmlMapper);
		default:
			throw new NoValidDataParserFoundException("No data parser for: " + pathTofile + " found.");
		}
	}
}

package com.bootLogisticSystem.logic.dataReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidDataParserFoundException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.utils.Utils;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Component
public class DataParserFactory {

	@Autowired
	private XmlMapper xmlMapper;
	
	@Autowired
	private CsvMapper csvMapper;
	
	public DataParser getDataParser(String pathTofile) throws NoFileExtensionException, WrongFilePathExtension, NoValidDataParserFoundException {
		
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

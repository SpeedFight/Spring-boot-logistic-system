/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.raportGenerator.raportFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidRaportWriterFound;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.utils.Utils;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Class provide selector factory to correct file writer.
 * 
 * @author speedfight
 *
 */
@Component
public class RaportWriterFactory {
	
	@Autowired
	private XmlMapper xmlMapper;
	
	@Autowired
	private CsvMapper csvMapper;

	public RaportWriter getRaportWriter(String pathTofile, RaportType raportType)
			throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {

		Utils.isFileExtensionSupported(pathTofile);
		
		switch (raportType) {
		
		case A:	//"Ilość zamówień łącznie"
		case B:	//"Ilość zamówień do klienta o wskazanym identyfikatorze"
		case C:	//"Łączna kwota zamówień"
		case D:	// "Łączna kwota zamówień do klienta o wskazanym identyfikatorze"
		case E: //"Łączna kwota zamówień do klienta o wskazanym identyfikatorze" 
		case F: //"Lista wszystkich zamówień"
		case G:	//"Średnia wartość zamówienia"
		case H:	//"Średnia wartość zamówienia do klienta o wskazanym identyfikatorze"
			return getSpecificReportTypeWriter(pathTofile);

		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
	
	private RaportWriter getSpecificReportTypeWriter(String pathTofile) throws NoValidRaportWriterFound, NoFileExtensionException {
		switch (Utils.getFileExtensionFromPath(pathTofile)) {
		case "csv":
			return new CsvRaportWriter(csvMapper);
		case "xml":
			return new XmlRaportWriter(xmlMapper);
		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
	
}

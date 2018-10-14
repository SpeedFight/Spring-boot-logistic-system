package com.bootLogisticSystem.logic.raportGenerator.RaportFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidRaportWriterFound;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.logic.raportGenerator.RaportFile.customWriter.RequestListRaportCsvCustomWriter;
import com.bootLogisticSystem.logic.raportGenerator.RaportFile.customWriter.RequestListRaportXmlCustomWriter;
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
		case G:	//"Średnia wartość zamówienia"
		case H:	//"Średnia wartość zamówienia do klienta o wskazanym identyfikatorze"
			return getSpecificReportTypeWriterForSimpleData(pathTofile);
			
		case E: //"Łączna kwota zamówień do klienta o wskazanym identyfikatorze" 
		case F: //"Lista wszystkich zamówień"
			return getSpecificReportTypeWriterForEF(pathTofile);

		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
	
	private RaportWriter getSpecificReportTypeWriterForSimpleData(String pathTofile) throws NoValidRaportWriterFound, NoFileExtensionException {
		switch (Utils.getFileExtensionFromPath(pathTofile)) {
		case "csv":
			return new CsvRaportWriter(csvMapper);
		case "xml":
			return new XmlRaportWriter(xmlMapper);
		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
	
	
	private RaportWriter getSpecificReportTypeWriterForEF(String pathTofile) throws NoValidRaportWriterFound, NoFileExtensionException {
		switch (Utils.getFileExtensionFromPath(pathTofile)) {
		case "csv":
			return new RequestListRaportCsvCustomWriter(csvMapper);
		case "xml":
			return new RequestListRaportXmlCustomWriter(xmlMapper);
		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
	
}

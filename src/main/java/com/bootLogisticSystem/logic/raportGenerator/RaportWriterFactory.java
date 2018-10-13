package com.bootLogisticSystem.logic.raportGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidRaportWriterFound;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.logic.raportGenerator.customOptions.RequestListRaportXmlCustomWriter;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.utils.Utils;

/**
 * Class provide selector factory to correct file writer.
 * 
 * @author speedfight
 *
 */
@Component
public class RaportWriterFactory {

	public RaportWriter getRaportWriter(String pathTofile, RaportType raportType)
			throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {

		Utils.isFileExtensionSupported(pathTofile);
		
		switch (raportType) {
		
		case A:
		case B:
		case C:
		case D:
		case G:
		case H:
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
			return new CsvRaportWriter();
		case "xml":
			return new XmlRaportWriter();
		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
	
	
	private RaportWriter getSpecificReportTypeWriterForEF(String pathTofile) throws NoValidRaportWriterFound, NoFileExtensionException {
		switch (Utils.getFileExtensionFromPath(pathTofile)) {
		case "csv":
			return new RequestListRaportXmlCustomWriter();
		case "xml":
			return new RequestListRaportXmlCustomWriter();
		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
	
}

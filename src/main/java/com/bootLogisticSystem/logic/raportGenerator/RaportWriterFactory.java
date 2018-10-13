package com.bootLogisticSystem.logic.raportGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidRaportWriterFound;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
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

	private XmlRaportWriter xmlRaportWriter;
	private CsvRaportWriter csvRaportWriter;

	@Autowired
	public RaportWriterFactory(XmlRaportWriter xmlRaportWriter, CsvRaportWriter csvRaportWriter) {
		super();
		this.xmlRaportWriter = xmlRaportWriter;
		this.csvRaportWriter = csvRaportWriter;
	}

	public RaportWriter getRaportWriter(String pathTofile, RaportType raportType)
			throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {

		Utils.isFileExtensionSupported(pathTofile);
		
		switch (raportType) {
		
		case E:
		case F:
			return getSpecificReportTypeWriterForEF(pathTofile);

		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
	
	private RaportWriter getSpecificReportTypeWriterForEF(String pathTofile) throws NoValidRaportWriterFound, NoFileExtensionException {
		switch (Utils.getFileExtensionFromPath(pathTofile)) {
		case "csv":
			return csvRaportWriter;
		case "xml":
			return xmlRaportWriter;
		default:
			throw new NoValidRaportWriterFound("No writer for: " + pathTofile + " found.");
		}
	}
}

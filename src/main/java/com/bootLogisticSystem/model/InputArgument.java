package com.bootLogisticSystem.model;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Class validate and keep data with info
 * where load and save file.
 * @author speedfight
 *
 */
public class InputArgument {
	
	private final List<File> inputFiles;
	private final File outputFile;
	private final RaportType raportType;
	private final String clientId;
	
	public InputArgument(List<File> inputFiles, File outputFile, RaportType raport, String clientId) {
		super();
		this.inputFiles = inputFiles;
		this.outputFile = outputFile;
		this.raportType = raport;
		this.clientId = clientId;
	}

	public List<File> getInputFiles() {
		return inputFiles;
	}

	public File getOutputFile() {
		return outputFile;
	}

	public RaportType getRaportType() {
		return raportType;
	}

	public String getClientId() {
		return clientId;
	}
}

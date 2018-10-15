/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.model;

import java.io.File;
import java.util.List;

/**
 * Class validate and keep data with info where load and save file.
 * 
 * @author Karol Łukasiewicz
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

	public boolean isClientIdSelected() {
		if (clientId == null || clientId.contentEquals("")) {
			return false;
		} else {
			return true;
		}
	}
}

package com.bootLogisticSystem.model;

public enum SupportedFileExtension {
	CSV("csv"),
	XML("xml");
	
	private final String fileExtension;
	
	private SupportedFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFileExtension() {
		return fileExtension;
	}

}

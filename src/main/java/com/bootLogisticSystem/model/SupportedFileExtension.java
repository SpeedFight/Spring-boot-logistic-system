package com.bootLogisticSystem.model;

public enum SupportedFileExtension {
	CSV("csv"),
	XML("xml");
	
	private String fileExtension;
	
	private SupportedFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
}

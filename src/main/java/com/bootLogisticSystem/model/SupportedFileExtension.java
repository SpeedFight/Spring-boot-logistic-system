/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
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
	
	public static String getDefaultFileExtension() {
		return SupportedFileExtension.CSV.getFileExtension();
	}

}

/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.raportGenerator.raportFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Interface to define raport writer class. Designed to provide save data raport
 * as file ability.
 * 
 * @author Karol Łukasiewicz
 *
 */
public interface RaportWriter {

	/**
	 * Save input list to file.
	 * @param file File to save.
	 * @param data Input data list.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	<T extends GenerateAble> void writeList(File file, List<T> data) throws JsonGenerationException, JsonMappingException, IOException;
	
	/**
	 * Save input single data to file.
	 * @param file File to save.
	 * @param data Input single data input.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	<T extends GenerateAble> void write(File file, T data) throws JsonGenerationException, JsonMappingException, IOException;
}

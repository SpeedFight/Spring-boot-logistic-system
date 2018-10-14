package com.bootLogisticSystem.logic.dataReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Provide specific data type parse.
 * 
 * @author Karol Łukasiewicz
 *
 */
public interface DataParser {

	/**
	 * Parse input file to obtain list with elements inside.
	 * 
	 * @param fileToParse Path to parsed file
	 * @param inputDataPojo Class of element inside parsed file. File class must extends GenerateAble.
	 * @return List with parsed files.
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	<T extends GenerateAble> List<T> parse(File fileToParse, Class<T> inputDataPojo)
			throws JsonParseException, JsonMappingException, IOException;

}

package com.bootLogisticSystem.logic.dataReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * Parse csv file to obtain specific data.
 * @author Karol Łukasiewicz
 *
 */
public class CsvDataParser implements DataParser{
	
	private CsvMapper csvMapper;

	/**
	 * Constructor
	 * @param csvMapper
	 */
	public CsvDataParser(CsvMapper csvMapper) {
		super();
		this.csvMapper = csvMapper;
	}

	@Override
	public <T extends GenerateAble> List<T> parse(File fileToParse, Class<T> inputDataPojo)
			throws JsonParseException, JsonMappingException, IOException {
		
		CsvSchema schema = CsvSchema.emptySchema().withHeader(); 
		 MappingIterator<T> dataIterator = csvMapper
				    .readerFor(inputDataPojo.getClass())
				    .with(schema)
				    .readValues(fileToParse);
		
		List<T> requests = new ArrayList<>();
		while (dataIterator.hasNext()) {
			requests.add(dataIterator.next());
	    }
		
		return requests;
	}

//	@Override
//	<T extends GenerateAble> public List<T> getRequests(InputStream document)
//			throws JsonParseException, JsonMappingException, IOException {
//		
//		CsvSchema schema = CsvSchema.emptySchema().withHeader(); 
//		 MappingIterator<Request> dataIterator = csvMapper()
//				    .readerFor(Request.class)
//				    .with(schema)
//				    .readValues(document);
//		
//		List<Request> requests = new ArrayList<>();
//		while (dataIterator.hasNext()) {
//			requests.add(dataIterator.next());
//	    }
//		
//		return requests;
//	}
//	
	

}

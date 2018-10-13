package com.bootLogisticSystem.logic.dataReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Component
public class CsvDataParser implements DataParser{
	
	@Autowired
	private CsvMapper csvMapper;

	@Override
	public <T extends GenerateAble> List<T> getRequests(InputStream document, T inputDataPojo)
			throws JsonParseException, JsonMappingException, IOException {
		
		CsvSchema schema = CsvSchema.emptySchema().withHeader(); 
		 MappingIterator<T> dataIterator = csvMapper
				    .readerFor(inputDataPojo.getClass())
				    .with(schema)
				    .readValues(document);
		
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

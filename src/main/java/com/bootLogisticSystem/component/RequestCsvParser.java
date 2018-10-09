package com.bootLogisticSystem.component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Component
public class RequestCsvParser implements DataParser{
	
	private CsvMapper csvMapper;
	
	@Bean
	public CsvMapper csvMapper() {
		csvMapper = new CsvMapper();	
		return csvMapper;
	}

	@Override
	public List<Request> getRequests(InputStream document)
			throws JsonParseException, JsonMappingException, IOException {
		
		CsvSchema schema = CsvSchema.emptySchema().withHeader(); 
		 MappingIterator<Request> dataIterator = csvMapper()
				    .readerFor(Request.class)
				    .with(schema)
				    .readValues(document);
		
		List<Request> requests = new ArrayList<>();
		while (dataIterator.hasNext()) {
			requests.add(dataIterator.next());
	    }
		
		return requests;
	}
	
	

}

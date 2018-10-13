package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * Class provide save report as csv file functionality.
 * 
 * @author Karol Łukasiewicz
 *
 */
public class CsvRaportWriter implements RaportWriter {

	private CsvMapper csvMapper;

	public CsvRaportWriter(CsvMapper csvMapper) {
		super();
		this.csvMapper = csvMapper;
	}

	@Override
	public <T extends GenerateAble> void write(File file, List<T> data) throws JsonGenerationException, JsonMappingException, IOException {	
			CsvSchema schema = csvMapper.schemaFor(data.get(0).getClass()).withHeader();
			ObjectWriter objectWriter = csvMapper.writer(schema);
			objectWriter.writeValue(file, data);
	}
}


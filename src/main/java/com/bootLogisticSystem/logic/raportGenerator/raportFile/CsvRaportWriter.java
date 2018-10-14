package com.bootLogisticSystem.logic.raportGenerator.raportFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	public <T extends GenerateAble> void write(File file, T data) throws JsonGenerationException, JsonMappingException, IOException {	
			CsvSchema schema = csvMapper.schemaFor(data.getClass()).withHeader();
			ObjectWriter objectWriter = csvMapper.writer(schema);
			objectWriter.writeValue(file, data);
	}
	
	@Override
	public <T extends GenerateAble> void writeList(File file, List<T> data)
			throws JsonGenerationException, JsonMappingException, IOException {
		csvMapper.addMixIn(data.get(0).getClass(), RaportCsvCustomHeader.class);
		CsvSchema schema = csvMapper.schemaFor(data.get(0).getClass()).withHeader();
		ObjectWriter objectWriter = csvMapper.writer(schema);
		objectWriter.writeValue(file, data);
	}

	class RaportCsvCustomHeader {

		@JsonProperty("Client_Id")
		private String clientId;

		@JsonProperty("Request_id")
		private int requestId;

		@JsonProperty("Name")
		private String name;

		@JsonProperty("Quantity")
		private int quantity;

		@JsonProperty("Price")
		private double price;
	}
}


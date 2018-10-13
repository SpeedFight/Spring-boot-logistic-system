package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Class provide save report as csv file functionality.
 * 
 * @author Karol Łukasiewicz
 *
 */
@Component
public class CsvRaportWriter implements RaportWriter {

	@Autowired
	private CsvMapper csvMapper;

	@Override
	public <T extends GenerateAble> void write(File file, List<T> data) {

		try {
			if (data.get(0) instanceof Request) {	
				//set custom header for request class
				csvMapper.addMixIn(data.get(0).getClass(), RaportCsvCustomHeader.class);
			}		
			
			CsvSchema schema = csvMapper.schemaFor(data.get(0).getClass()).withHeader();
			ObjectWriter objectWriter = csvMapper.writer(schema);
			objectWriter.writeValue(file, data);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
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

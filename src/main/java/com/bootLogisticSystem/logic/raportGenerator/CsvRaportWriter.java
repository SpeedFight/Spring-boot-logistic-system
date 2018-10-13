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
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
	public <T extends GenerateAble> void write(File file, List<T> data) throws JsonGenerationException, JsonMappingException, IOException {	
			CsvSchema schema = csvMapper.schemaFor(data.get(0).getClass()).withHeader();
			ObjectWriter objectWriter = csvMapper.writer(schema);
			objectWriter.writeValue(file, data);
	}
}


package com.bootLogisticSystem.logic.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * This class should be controlled by spring bean. Create all necessary mappers
 * to create files (eg. xml, csv)
 * 
 * @author Karol Łukasiewicz
 *
 */
@Component
public class MapperGenerator {

	@Bean
	public CsvMapper csvMapper() {
		CsvMapper csvMapper = new CsvMapper();
		csvMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return csvMapper;
	}

	@Bean
	public XmlMapper xmlMapper() {
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		return xmlMapper;
	}

}

/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import com.bootLogisticSystem.model.raportTemplates.OneValueReport;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ReadSingle {

	private CsvMapper csvMapper;
	private XmlMapper xmlMapper;

	public ReadSingle(CsvMapper csvMapper) {
		this.csvMapper = csvMapper;
	}

	public ReadSingle(XmlMapper xmlMapper) {
		this.xmlMapper = xmlMapper;
	}

	public OneValueReport parseOneValueCsv(File fileToParse)
			throws JsonParseException, JsonMappingException, IOException {

		CsvSchema schema = CsvSchema.emptySchema().withHeader();
		MappingIterator<OneValueReport> dataIterator = csvMapper.readerFor(OneValueReport.class).with(schema)
				.readValues(fileToParse);

		List<OneValueReport> requests = new ArrayList<>();
		while (dataIterator.hasNext()) {
			try {
				requests.add(dataIterator.next());
			} catch (RuntimeJsonMappingException e) {
				Logger.warn(e.getMessage());
			}
		}

		return requests.get(0);
	}

	public OneValueReport parseOneValueXml(File fileToParse)
			throws JsonParseException, JsonMappingException, IOException {

		return xmlMapper.readValue(fileToParse, new TypeReference<OneValueReport>() {});
	}

}

package com.bootLogisticSystem.logic.raportGenerator.raportFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bootLogisticSystem.dto.RequestDtoJacksonXml;
import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Class provide save report as xml file functionality.
 * @author Karol Łukasiewicz
 *
 */
public class XmlRaportWriter implements RaportWriter {
	
	private XmlMapper xmlMapper;

	public XmlRaportWriter(XmlMapper xmlMapper) {
		super();
		this.xmlMapper = xmlMapper;
	}

	@Override
	public <T extends GenerateAble> void write(File file, T data) throws JsonGenerationException, JsonMappingException, IOException {			
			xmlMapper.writeValue(file, data);			
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GenerateAble> void writeList(File file, List<T> data)
			throws JsonGenerationException, JsonMappingException, IOException {
		xmlMapper.writeValue(file, RequestDtoJacksonXml.toDto((List<Request>) data));	
	}
}
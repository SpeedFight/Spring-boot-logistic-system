package com.bootLogisticSystem.logic.raportGenerator.customOptions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.dto.RequestDtoJacksonXml;
import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.logic.raportGenerator.RaportWriter;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Component
public class RequestListRaportXmlCustomWriter implements RaportWriter {
	
	@Autowired
	private XmlMapper xmlMapper;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GenerateAble> void write(File file, List<T> data)
			throws JsonGenerationException, JsonMappingException, IOException {
		xmlMapper.writeValue(file, RequestDtoJacksonXml.toDto((List<Request>) data));	
	}

}

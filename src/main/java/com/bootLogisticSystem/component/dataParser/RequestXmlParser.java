package com.bootLogisticSystem.component.dataParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Component
public class RequestXmlParser implements DataParser {
	
	private XmlMapper xmlMapper;
	
	public RequestXmlParser() {
		xmlMapper = new XmlMapper();
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Override
	public List<Request> getRequests(InputStream document) throws JsonParseException, JsonMappingException, IOException {
		return xmlMapper.readValue(document,
				new TypeReference<List<@Valid Request>>() {
				});
	}

}

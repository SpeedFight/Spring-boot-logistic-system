package com.bootLogisticSystem.logic.dataReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Component
public class XmlDataParser implements DataParser {
	
	@Autowired
	private XmlMapper xmlMapper;

	@Override
	public <T extends GenerateAble> List<T> getRequests(InputStream document, T inputDataPojo)
			throws JsonParseException, JsonMappingException, IOException {
		
		return xmlMapper.readValue(document,
				new TypeReference<List<T>>() {
				});
	}

}

package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Component
public class XmlRaportWriter implements RaportWriter {

	@Override
	public <T extends GenerateAble> void write(File file, List<T> data) {		
		try {
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
			xmlMapper.writeValue(file, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

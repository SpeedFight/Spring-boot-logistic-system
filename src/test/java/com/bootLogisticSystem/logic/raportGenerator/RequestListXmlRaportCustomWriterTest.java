package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.logic.args.validators.ValidateInputPaths;
import com.bootLogisticSystem.logic.mapper.MapperGenerator;
import com.bootLogisticSystem.logic.raportGenerator.RaportFile.customWriter.RequestListRaportXmlCustomWriter;
import com.bootLogisticSystem.utils.RandomRequest;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestListXmlRaportCustomWriterTest {
	
	private static RequestListRaportXmlCustomWriter requestListRaportXmlCustomWriter;
	
	@BeforeClass
	public static void setUp() {
		requestListRaportXmlCustomWriter = new RequestListRaportXmlCustomWriter(new MapperGenerator().xmlMapper());
	}
	
	@Test
	public void saveRaport() throws JsonGenerationException, JsonMappingException, IOException {
		requestListRaportXmlCustomWriter.write(
				new File("src/test/testResources/testOutputFolder/outCustomRequestList.xml"), 
				RandomRequest.generate(100));
		
		
	}
}

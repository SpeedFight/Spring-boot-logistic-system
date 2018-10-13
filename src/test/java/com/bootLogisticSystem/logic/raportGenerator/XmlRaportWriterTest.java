package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.utils.RandomRequest;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlRaportWriterTest {
	
	@Autowired
	private XmlRaportWriter xmlRaportWriter;
	
	@Test
	public void saveRaport() throws JsonGenerationException, JsonMappingException, IOException {
		xmlRaportWriter.write(
				new File("src/test/testResources/testOutputFolder/out.xml"), 
				RandomRequest.generate(100));
		
		
	}
}

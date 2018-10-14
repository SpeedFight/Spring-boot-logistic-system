package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.logic.mapper.MapperGenerator;
import com.bootLogisticSystem.utils.RandomRequest;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvRaportWriterTest {
	
	private static CsvRaportWriter csvRaportWriter;
	
	@BeforeClass
	public static void setUp() {
		csvRaportWriter = new CsvRaportWriter(new MapperGenerator().csvMapper());
	}
	
	@Test
	public void saveRaport() throws JsonGenerationException, JsonMappingException, IOException {
		csvRaportWriter.write(
				new File("src/test/testResources/testOutputFolder/out.csv"), 
				RandomRequest.generate(100));
	}
}

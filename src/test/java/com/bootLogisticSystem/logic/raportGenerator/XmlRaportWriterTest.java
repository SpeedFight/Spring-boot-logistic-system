package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.utils.RandomRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlRaportWriterTest {
	
	@Autowired
	private XmlRaportWriter xmlRaportWriter;
	
	@Test
	public void saveRaport() {
		xmlRaportWriter.write(
				new File("src/test/testResources/testOutputFolder/out.xml"), 
				RandomRequest.generate(100));
	}
}

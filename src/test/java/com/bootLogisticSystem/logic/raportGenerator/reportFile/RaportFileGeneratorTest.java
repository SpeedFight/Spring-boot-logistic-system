package com.bootLogisticSystem.logic.raportGenerator.reportFile;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.logic.raportGenerator.RaportFileGenerator;
import com.bootLogisticSystem.logic.raportGenerator.raportFile.RaportWriterFactory;
import com.bootLogisticSystem.model.ReasultsContainer;
import com.bootLogisticSystem.utils.RandomRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaportFileGeneratorTest {

	@Autowired
	private RaportFileGenerator raportFileGenerator;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
	
		
	}

}

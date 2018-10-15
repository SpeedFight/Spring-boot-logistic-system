package com.bootLogisticSystem.logic.raportGenerator.reportFile;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidRaportWriterFound;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.logic.raportGenerator.raportFile.CsvRaportWriter;
import com.bootLogisticSystem.logic.raportGenerator.raportFile.RaportWriter;
import com.bootLogisticSystem.logic.raportGenerator.raportFile.RaportWriterFactory;
import com.bootLogisticSystem.logic.raportGenerator.raportFile.XmlRaportWriter;
import com.bootLogisticSystem.model.RaportType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RaportWriterFactoryTest {
	
	@Autowired
	RaportWriterFactory raportWriterFactory;
	
	private String getXmlFile() {
		return "test.xml";
	}
	
	private String getCsvFile() {
		return "test.csv";
	}
	
	
	@Test
	public void getXmlRaportTypeA() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getXmlFile(), RaportType.A);

		assertTrue(raportWriter instanceof XmlRaportWriter);
	}
	
	@Test
	public void getXmlRaportTypeB() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getXmlFile(), RaportType.B);

		assertTrue(raportWriter instanceof XmlRaportWriter);
	}
	
	@Test
	public void getXmlRaportTypeC() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getXmlFile(), RaportType.C);

		assertTrue(raportWriter instanceof XmlRaportWriter);
	}
	
	@Test
	public void getXmlRaportTypeD() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getXmlFile(), RaportType.D);

		assertTrue(raportWriter instanceof XmlRaportWriter);
	}
	
	@Test
	public void getXmlRaportTypeE() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getXmlFile(), RaportType.E);

		assertTrue(raportWriter instanceof XmlRaportWriter);
	}
	
	@Test
	public void getXmlRaportTypeF() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getXmlFile(), RaportType.F);

		assertTrue(raportWriter instanceof XmlRaportWriter);
	}
	
	@Test
	public void getXmlRaportTypeG() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getXmlFile(), RaportType.G);

		assertTrue(raportWriter instanceof XmlRaportWriter);
	}
	
	@Test
	public void getXmlRaportTypeH() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getXmlFile(), RaportType.H);

		assertTrue(raportWriter instanceof XmlRaportWriter);
	}	
	
	@Test
	public void getCsvRaportTypeA() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getCsvFile(), RaportType.A);

		assertTrue(raportWriter instanceof CsvRaportWriter);
	}
	
	@Test
	public void getCsvRaportTypeB() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getCsvFile(), RaportType.B);

		assertTrue(raportWriter instanceof CsvRaportWriter);
	}
	
	@Test
	public void getCsvRaportTypeC() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getCsvFile(), RaportType.C);

		assertTrue(raportWriter instanceof CsvRaportWriter);
	}
	
	@Test
	public void getCsvRaportTypeD() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getCsvFile(), RaportType.D);

		assertTrue(raportWriter instanceof CsvRaportWriter);
	}
	
	@Test
	public void getCsvRaportTypeE() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getCsvFile(), RaportType.E);

		assertTrue(raportWriter instanceof CsvRaportWriter);
	}
	
	@Test
	public void getCsvRaportTypeF() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getCsvFile(), RaportType.F);

		assertTrue(raportWriter instanceof CsvRaportWriter);
	}
	
	@Test
	public void getCsvRaportTypeG() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getCsvFile(), RaportType.G);

		assertTrue(raportWriter instanceof CsvRaportWriter);
	}
	
	@Test
	public void getCsvRaportTypeH() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		RaportWriter raportWriter = raportWriterFactory.getRaportWriter(getCsvFile(), RaportType.H);

		assertTrue(raportWriter instanceof CsvRaportWriter);
	}
	
	@Test(expected = WrongFilePathExtension.class)
	public void badFileExtension() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		raportWriterFactory.getRaportWriter("file.pdf", RaportType.A);
	}
	
	@Test(expected = NoFileExtensionException.class)
	public void noFileExtension() throws NoFileExtensionException, WrongFilePathExtension, NoValidRaportWriterFound {
		raportWriterFactory.getRaportWriter("file", RaportType.A);
	}
}

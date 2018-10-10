package com.bootLogisticSystem.logic.args.validators;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.exception.InvalidParameterException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateOutputPathTest {
	
	private static ValidateOutputPath validateOutputPath;
	
	@BeforeClass
	public static void setUp() {
		validateOutputPath = new ValidateOutputPath();
	}
	
	@Test
	public void createNewFile() throws InvalidParameterException, IOException {
		String path = "src/test/testResources/output.xml";
		
		File createdFile = validateOutputPath.validate(path);
		
		assertTrue(testWriteToFile(createdFile,"testString"));		
	}
	
	@Test
	public void createNewFileAndDirectory() throws InvalidParameterException, IOException {
		String path = "src/test/testResources/newDirectory/output.xml";
		
		File createdFile = validateOutputPath.validate(path);
		
		assertTrue(testWriteToFile(createdFile,"testString"));	
		
		createdFile.getParentFile().delete();
	}	
	
	
	private boolean testWriteToFile(File file, String testString) throws IOException {
		Writer writer = new FileWriter(file);
		writer.write("testString");
		writer.close();
		
		Reader reader = new FileReader(file);
		
		int i;
		String fileContent = "";
		while((i = reader.read()) != -1) {
			fileContent = fileContent + (char)i;
		}
		reader.close();
		
		if(!file.delete()) { 
			throw new IOException("Can't delete test file: " + file);
        }
		
		return (testString.compareTo(fileContent) == 0);
	}

}

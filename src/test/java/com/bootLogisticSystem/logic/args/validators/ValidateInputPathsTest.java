package com.bootLogisticSystem.logic.args.validators;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bootLogisticSystem.exception.InvalidParameterException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateInputPathsTest {

	private static ValidateInputPaths validateInputPaths;

	private static final String path = "src/test/testResources/inputPathValidatorTestFiles/";

	@BeforeClass
	public static void setUp() {
		validateInputPaths = new ValidateInputPaths();
	}

	private List<String> createFileList(String[] fileNames) {

		List<String> files = new ArrayList<>();

		for (String fileName : fileNames) {
			files.add(path + fileName);
		}

		return files;
	}

	@Test(expected = InvalidParameterException.class)
	public void noValidInputFiles() throws InvalidParameterException {
		String[] inputFileArray = { "no.jpg", "no.txt", "no.pdf", "folder/noSuchFile.xml", "Nofolder/noSuchFile.csv" };
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));
	}

	@Test
	public void oneCorrectInputFileXml() throws InvalidParameterException {

		String[] inputFileArray = { "ok1.xml" };
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));

		assertTrue(inputFileList.get(0).contentEquals(fileList.get(0).getPath()));
	}

	@Test
	public void twoCorrectInputFilesXml() throws InvalidParameterException {
		String[] inputFileArray = { "ok1.xml", "ok2.xml" };
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));

		for (int i = 0; i < fileList.size(); ++i) {
			assertTrue(inputFileList.get(i).contentEquals(fileList.get(i).getPath()));
		}
	}

	@Test
	public void threeCorrectInputFilesXml() throws InvalidParameterException {
		String[] inputFileArray = { "ok1.xml", "ok2.xml", "ok3.xml" };
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));

		for (int i = 0; i < fileList.size(); ++i) {
			assertTrue(inputFileList.get(i).contentEquals(fileList.get(i).getPath()));
		}
	}

	@Test
	public void oneCorrectInputFileCsv() throws InvalidParameterException {

		String[] inputFileArray = { "ok1.csv" };
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));

		assertTrue(inputFileList.get(0).contentEquals(fileList.get(0).getPath()));
	}

	@Test
	public void twoCorrectInputFilesCsv() throws InvalidParameterException {
		String[] inputFileArray = { "ok1.csv", "ok2.csv" };
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));

		for (int i = 0; i < fileList.size(); ++i) {
			assertTrue(inputFileList.get(i).contentEquals(fileList.get(i).getPath()));
		}
	}

	@Test
	public void threeCorrectInputFilesCsv() throws InvalidParameterException {
		String[] inputFileArray = { "ok1.csv", "ok2.csv", "ok3.csv" };
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));

		for (int i = 0; i < fileList.size(); ++i) {
			assertTrue(inputFileList.get(i).contentEquals(fileList.get(i).getPath()));
		}
	}

	@Test
	public void manyCorrectInputFiles() throws InvalidParameterException {
		String[] inputFileArray = { "ok1.xml", "ok2.xml", "ok3.xml", "ok1.csv", "ok2.csv", "ok3.csv" };
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));

		for (int i = 0; i < fileList.size(); ++i) {
			assertTrue(inputFileList.get(i).contentEquals(fileList.get(i).getPath()));
		}
	}

	@Test
	public void manyGoodAndManyWrongFile() throws InvalidParameterException {
		String[] inputFileArray = { "no.jpg", "ok1.xml", "no.pdf", "ok2.xml", "no.txt", "ok3.xml", "ok1.csv", "ok2.csv",
				"folder/noSuchFile.xml", "Nofolder/noSuchFile.csv", "ok3.csv" };
		
		String[] correctFileArray = { path+"ok1.xml", path+"ok2.xml", path+"ok3.xml", path+"ok1.csv", path+"ok2.csv", path+"ok3.csv" };
		
		List<String> inputFileList = createFileList(inputFileArray);

		List<File> fileList = validateInputPaths.validate(inputFileList.toArray(new String[inputFileList.size()]));

		for (int i = 0; i < fileList.size(); ++i) {
			assertTrue(correctFileArray[i].contentEquals(fileList.get(i).getPath()));
		}
	}

}

package com.bootLogisticSystem.utilsTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.utils.Utils;

public class UtilsTest {


	@Test
	public void getFileExtensionXml() throws NoFileExtensionException {
		String fileExtension = Utils.getFileExtensionFromPath("test.xml");
		assertTrue(fileExtension.equals("xml"));
	}
	
	@Test
	public void getFileExtensionCsv() throws NoFileExtensionException {
		String fileExtension = Utils.getFileExtensionFromPath("test.xml.csv");
		assertTrue(fileExtension.equals("csv"));
	}
	
	@Test(expected = NoFileExtensionException.class)
	public void noFileExtension() throws NoFileExtensionException {
		String fileExtension = Utils.getFileExtensionFromPath("test");
		assertTrue(fileExtension.equals("xml"));
	}
	
	@Test
	public void addDefaultFileExtensionNoDot() {
		String fileExtension = Utils.addDefaultFileExtension("test");
		assertTrue(fileExtension.equals("test.csv"));
	}
	
	@Test
	public void addDefaultFileExtension() {
		String fileExtension = Utils.addDefaultFileExtension("test.");
		assertTrue(fileExtension.equals("test.csv"));
	}
	
	@Test
	public void isFileExtensionSupportedXml() throws NoFileExtensionException, WrongFilePathExtension {
		boolean fileExtensionValid = Utils.isFileExtensionSupported("test.xml");
		assertTrue(fileExtensionValid);
	}
	
	@Test
	public void isFileExtensionSupportedCsv() throws NoFileExtensionException, WrongFilePathExtension {
		boolean fileExtensionValid = Utils.isFileExtensionSupported("test.csv");
		assertTrue(fileExtensionValid);
	}
	
	@Test(expected = WrongFilePathExtension.class)
	public void notSuporrtedFileExtensionGif() throws NoFileExtensionException, WrongFilePathExtension {
		boolean fileExtensionValid = Utils.isFileExtensionSupported("test.gif");
		assertFalse(fileExtensionValid);
	}
	
	@Test(expected = WrongFilePathExtension.class)
	public void notSuporrtedFileExtensionXm() throws NoFileExtensionException, WrongFilePathExtension {
		boolean fileExtensionValid = Utils.isFileExtensionSupported("test.gif");
		assertFalse(fileExtensionValid);
		
		fileExtensionValid = Utils.isFileExtensionSupported("test.xm");
		assertFalse(fileExtensionValid);
	}
	
}

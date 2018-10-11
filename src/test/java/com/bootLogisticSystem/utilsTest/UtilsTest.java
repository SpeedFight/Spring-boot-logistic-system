package com.bootLogisticSystem.utilsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bootLogisticSystem.exception.NoFileExtensionException;
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

}

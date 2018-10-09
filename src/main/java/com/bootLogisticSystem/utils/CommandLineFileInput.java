package com.bootLogisticSystem.utils;

import java.io.File;
import java.util.List;

public class CommandLineFileInput {

	private CommandLineFileInput() {};
	
	public static List<File> parseArgs(String[] args) {
		
		for(String filePath : args) {
			System.out.println(filePath);
		}
		
		return null;
	}
}

package com.bootLogisticSystem.utils;

import java.io.File;
import java.util.List;

public class CommandLine {

	private CommandLine() {};
	
	public static List<File> parseArgsAsFilePath(String[] args) {
		
		for(String filePath : args) {
			System.out.println(filePath);
		}
		
		return null;
	}
}

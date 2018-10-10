package com.bootLogisticSystem.logic.args.validators;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.model.RaportType;

public class ValidateOutputPath {

	public ValidateOutputPath() {};
	
	public File  validate(String outputPath) throws InvalidParameterException{		
		 File file = new File(outputPath);
		 Path path = Paths.get(outputPath);
		 
//		if (Files.isReadable(path) && Files.isWritable(path)) {
//			throw new InvalidParameterException("Path to save output file: " + outputPath + " is unacessable.");
//		}
		 
		
//		if (!file.isDirectory())
//			   if(!file.getParentFile().mkdirs()) {
//				   throw new InvalidParameterException("Can't create directories to: " + outputPath);
//			   }
//		if (file.exists()){
//			//overwrite
//		}
		 try {
			 if(!Files.exists(path)) {
				 Files.createDirectories(path.getParent());
			 }			
		} catch (Exception e) {
			throw new InvalidParameterException(e.getMessage());
		}
			
		return file;
	}
}

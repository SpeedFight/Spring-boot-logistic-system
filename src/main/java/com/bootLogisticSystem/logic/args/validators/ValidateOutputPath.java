package com.bootLogisticSystem.logic.args.validators;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.utils.Utils;

public class ValidateOutputPath {

	public ValidateOutputPath() {};
	
	public File validate(String outputPath) throws InvalidParameterException{		
		 File file = new File(outputPath);
		 
		 
		 try {
			Utils.isFileExtensionSupported(outputPath);
		 } catch (NoFileExtensionException | WrongFilePathExtension e) {
			outputPath = Utils.addDefaultFileExtension(outputPath);
		 }

		 
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
		 
		 Path path = Paths.get(outputPath);
		 try {
			 if(!Files.exists(path)) {
				 Files.createDirectories(path.getParent());
			 }			
		} catch (Exception e) {
			throw new InvalidParameterException("Can't create directories to: " 
					+ outputPath + "because: " + e.getMessage());
		}
			
		return file;
	}
}

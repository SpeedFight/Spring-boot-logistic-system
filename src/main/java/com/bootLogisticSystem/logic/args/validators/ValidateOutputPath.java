package com.bootLogisticSystem.logic.args.validators;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.pmw.tinylog.Logger;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.model.RaportType;
import com.bootLogisticSystem.utils.Utils;

public class ValidateOutputPath {

	public ValidateOutputPath() {};
	
	public File validate(String outputPath) throws InvalidParameterException{		
		 File file = new File(outputPath);
		 
		 

		 
//		if (Files.isReadable(path)) {
//			throw new InvalidParameterException("Path to save output file: " + outputPath + " is unacessable.");
//		}
//		 if(!Files.isRegularFile(path)) {
//			 throw new InvalidParameterException("Can't create file: " 
//						+ outputPath + " because it's not path to file");
//		 }
		 
		 
	
		 
		 Path path = Paths.get(outputPath);

		 if(Files.isDirectory(path)) {
			 try {
				Files.createDirectories(path.getParent());
				outputPath = Utils.getPathToFileWithDefaultName(outputPath);
			} catch (IOException e) {
				throw new InvalidParameterException("Can't create directories to: " 
						+ outputPath + " because: " + e.getMessage());
			}
		 }
		 
 
		 try {
			 if(!Files.exists(path)) {
				 Files.createDirectories(path.getParent());
			 }			
		} catch (Exception e) {
			
		}
			
		 try {
			 Utils.isFileExtensionSupported(outputPath);
		 } catch (NoFileExtensionException | WrongFilePathExtension e) {
			 String tmpOutputPath = outputPath;
			 outputPath = Utils.addDefaultFileExtension(outputPath);
			 
			 Logger.warn("Output file: " + tmpOutputPath + " is invalid, so now is"
					 		+ " changed to: " + outputPath);
		 } 
		 
		return file;
	}
}

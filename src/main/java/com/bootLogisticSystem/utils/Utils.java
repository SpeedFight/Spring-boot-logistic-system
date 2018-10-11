package com.bootLogisticSystem.utils;

import java.io.File;
import java.util.Optional;

import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.model.SupportedFileExtension;

public class Utils {
	
	private Utils() {};
	
	public static String getFileExtensionFromPath(String filePath) throws NoFileExtensionException {
        Optional<String> extension = Optional.empty();
 
        try {
        	extension = Optional.of(filePath.substring(filePath.lastIndexOf(".")));			
		} catch (StringIndexOutOfBoundsException e) {
			throw new NoFileExtensionException("No file extension");
		}
        
        if(!extension.isPresent()) {
        	throw new NoFileExtensionException("No file extension");
        }

        //eg. convert '.xml' to 'xml'
        return extension.get().substring(1);
    }
	
	public static String addDefaultFileExtension(String filePath) {
		
		if(!filePath.endsWith(".")) {
			filePath = filePath.concat(".");
		}
		return filePath.concat(SupportedFileExtension.getDefaultFileExtension());		
	}
	
	public static boolean isFileExtensionSupported(String filePath) throws NoFileExtensionException, WrongFilePathExtension {
		String fileExtension = getFileExtensionFromPath(filePath);
		
		for(SupportedFileExtension supportedFileExtension: SupportedFileExtension.values()) {
			if (supportedFileExtension.getFileExtension().equals(fileExtension)) {
				return true;
			}
		}
		
		throw new WrongFilePathExtension("File extension:" + fileExtension + 
				" for file: " +  filePath + " not supported");
	}
	
	public static String getPathToFileWithDefaultName(String pathToDirectory) {
		if(!pathToDirectory.endsWith(File.separator)) {
			pathToDirectory = pathToDirectory.concat(File.separator);
		}
		
		
		return pathToDirectory.concat("output.").concat(SupportedFileExtension.getDefaultFileExtension());
	}
}

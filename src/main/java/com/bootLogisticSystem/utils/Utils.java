package com.bootLogisticSystem.utils;

import java.util.Optional;

import com.bootLogisticSystem.exception.NoFileExtensionException;

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
}

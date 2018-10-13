package com.bootLogisticSystem.logic.raportGenerator;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidRaportWriterFound;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.model.InputArgument;

@Component
public class RaportGenerator {
	
	@Autowired
	private RaportWriterFactory raportWriterFactory;

	public <T extends GenerateAble> void save(InputArgument inputArguments, List<T> data) {
		try {
			
			RaportWriter raportWriter = raportWriterFactory.getRaportWriter(
					inputArguments.getOutputFile().getPath()
					, inputArguments.getRaportType());

			raportWriter.write(inputArguments.getOutputFile(), data);
			
		} catch (NoFileExtensionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongFilePathExtension e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoValidRaportWriterFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

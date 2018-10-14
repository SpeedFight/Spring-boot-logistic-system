package com.bootLogisticSystem.logic.raportGenerator;

import java.io.IOException;
import java.util.List;

import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.exception.NoFileExtensionException;
import com.bootLogisticSystem.exception.NoValidRaportWriterFound;
import com.bootLogisticSystem.exception.SaveOutputFileException;
import com.bootLogisticSystem.exception.WrongFilePathExtension;
import com.bootLogisticSystem.logic.raportGenerator.raportFile.RaportWriter;
import com.bootLogisticSystem.logic.raportGenerator.raportFile.RaportWriterFactory;
import com.bootLogisticSystem.model.InputArgument;
import com.bootLogisticSystem.model.ReasultsContainer;

@Component
public class RaportFileGenerator {

	@Autowired
	private RaportWriterFactory raportWriterFactory;

	public <T extends GenerateAble> void save(InputArgument inputArguments, List<T> data)
			throws SaveOutputFileException {

		boolean isAnyError = false;
		try {
			RaportWriter raportWriter = raportWriterFactory.getRaportWriter(inputArguments.getOutputFile().getPath(),
					inputArguments.getRaportType());

			raportWriter.write(inputArguments.getOutputFile(), data);

		} catch (NoFileExtensionException | WrongFilePathExtension e) {
			isAnyError = true;
			Logger.error(e.getMessage());
		} catch (NoValidRaportWriterFound e) {
			isAnyError = true;
			Logger.error("Filer writer for this output file: " + inputArguments.getOutputFile().getPath()
					+ " is not implemented");
		} catch (IOException e) {
			isAnyError = true;
			Logger.error(e.getMessage());
		}

		if (isAnyError) {
			throw new SaveOutputFileException("Error while save: " + inputArguments.getOutputFile().getPath());
		}
	}

	public void save(InputArgument inputArguments, ReasultsContainer reasult) throws SaveOutputFileException {
		
		
//		 if (reasult.dataClass instanceof List<?>) {
//			
//			
//		}
	}
}

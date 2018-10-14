package com.bootLogisticSystem.logic.raportGenerator;

import java.io.IOException;

import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	private void printData(InputArgument inputArguments, ReasultsContainer reasult) throws SaveOutputFileException {
		if (reasult.getOneValueReport() == null && reasult.getRequestsReport() == null) {
			throw new SaveOutputFileException("No data to print");
		}

		Logger.info("Output reasults for:  " + inputArguments.getRaportType().getDescription());

		if (reasult.getOneValueReport() != null) {
			Logger.info(
					reasult.getOneValueReport().getDescription() + "\n is: " + reasult.getOneValueReport().getValue());
		} else {
			for (Request oneRequest : reasult.getRequestsReport()) {
				Logger.info(oneRequest);
			}
		}
	}

	public void save(InputArgument inputArguments, ReasultsContainer reasult) throws SaveOutputFileException {

		if (inputArguments.getOutputFile() == null) {
			printData(inputArguments, reasult);
		}

		boolean isAnyError = false;
		try {

			if (reasult.getOneValueReport() == null && reasult.getRequestsReport() == null) {
				throw new SaveOutputFileException("No data to save");
			}

			RaportWriter raportWriter = raportWriterFactory.getRaportWriter(inputArguments.getOutputFile().getPath(),
					inputArguments.getRaportType());

			if (reasult.getOneValueReport() != null) {
				raportWriter.write(inputArguments.getOutputFile(), reasult.getOneValueReport());
			} else {
				raportWriter.writeList(inputArguments.getOutputFile(), reasult.getRequestsReport());
			}

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
}

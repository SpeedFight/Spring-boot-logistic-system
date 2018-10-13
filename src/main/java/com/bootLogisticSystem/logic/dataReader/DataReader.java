package com.bootLogisticSystem.logic.dataReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootLogisticSystem.entity.GenerateAble;
import com.bootLogisticSystem.exception.ImputFileEmpetyException;
import com.bootLogisticSystem.model.InputArgument;

@Component
public class DataReader {

	@Autowired
	SingleFileReader singleFileReader;

	public <T extends GenerateAble> List<T> parse(InputArgument inputArgument, Class<T> inputDataPojo) throws ImputFileEmpetyException {

		List<T> parsedData = new ArrayList<>();

		for(File fileToParse : inputArgument.getInputFiles()) {
			try {
				parsedData.addAll(singleFileReader.parse(fileToParse, inputDataPojo));
			} catch (ImputFileEmpetyException e) {
				Logger.warn(e.getMessage());
			}
		}
		
		if(parsedData.size() > 0) {
			return parsedData;
		} else {
			throw new ImputFileEmpetyException("All files selected to parse is empety or not contain valid data");
		}
	}
}

package com.bootLogisticSystem.logic.dataReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface DataParser {

	<T extends GenerateAble> List<T> parse(File fileToParse, Class<T> inputDataPojo) throws JsonParseException, JsonMappingException, IOException;

}

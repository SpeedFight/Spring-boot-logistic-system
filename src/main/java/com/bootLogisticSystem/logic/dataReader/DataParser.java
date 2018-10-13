package com.bootLogisticSystem.logic.dataReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface DataParser {

	<T extends GenerateAble> List<T> getRequests(InputStream document, T inputDataPojo) throws JsonParseException, JsonMappingException, IOException;

}

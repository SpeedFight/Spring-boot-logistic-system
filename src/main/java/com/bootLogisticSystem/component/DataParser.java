package com.bootLogisticSystem.component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.bootLogisticSystem.entity.Request;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface DataParser {

	List<Request> getRequests(InputStream document) throws JsonParseException, JsonMappingException, IOException;

}

package com.bootLogisticSystem.model;

import com.bootLogisticSystem.entity.Request;

public enum SupportedInputDataFormat {
	REQUEST("request", Request.class);
	
	private final String code;
	private final Object entityPOJO;
	
	private SupportedInputDataFormat(String code, Object entityPOJO) {
		this.code = code;
		this.entityPOJO = entityPOJO;
	}

	public String getCode() {
		return code;
	}

	public Object getEntityPOJO() {
		return entityPOJO;
	}
}

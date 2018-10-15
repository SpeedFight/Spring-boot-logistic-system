/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.model;

import java.util.List;

import com.bootLogisticSystem.entity.Request;
import com.bootLogisticSystem.model.raportTemplates.OneValueReport;

/**
 * Class provide to contain only one result value;
 * 
 * @author Karol Łukasiewicz
 *
 */
public class ReasultsContainer {

	private OneValueReport oneValueReport;

	private List<Request> requestsReport;

	public ReasultsContainer(OneValueReport oneValueReport) {
		this.oneValueReport = oneValueReport;
	}

	public ReasultsContainer(List<Request> requestsReport) {
		this.requestsReport = requestsReport;
	}

	public OneValueReport getOneValueReport() {
		return oneValueReport;
	}

	public List<Request> getRequestsReport() {
		return requestsReport;
	}
}

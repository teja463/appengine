package com.teja.appengine.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	
	List<Request> request;
	@JsonProperty("current_condition")
	List<CurrentCondition> currentCondition;

	public List<Request> getRequest() {
		return request;
	}

	public void setRequest(List<Request> request) {
		this.request = request;
	}

	public List<CurrentCondition> getCurrentCondition() {
		return currentCondition;
	}

	public void setCurrentCondition(List<CurrentCondition> currentCondition) {
		this.currentCondition = currentCondition;
	}

	@Override
	public String toString() {
		return "Data [request=" + request + ", currentCondition=" + currentCondition + "]";
	}
}

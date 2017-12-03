package com.teja.appengine.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentCondition {

	@JsonProperty("temp_C")
	private String tempC;
	
	@JsonProperty("temp_F")
	private String tempF;

	public String getTempC() {
		return tempC;
	}

	public void setTempC(String tempC) {
		this.tempC = tempC;
	}

	public String getTempF() {
		return tempF;
	}

	public void setTempF(String tempF) {
		this.tempF = tempF;
	}
	
	@Override
	public String toString() {
		return "CurrentCondition [tempC=" + tempC + ", tempF=" + tempF + "]";
	}
}

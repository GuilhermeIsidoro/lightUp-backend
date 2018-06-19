package com.lightUp.Request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewDevice {
	
	@NotEmpty
	@JsonProperty("name")
	private String name;
	
	@NotEmpty
	@JsonProperty("deviceConsumption")
	private Integer deviceConsumption;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getDeviceConsumption() {
		return deviceConsumption;
	}
	
	public void setDeviceConsumption(Integer deviceConsumption) {
		this.deviceConsumption = deviceConsumption;
	}

}

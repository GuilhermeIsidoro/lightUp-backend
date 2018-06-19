package com.lightUp.Request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateDevice {
	
	@NotEmpty
	@JsonProperty("id")
	private Integer id;
	
	@NotEmpty
	@JsonProperty("name")
	private String name;
	
	@NotEmpty
	@JsonProperty("deviceConsumption")
	private Integer deviceConsumption;
	
	@NotEmpty
	@JsonProperty("status")
	private Integer status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}	

}

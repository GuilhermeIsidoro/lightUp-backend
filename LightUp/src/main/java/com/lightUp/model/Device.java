package com.lightUp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "device")
public class Device {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotBlank
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "device_on", nullable = false)
	private Integer deviceOn;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_of_change", nullable = false)
	private java.util.Date timeOfChange;
	
	@NotNull
	@Column(name = "period_consumption", nullable = false)
	private Double periodConsumption;
	
	@NotNull
	@Column(name = "on_timer", nullable = false)
	private Long onTimer;
	
	@NotNull
	@Column(name = "device_consumption", nullable = false)
	private Integer deviceConsumption;
	
	@NotNull
	@Column(name = "status", nullable = false)
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

	public Integer getDeviceOn() {
		return deviceOn;
	}

	public void setDeviceOn(Integer on) {
		this.deviceOn = on;
	}

	public java.util.Date getTimeOfChange() {
		return timeOfChange;
	}

	public void setTimeOfChange(java.util.Date timeOfChange) {
		this.timeOfChange = timeOfChange;
	}

	public Double getPeriodConsumption() {
		return periodConsumption;
	}

	public void setPeriodConsumption(Double periodConsumption) {
		this.periodConsumption = periodConsumption;
	}

	public Long getOnTimer() {
		return onTimer;
	}

	public void setOnTimer(Long onTimer) {
		this.onTimer = onTimer;
	}

	public Integer getDeviceConsumption() {
		return deviceConsumption;
	}

	public void setDeviceConsumption(Integer deviceConsumption) {
		this.deviceConsumption = deviceConsumption;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}

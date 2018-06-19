package com.lightUp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "consumptionHistory")
public class ConsumptionHistory {
	
	@Id
	@Column(name = "history", nullable = false)
	private String history;
	
	@NotBlank
	@Column(name = "on_period", nullable = false)	
	private Double onPeriod;
	
	@NotBlank
	@Column(name = "device_id", nullable = false)
	private Long device_id;

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Double getOnPeriod() {
		return onPeriod;
	}

	public void setOnPeriod(Double onPeriod) {
		this.onPeriod = onPeriod;
	}

	public Long getDevice_id() {
		return device_id;
	}

	public void setDevice_id(Long device_id) {
		this.device_id = device_id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((history == null) ? 0 : history.hashCode());
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
		ConsumptionHistory other = (ConsumptionHistory) obj;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		return true;
	}

}

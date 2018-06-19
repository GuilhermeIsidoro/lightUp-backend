package com.lightUp.Return;

import java.util.ArrayList;
import java.util.List;

import com.lightUp.model.Device;

public class GetDeviceReturn extends Default {
	
	private List<Device> devices = new ArrayList<Device>();

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

}

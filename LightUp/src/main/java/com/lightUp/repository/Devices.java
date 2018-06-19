package com.lightUp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lightUp.model.Device;

public interface Devices extends JpaRepository<Device, Integer> {
	
	Device findByIdAndStatus(Integer id, Integer status);
	
	List<Device> findAllByStatus(Integer status);

}

package com.lightUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lightUp.model.ConsumptionHistory;

public interface History extends JpaRepository<ConsumptionHistory, Long> {

}

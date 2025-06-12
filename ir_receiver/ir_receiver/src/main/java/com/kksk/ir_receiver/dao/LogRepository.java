package com.kksk.ir_receiver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kksk.ir_receiver.model.LogModel;

public interface LogRepository extends JpaRepository<LogModel, Long> {

}

package com.kksk.ir_receiver.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kksk.ir_receiver.model.ActionModel;

public interface ActionsRepository extends JpaRepository<ActionModel, Long> {
	
	Optional<ActionModel> findByDeviceIDAndCode(String deviceId, String code);
	
}

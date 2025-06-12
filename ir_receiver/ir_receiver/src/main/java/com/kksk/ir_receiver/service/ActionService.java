package com.kksk.ir_receiver.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kksk.ir_receiver.dao.ActionsRepository;
import com.kksk.ir_receiver.model.ActionModel;

@Service
public class ActionService {
	
    private final ActionsRepository actionRepository;
    
    public ActionService(ActionsRepository actionRepository) {
        this.actionRepository = actionRepository;
    }
    
    public ActionModel getAction(String deviceId, String code)
    {
    	Optional<ActionModel> e = this.actionRepository.findByDeviceIDAndCode(deviceId, code);
    	if(e.isPresent())
    		return e.get();
    	else
    		return null;
    }

}

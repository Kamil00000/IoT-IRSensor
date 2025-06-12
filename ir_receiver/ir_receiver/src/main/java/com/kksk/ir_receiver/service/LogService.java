package com.kksk.ir_receiver.service;

import org.springframework.stereotype.Service;

import com.kksk.ir_receiver.dao.LogRepository;
import com.kksk.ir_receiver.model.LogModel;

@Service
public class LogService {
	
    private final LogRepository logRepository;
    
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }
    
    
    public LogModel addLog(LogModel log)
    {
    	return logRepository.save(log);
    }
    
}

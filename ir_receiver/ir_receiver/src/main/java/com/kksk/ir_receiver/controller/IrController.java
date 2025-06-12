package com.kksk.ir_receiver.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kksk.ir_receiver.model.ActionModel;
import com.kksk.ir_receiver.model.LogModel;
import com.kksk.ir_receiver.service.ActionService;
import com.kksk.ir_receiver.service.CommandService;
import com.kksk.ir_receiver.service.LogService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/ir")
public class IrController {

    private final ActionService actionService;
    private final LogService logService;
    private final CommandService commandService;

    public IrController(ActionService actionService, LogService logService, CommandService commandService) {
        this.actionService = actionService;
        this.logService = logService;
        this.commandService = commandService;
    }


    @PostMapping("/submit")
    public ResponseEntity<Void> submitIrCode(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        String clientId = request.getOrDefault("clientId", "default");
        String deviceID = request.get("deviceId");
        String command;
          
        
        ActionModel action = actionService.getAction(deviceID, code);
        
        if(action != null)
        {
            LogModel log = new LogModel(null, deviceID, clientId, code, action.getAction());
            this.logService.addLog(log);
            command = action.getAction();
        }
        else
        {
        	command = "none";
        }
        

        
        
        
        if (!"none".equals(command)) {
            commandService.addCommand(clientId, command);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-command")
    public ResponseEntity<Map<String, String>> getCommand(@RequestParam(defaultValue = "default") String clientId) {
        String command = commandService.getNextCommand(clientId);
        Map<String, String> response = new HashMap<>();
        response.put("command", command);
        return ResponseEntity.ok(response);
    }
}
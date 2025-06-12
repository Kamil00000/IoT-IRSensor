package com.kksk.ir_receiver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "actions")
public class ActionModel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String deviceID;
	
	private String code;
	
	private String action;
	
	public ActionModel(Long id, String deviceID, String code, String action) {
		super();
		this.id = id;
		this.deviceID = deviceID;
		this.code = code;
		this.action = action;
	}
	
	
	
	public ActionModel() {
		super();
	}



	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "ActionModel [deviceID=" + deviceID + ", code=" + code + ", action=" + action + "]";
	}
	
	
	
	
	

}

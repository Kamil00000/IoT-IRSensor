package com.kksk.ir_receiver.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class LogModel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    
	private String deviceID;
	
	private String clientID;
	
	private String code;
	
	private String action;
	
	private Timestamp date;
	
	
	public LogModel(Long id, String deviceID, String clientID, String code, String action) {
		super();
		this.deviceID = deviceID;
		this.code = code;
		this.action = action;
		this.clientID = clientID;
		this.date = new Timestamp(System.currentTimeMillis());
		this.id = id;
	}
	
	
	
	public LogModel() {
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
	


	public String getclientID() {
		return clientID;
	}



	public void setclientID(String clientID) {
		this.clientID = clientID;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Timestamp getDate() {
		return date;
	}



	public void setDate(Timestamp date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "LogModel [deviceID=" + deviceID + ", code=" + code + ", action=" + action + ", clientID=" + this.clientID +"]";
	}

}

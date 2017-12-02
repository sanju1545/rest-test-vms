package com.proj.test.vms.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private int errorCode;
	private String errorMessage;
	private String description;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(int errCode, String errMsg, String errDesc) {
		super();
		this.errorCode=errCode;
		this.errorMessage=errMsg;
		this.description=errDesc;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}

package com.proj.test.vms.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2784745385248025969L;
	
	public DataNotFoundException() {
	}
	
	public DataNotFoundException(String error) {
		super(error);
	}

}

package com.foo.model;

/**
 * <p>Description: </p>
 * @author JiaSonglin
 * @version V1.0,2017年1月6日 上午10:46:28
 */
public class ControllerMessage {

	private boolean succeeded;
	private String message;
	public boolean isSucceeded() {
		return succeeded;
	}
	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

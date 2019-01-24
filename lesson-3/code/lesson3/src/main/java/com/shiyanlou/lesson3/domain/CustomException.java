package com.shiyanlou.lesson3.domain;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4067845000251987011L;
	private int code;
	private String msg;
	
	public CustomException(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

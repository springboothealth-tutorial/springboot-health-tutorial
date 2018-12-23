package com.shiyanlou.calculator.domain;

public class ResultObject {

	private double result;
	private int code;
	private String msg;
	
	public ResultObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultObject(double result, int code, String msg) {
		super();
		this.result = result;
		this.code = code;
		this.msg = msg;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
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

	@Override
	public String toString() {
		return "ResultObject [result=" + result + ", code=" + code + ", msg=" + msg + "]";
	}
}

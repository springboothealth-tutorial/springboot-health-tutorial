package com.shiyanlou.lesson2.domain;

public class ResultObject {

	private int code;
	private String msg;
	private Object result;
	public ResultObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultObject(int code, String msg, Object result) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
	}
	
	public ResultObject(Object result) {
		super();
		this.code = 0;
		this.msg = "success";
		this.result = result;
	}
	
	public ResultObject(String msg) {
		super();
		this.code = -1;
		this.msg = msg;
		this.result = null;
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
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ResultObject [code=" + code + ", msg=" + msg + ", result=" + result + "]";
	}
}

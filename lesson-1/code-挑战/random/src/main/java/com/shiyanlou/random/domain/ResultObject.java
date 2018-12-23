package com.shiyanlou.random.domain;

import java.util.List;

public class ResultObject {

	private List<Double> result;
	private int code;
	private String msg;
	
	public ResultObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultObject(List<Double> result, int code, String msg) {
		super();
		this.result = result;
		this.code = code;
		this.msg = msg;
	}

	public List<Double> getResult() {
		return result;
	}

	public void setResult(List<Double> result) {
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

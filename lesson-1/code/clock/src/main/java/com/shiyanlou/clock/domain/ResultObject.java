package com.shiyanlou.clock.domain;

public class ResultObject {

	private double result;
	private String status;
	private String reason;
	
	public ResultObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultObject(double result, String status, String reason) {
		super();
		this.result = result;
		this.status = status;
		this.reason = reason;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ResultObject [result=" + result + ", status=" + status + ", reason=" + reason + "]";
	}
}

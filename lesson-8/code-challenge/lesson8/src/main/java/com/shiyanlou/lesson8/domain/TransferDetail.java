package com.shiyanlou.lesson8.domain;

public class TransferDetail {

	private int id;
	private int userId;
	private int doctorId;
	private int money;
	
	public TransferDetail() {
		// TODO Auto-generated constructor stub
	}

	public TransferDetail(int userId, int doctorId, int money) {
		super();
		this.userId = userId;
		this.doctorId = doctorId;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "TransferDetail [id=" + id + ", userId=" + userId + ", doctorId="
				+ doctorId + ", money=" + money + "]";
	}
}

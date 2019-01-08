package com.shiyanlou.lesson8.domain;

public class OrderDetail {

	private int id;
	private int userId;
	private int doctorId;
	private int money;
	private String comment;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int userId, int doctorId, int money, String comment) {
		super();
		this.userId = userId;
		this.doctorId = doctorId;
		this.money = money;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", userId=" + userId + ", doctorId=" + doctorId + ", money=" + money
				+ ", comment=" + comment + "]";
	}
}

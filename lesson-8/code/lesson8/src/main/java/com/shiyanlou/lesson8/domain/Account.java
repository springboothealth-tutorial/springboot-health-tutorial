package com.shiyanlou.lesson8.domain;

public class Account {

	private int id;
	private int userId;
	private int balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int userId, int balance) {
		super();
		this.userId = userId;
		this.balance = balance;
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", userId=" + userId + ", balance=" + balance + "]";
	}
}

package com.shiyanlou.lesson2.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account{

	@JsonInclude(Include.NON_NULL)
	private int id;
	@JsonProperty("name")
	private String username;
	
	private String password;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="GMT+8")
	private Date date;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String username, String password, Date date) {
		super();
		this.username = username;
		this.password = password;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", date=" + date + "]";
	}
	
}

package com.shiyanlou.lesson8.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class User{

	private int id;
	private String name;
	@JsonInclude(Include.NON_DEFAULT)
	private int gender;
	@JsonInclude(Include.NON_DEFAULT)
	private int age;
	
	// 多对一
	@JsonInclude(Include.NON_DEFAULT)
	private Doctor doctor;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, int gender, int age, Doctor doctor) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", doctor="
				+ doctor + "]";
	}	
}

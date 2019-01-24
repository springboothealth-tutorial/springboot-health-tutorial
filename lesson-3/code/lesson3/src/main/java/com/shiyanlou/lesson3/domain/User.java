package com.shiyanlou.lesson3.domain;

public class User{

	private int id;
	private String name;
	private int gender;
	private int age;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, int gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}	
}

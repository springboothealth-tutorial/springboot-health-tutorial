package com.shiyanlou.lesson5.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class User{

	private int id;
	private String name;
	@JsonInclude(Include.NON_DEFAULT)
	private int gender;
	@JsonInclude(Include.NON_DEFAULT)
	private int age;
	
	// 一对一
	@JsonInclude(Include.NON_DEFAULT)
	private Card card;	

	// 多对一
	@JsonInclude(Include.NON_DEFAULT)
	private Job job;
	
	// 多对多
	@JsonInclude(Include.NON_DEFAULT)
	private List<Hobby> hobbies;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, int gender, int age, Card card, Job job, List<Hobby> hobbies) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.card = card;
		this.job = job;
		this.hobbies = hobbies;
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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", card=" + card + ", job="
				+ job + ", hobbies=" + hobbies + "]";
	}	
}

package com.shiyanlou.lesson5.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Job {

	private int id;
	private String name;
	private String description;
	
	// 一对多
	@JsonInclude(Include.NON_DEFAULT)
	private List<User> users;
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(String name, String description, List<User> users) {
		super();
		this.name = name;
		this.description = description;
		this.users = users;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", description=" + description + ", users=" + users + "]";
	}
}

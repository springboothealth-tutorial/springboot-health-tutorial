package com.shiyanlou.lesson6.domain;

public class IndexType {

	private int id;
	private String name;
	private int type;
	public IndexType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IndexType(String name, int type) {
		super();
		this.name = name;
		this.type = type;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "IndexType [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
}

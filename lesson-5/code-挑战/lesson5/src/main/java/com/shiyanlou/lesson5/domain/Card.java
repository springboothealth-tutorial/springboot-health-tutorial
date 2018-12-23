package com.shiyanlou.lesson5.domain;

public class Card {
	private int id;
	private int code;
	private int level;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int code, int level) {
		super();
		this.code = code;
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", code=" + code + ", level=" + level + "]";
	}
}

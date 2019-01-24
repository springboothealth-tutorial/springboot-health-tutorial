package com.shiyanlou.lesson3.domain;

public class Book{

	private int id;
	private String name;
	private String author;
	private String press;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, String author, String press) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.press = press;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", press=" + press + "]";
	}	
}

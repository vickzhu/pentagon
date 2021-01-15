package com.pentagon.web.constant;

public class User {

	private String first;
	private String last;
	private String name;

	public User() {

	}

	public User(String first, String last, String name) {
		super();
		this.first = first;
		this.last = last;
		this.name = name;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package com.rs.todo.service;

import java.util.Date;

public class Todo {
	private long id;
	
	private String name;
	
	private String desc;
	
	private Date targetDate;
	
	private boolean isComplete;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Todo(long id, String name, String desc, Date targetDate, boolean isComplete) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isComplete = isComplete;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	

}

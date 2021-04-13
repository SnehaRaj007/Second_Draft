package com.love2code.springboot.crudDemo.Model;

public class InputJson {
	
	String date;

	public InputJson() {
		
	}

	public InputJson(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InputJson [date=" + date + "]";
	}
	

}

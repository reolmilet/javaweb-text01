package com.example.jsp.main.pojo;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	private String sid;
	private String sname;

    	private String gender;
		private String class_id;
	// 其他属性...\


	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	@Override
	public String toString() {
		return "Product{" +
				"sid='" + sid + '\'' +
				", sname='" + sname + '\'' +
				", gender='" + gender + '\'' +
				", class_id='" + class_id + '\'' +
				'}';
	}
}

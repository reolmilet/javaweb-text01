package com.example.javawebtext01.main.pojo;

import java.io.Serializable;

public class Userdata implements Serializable{

	int userId;
	String userName;
	String password;
	String sex;
	String email;
	int manager;
	int delete;

	public Userdata() {
	}

	public Userdata(String userName, String password, String sex, String email, int manager) {
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.manager = manager;
	}

	public Userdata(int userId, String userName, String password, String sex, String email) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "Userdata{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", sex='" + sex + '\'' +
				", email='" + email + '\'' +
				", manager=" + manager +
				'}';
	}
}

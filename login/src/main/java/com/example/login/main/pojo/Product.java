package com.example.login.main.pojo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	private String sid;
	private String sname;
	// 其他属性...

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

	@Override
	public String toString() {
		return "Product{" +
				"sid='" + sid + '\'' +
				", sname='" + sname + '\'' +
				'}';
	}
}

package com.example.daoweb.main.pojo;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	private String sid;
	private String sname;

	private String cname;
	private String num;
	// 其他属性...

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

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

	public Product() {
	}

	@Override
	public String toString() {
		return "Product{" +
				"sid='" + sid + '\'' +
				", sname='" + sname + '\'' +
				", cname='" + cname + '\'' +
				", num='" + num + '\'' +
				'}';
	}
}

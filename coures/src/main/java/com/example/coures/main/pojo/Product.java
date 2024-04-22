package com.example.coures.main.pojo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	private int sid;		//分数id
	private int student_id;	//学生id
	private int course_id;			//课程id
	private int num;			//分数

	public Product() {				//无参的构造方法
		super();
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Product{" +
				"sid=" + sid +
				", student_id=" + student_id +
				", course_id=" + course_id +
				", num=" + num +
				'}';
	}
}

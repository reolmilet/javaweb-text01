package com.example.jsp116.pojo;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	private String product_id;		//产品号
	private String product_name;	//产品名称
	private double price;			//产品价格
	private String info;			//产品信息

	public Product() {				//无参的构造方法
		super();
	}

	public Product(String product_id, String product_name, double price, String info) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.info = info;
	}
	public Product(String product_id) {
		this.product_id = product_id;

	}

	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String productId) {
		product_id = productId;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String productName) {
		product_name = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Product{" +
				"product_id='" + product_id + '\'' +
				", product_name='" + product_name + '\'' +
				", price=" + price +
				", info='" + info + '\'' +
				'}'+"\n";
	}
}

package com.example.jsp.main.service;

import com.example.jsp.main.dao.ProductDao;
import com.example.jsp.main.dao.ProductDaoImpl;
	import com.example.jsp.main.pojo.Product;
import com.example.jsp.main.db.DBConnection;

import java.util.List;


public class ProductDaoService implements ProductDao {
	private DBConnection dbconn = null; // 定义数据库连接类
	private ProductDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public ProductDaoService() throws Exception {

		this.dbconn = new DBConnection();

		this.dao = new ProductDaoImpl(this.dbconn.getConnection());// 实例化ProductDao的实现类
	}


	@Override
	public List<Product> find(String class_id) throws Exception {
		List<Product> products = null;
		try {
			 products = this.dao.find(class_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return products;
	}
}

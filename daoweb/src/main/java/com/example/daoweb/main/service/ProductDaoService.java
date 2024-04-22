package com.example.daoweb.main.service;

import com.example.daoweb.main.dao.ProductDao;
import com.example.daoweb.main.dao.ProductDaoImpl;
import com.example.daoweb.main.db.DBConnection;
import com.example.daoweb.main.pojo.Product;


public class ProductDaoService implements ProductDao {
	private DBConnection dbconn = null; // 定义数据库连接类
	private ProductDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public ProductDaoService() throws Exception {

		this.dbconn = new DBConnection();

		this.dao = new ProductDaoImpl(this.dbconn.getConnection());// 实例化ProductDao的实现类
	}


	@Override
	public Product find(String sid, String sname) throws Exception {
		Product product = null;
		try {
			product = this.dao.find(sid, sname);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return product;
	}
}

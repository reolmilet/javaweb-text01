package com.example.javawebtext01.main.service;

import com.example.javawebtext01.main.dao.ProductDao;
import com.example.javawebtext01.main.dao.ProductDaoImpl;
import com.example.javawebtext01.main.db.DBConnection;
import com.example.javawebtext01.main.pojo.Userdata;

import java.sql.SQLException;
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
	public boolean add(Userdata userdata) throws Exception {
		boolean flag = false; // 标识
		try {
			//if (this.dao.findByProductId(product.getProduct_id()) == null) {// 如果要插入的产品编号不存在
			flag = this.dao.add(userdata);// 新增一条产品信息
			//}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}
	@Override
	public Userdata find(String username, String password) throws Exception {
		Userdata userdata = null;
		try {
			userdata = this.dao.find(username, password);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return userdata;
	}

	@Override
	public List<Userdata> findall(String username, String password) throws Exception {
		List<Userdata> userdatalist = null;
		try {
			userdatalist = this.dao.findall(username, password);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return userdatalist;
	}

	@Override
	public boolean update(Userdata userdata, int uid) throws Exception {
		boolean flag = false; // 标识
		try {
			//if (this.dao.findByProductId(product.getProduct_id()) == null) {// 如果要插入的产品编号不存在
			flag = this.dao.update(userdata,uid);// 新增一条产品信息
			//}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}

	@Override
	public boolean delete(int uid) throws Exception {
		boolean flag = false; // 标识
		try {
			//if (this.dao.findByProductId(product.getProduct_id()) == null) {// 如果要插入的产品编号不存在
			flag = this.dao.delete( uid);// 新增一条产品信息
			//}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}

}

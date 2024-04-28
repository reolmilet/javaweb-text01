package com.example.javawebtext01.main.service;

import com.example.javawebtext01.main.dao.QuestionDao;
import com.example.javawebtext01.main.dao.QuestionDaoImpl;
import com.example.javawebtext01.main.db.DBConnection;
import com.example.javawebtext01.main.pojo.QuestionData;

import java.util.List;


public class QuestionDaoService implements QuestionDao {
	private DBConnection dbconn = null; // 定义数据库连接类
	private QuestionDao dao = null; // 声明DAO对象
	// 在构造方法中实例化数据库连接，同时实例化dao对象
	public QuestionDaoService() throws Exception {

		this.dbconn = new DBConnection();

		this.dao = new QuestionDaoImpl(this.dbconn.getConnection());// 实例化ProductDao的实现类
	}





	@Override
	public boolean add(QuestionData questionData) throws Exception {
		boolean flag = false; // 标识
		try {
			//if (this.dao.findByProductId(product.getProduct_id()) == null) {// 如果要插入的产品编号不存在
			flag = this.dao.add(questionData);// 新增一条产品信息
			//}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}
}

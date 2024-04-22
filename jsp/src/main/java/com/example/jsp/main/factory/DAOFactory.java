package com.example.jsp.main.factory;

import com.example.jsp.main.dao.ProductDao;
import com.example.jsp.main.service.ProductDaoService;

public class DAOFactory {
    public static ProductDao getIEmpDAOInstance()throws Exception {
        return new ProductDaoService();//取得业务操作类
    }
}

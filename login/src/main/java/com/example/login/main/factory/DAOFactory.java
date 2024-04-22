package com.example.login.main.factory;

import com.example.login.main.dao.ProductDao;
import com.example.login.main.service.ProductDaoService;

public class DAOFactory {
    public static ProductDao getIEmpDAOInstance()throws Exception {
        return new ProductDaoService();//取得业务操作类
    }
}

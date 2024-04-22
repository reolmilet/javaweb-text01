package com.example.daoweb.main.factory;

import com.example.daoweb.main.dao.ProductDao;
import com.example.daoweb.main.service.ProductDaoService;

public class DAOFactory {
    public static ProductDao getIEmpDAOInstance()throws Exception {
        return new ProductDaoService();//取得业务操作类
    }
}

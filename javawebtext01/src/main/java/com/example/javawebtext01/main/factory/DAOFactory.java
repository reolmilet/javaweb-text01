package com.example.javawebtext01.main.factory;

import com.example.javawebtext01.main.dao.ProductDao;
import com.example.javawebtext01.main.service.ProductDaoService;

public class DAOFactory {
    public static ProductDao getIEmpDAOInstance()throws Exception {
        return new ProductDaoService();//取得业务操作类
    }
}

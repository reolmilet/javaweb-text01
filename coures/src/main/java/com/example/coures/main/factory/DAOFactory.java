package com.example.coures.main.factory;

import com.example.coures.main.dao.ProductDao;
import com.example.coures.main.service.ProductDaoService;

public class DAOFactory {
    public static ProductDao getIEmpDAOInstance()throws Exception {
        //System.out.println("建立了一个ProductDaoFactory对象");
        return new ProductDaoService();//取得业务操作类
    }
}

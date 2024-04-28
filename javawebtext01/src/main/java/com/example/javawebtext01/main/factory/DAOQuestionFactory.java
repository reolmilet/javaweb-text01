package com.example.javawebtext01.main.factory;

import com.example.javawebtext01.main.dao.QuestionDao;
import com.example.javawebtext01.main.service.QuestionDaoService;

public class DAOQuestionFactory {
    public static QuestionDao getIEmpDAOInstance()throws Exception {
        return new QuestionDaoService();//取得业务操作类
    }
}

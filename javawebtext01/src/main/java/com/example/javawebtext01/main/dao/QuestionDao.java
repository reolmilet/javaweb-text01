package com.example.javawebtext01.main.dao;

import com.example.javawebtext01.main.pojo.QuestionData;
import com.example.javawebtext01.main.pojo.Userdata;

import java.util.List;

public interface QuestionDao {
    boolean add( QuestionData questionData) throws Exception;
    List<QuestionData> findQuestionAll () throws Exception;
    boolean deleteQuestion(int questionId) throws Exception;
}

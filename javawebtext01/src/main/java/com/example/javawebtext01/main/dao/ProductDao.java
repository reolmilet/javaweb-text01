package com.example.javawebtext01.main.dao;

import com.example.javawebtext01.main.pojo.Userdata;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    boolean add(Userdata userdata) throws Exception;
    Userdata find (String username ,String password) throws Exception;
    List<Userdata> findall (String username , String password) throws Exception;
    boolean update(Userdata userdata,int uid) throws Exception;
    boolean delete(int uid) throws Exception;
}

package com.example.login.main.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.login.main.pojo.Product;

public interface ProductDao {
    Product find(String sid, String sname) throws Exception;
}

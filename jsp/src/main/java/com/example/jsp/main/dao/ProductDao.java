package com.example.jsp.main.dao;

import com.example.jsp.main.pojo.Product;

import java.util.List;

public interface ProductDao {
    List<Product> find(String class_id) throws Exception;
}

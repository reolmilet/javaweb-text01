package com.example.daoweb.main.dao;

import com.example.daoweb.main.pojo.Product;

public interface ProductDao {
    Product find(String sid, String sname) throws Exception;
}

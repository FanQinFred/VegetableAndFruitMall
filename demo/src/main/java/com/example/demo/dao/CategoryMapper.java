package com.example.demo.dao;

import com.example.demo.entity.Category;

public interface CategoryMapper {
    int insert(Category record);

    int insertSelective(Category record);
}
package com.example.demo.dao;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Byte categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Byte categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> all();
}
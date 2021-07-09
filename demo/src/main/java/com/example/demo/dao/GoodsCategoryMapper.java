package com.example.demo.dao;

import com.example.demo.entity.GoodsCategory;

public interface GoodsCategoryMapper {
    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);
}
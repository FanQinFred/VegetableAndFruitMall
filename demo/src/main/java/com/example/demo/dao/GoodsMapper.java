package com.example.demo.dao;

import com.example.demo.entity.Goods;

public interface GoodsMapper {
    int insert(Goods record);

    int insertSelective(Goods record);
}
package com.example.demo.dao;

import com.example.demo.entity.UserGoods;

public interface UserGoodsMapper {
    int insert(UserGoods record);

    int insertSelective(UserGoods record);
}
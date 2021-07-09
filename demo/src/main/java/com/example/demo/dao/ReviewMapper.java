package com.example.demo.dao;

import com.example.demo.entity.Review;

public interface ReviewMapper {
    int insert(Review record);

    int insertSelective(Review record);
}
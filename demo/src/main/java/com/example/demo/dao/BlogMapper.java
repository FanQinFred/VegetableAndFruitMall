package com.example.demo.dao;

import com.example.demo.entity.Blog;

public interface BlogMapper {
    int insert(Blog record);

    int insertSelective(Blog record);
}
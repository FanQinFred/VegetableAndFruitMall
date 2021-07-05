package com.example.demo.service;

import com.example.demo.dao.CategoryMapper;
import com.example.demo.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")
public class CategoryService {
    @Autowired

    CategoryMapper categoryMapper;
    public List<Category> all(){
        return categoryMapper.all();
    }
}

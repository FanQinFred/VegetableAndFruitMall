package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    @Qualifier("CategoryService")
    CategoryService categoryService;

    @RequestMapping("/all")
    @ResponseBody
    public String all(){
        StringBuilder sb = new StringBuilder("");
        for (Category category : categoryService.all()){
            sb.append(category.toString());
        }
        return sb.toString();
    }
}

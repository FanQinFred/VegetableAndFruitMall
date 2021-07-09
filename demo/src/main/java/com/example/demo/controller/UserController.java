package com.example.demo.controller;


import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@Param("email") String email, @Param("pwd") String pwd){
        try {
            User user=new User();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            user.setUserId(df.format(new Date()));
            user.setEmail(email);
            user.setPwd(pwd);
            user.setImgUrl("baidu.com");
            user.setToken("hesbja");
            user.setTokenValid((byte)1);
            user.setRole("1");
            userMapper.insert(user);
            return "'status':'200'";
        }catch(Exception e){
            e.printStackTrace();
            return "'status':'500'";
        }

    }
}

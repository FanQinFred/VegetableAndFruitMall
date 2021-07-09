package com.example.demo.controller;


import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
            if(userMapper.insert(user)>0){
                System.out.println("插入成功");
                return "'status':'200'";
            }
            return "'status':'500'";
        }catch(Exception e){
            e.printStackTrace();
            return "'status':'500'";
        }

    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@Param("email") String email, @Param("pwd") String pwd){
        try {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andEmailEqualTo(email);
            criteria.andEmailIsNull();
            example.setOrderByClause("email ASC");
            example.setDistinct(true);
            List<User> list = userMapper.selectByExample(example);
            if(list.isEmpty()){
                System.out.println("未查询到用户");
            }else
                System.out.println(list.get(0));
            return "'status':'200'";
        }catch(Exception e){
            e.printStackTrace();
            return "'status':'500'";
        }

    }
}

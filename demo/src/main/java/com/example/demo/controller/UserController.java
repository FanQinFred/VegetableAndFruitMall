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

import com.example.demo.utils.TokenUtils;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Param("email") String email, @Param("pwd") String pwd) {
        try {
            User user = new User();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            user.setUserId(df.format(new Date()));
            user.setEmail(email);
            user.setPwd(pwd);
            user.setImgUrl("baidu.com");
            user.setToken("hesbja");
            user.setTokenValid((byte) 1);
            user.setRole("1");
            if (userMapper.insert(user) > 0) {
                System.out.println("插入成功");
                return "'status':'200'";
            }
            return "'status':'500'";
        } catch (Exception e) {
            e.printStackTrace();
            return "'status':'500'";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Param("email") String email, @Param("pwd") String pwd) {
        try {
            System.out.println("email: " + email);
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andEmailEqualTo(email);
            example.setOrderByClause("email ASC");
            example.setDistinct(true);
            List<User> list = userMapper.selectByExample(example);
            if (list.isEmpty()) {
                System.out.println("未查询到用户");
            } else
                System.out.println(list.get(0).toString());
            User user = list.get(0);
            if (user.getEmail().equals(email) && user.getPwd().equals(pwd)) {
                //生成token
                //构建新用户update
                String token = TokenUtils.token(email, pwd);
                System.out.println(token);

                user.setTokenValid((byte) 1);
                user.setToken(token);

                UserExample example2 = new UserExample();
                UserExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andEmailEqualTo(email);
                criteria2.andTokenEqualTo(token);
                criteria2.andPwdEqualTo(pwd);
                userMapper.updateByExampleSelective(user, example2);
                return "{'status':'200','token':" + token + "'}";

//                    boolean b = TokenUtils.verify(token);
//                    System.out.println(b);
            }
            return "'status':'200'";
        } catch (Exception e) {
            e.printStackTrace();
            return "'status':'500'";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(@Param("email") String email, @Param("pwd") String pwd) {
        try {
            System.out.println("email: " + email);
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andEmailEqualTo(email);
            example.setOrderByClause("email ASC");
            example.setDistinct(true);
            List<User> list = userMapper.selectByExample(example);
            if (list.isEmpty()) {
                System.out.println("未查询到用户");
            } else
                System.out.println(list.get(0).toString());
            User user = list.get(0);
            if (user.getEmail().equals(email) && user.getPwd().equals(pwd)) {
                user.setTokenValid((byte) 0);
                UserExample example2 = new UserExample();
                UserExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andEmailEqualTo(email);
                criteria2.andPwdEqualTo(pwd);
                userMapper.updateByExampleSelective(user, example2);
                return "{'status':'200','token':" + null + "'}";

            }
            return "'status':'200'";
        } catch (Exception e) {
            e.printStackTrace();
            return "'status':'500'";
        }
    }
}

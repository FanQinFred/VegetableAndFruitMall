package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.UserMapper;
import cn.cqu.vspace.pojo.User;
import cn.cqu.vspace.pojo.UserExample;
import cn.cqu.vspace.service.UserSerivce;
import cn.cqu.vspace.utils.TokenUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImp implements UserSerivce {
    @Autowired
    UserMapper userMapper;

    @Override
    public String login(String email, String pwd) {
        try {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andEmailEqualTo(email);
            example.setOrderByClause("email ASC");
            example.setDistinct(true);
            List<User> list = userMapper.selectByExample(example);

            if (list.isEmpty()) {
                System.out.println("未查询到用户");
                return "{status:'500',code:'200',token:'" + null + "'}";
            } else {
                System.out.println("查询到用户");
                System.out.println(list.get(0).toString());
            }

            User user = list.get(0);
            if (user.getEmail().equals(email) && user.getPwd().equals(pwd)) {
                //生成token
                //构建新用户update
                String token = TokenUtils.token(email, pwd);

                user.setTokenValid((byte) 1);
                user.setToken(token);

                UserExample example2 = new UserExample();
                UserExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andEmailEqualTo(email);
                criteria2.andPwdEqualTo(pwd);
                userMapper.updateByExampleSelective(user, example2);
                Integer userid=user.getUserId();
                return "{status:'200',code:'100',token:'" + token + "',userid:'"+ userid +"'}";
            }
            return "{status:'200',code:'200',token:'" + null + "'}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{status:'500',code:'200',token:'" + null + "'}";
        }
    }

    @Override
    public String logout(String token) {
        try {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andTokenEqualTo(token);
            example.setOrderByClause("email ASC");
            example.setDistinct(true);
            List<User> list = userMapper.selectByExample(example);
            if (list.isEmpty()) {
                System.out.println("未查询到用户");
            } else
                System.out.println(list.get(0).toString());
            User user = list.get(0);
            if (user.getToken().equals(token)) {
                user.setTokenValid((byte) 0);
                UserExample example2 = new UserExample();
                UserExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andTokenEqualTo(token);
                userMapper.updateByExampleSelective(user, example2);
                return "{status:'200',code:'100'}";

            }
            return "status:'200',code:'200'";
        } catch (Exception e) {
            e.printStackTrace();
            return "status:'500',code:'200'";
        }
    }

    @Override
    public String register(String email, String pwd,String ImgUrl) {
        try {
            User user = new User();

            user.setEmail(email);
            user.setPwd(pwd);
            user.setImgUrl(ImgUrl);
            user.setToken("");
            user.setTokenValid((byte) 0);
            user.setRole("0");
//            System.out.println(userMapper.insert(user)==null);
            if (userMapper.insert(user) > 0) {
                return "{status:'200',code:'100'}";
            }
            return "{status:'500',code:'200'}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{status:'500',code:'200'}";
        }
    }
}


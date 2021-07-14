package cn.cqu.vspace.service.impl;


import cn.cqu.vspace.mapper.GoodsMapper;
import cn.cqu.vspace.mapper.ReviewMapper;
import cn.cqu.vspace.mapper.UserMapper;
import cn.cqu.vspace.pojo.*;

import cn.cqu.vspace.service.DetailService;
import org.apache.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class DetailServiceImp implements DetailService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public String comment(String goodsid, String blogid, String yourName, String yourEmail, String yourView, String rating, String token) {
        try {

//            UserExample example = new UserExample();
//            UserExample.Criteria criteria = example.createCriteria();
//            criteria.andTokenEqualTo(token);
//            example.setDistinct(true);
            List<User> list;
            list = userMapper.selectByToken(token);

            System.out.println("if");
            if (!list.isEmpty()) {
                System.out.println("查询到用户");
                User user = list.get(0);
                Integer userid = user.getUserId();

                Review review = new Review();

                review.setBlogId(Integer.parseInt(blogid));
                review.setGoodsId(Integer.parseInt(goodsid));
                review.setUserId(userid);

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                review.setReviewDate(df.format(new Date()));

                long randomNum = System.currentTimeMillis();
                review.setReviewHot(String.valueOf(randomNum % (10 - 1) + 1));
                review.setReviewRate(rating);
                if (reviewMapper.insert(review) > 0) {
                    return "{'status':'200','code':'100'}";
                } else {
                    return "{'status':'500','code':'200'}";
                }
            }

            return "{'status':'500','code':'200'}";

        } catch (Exception e) {
            e.printStackTrace();
            return "{'status':'500','code':'200'}";
        }
    }

    @Override
    public List<Goods> productDetail() {

        List<Review> reviews = reviewMapper.selectAll();
        ArrayList<Goods> goods = new ArrayList<Goods>();
        ArrayList<Goods> lists = new ArrayList<Goods>();
        for (Review review : reviews) {
            Integer goodsId1 = review.getGoodsId();
//            List<Goods> selectByExample(GoodsExample example);
            GoodsExample example = new GoodsExample();
            GoodsExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsIdEqualTo(goodsId1);
//            example.setOrderByClause("email ASC");
            example.setDistinct(true);
            List<Goods> list = goodsMapper.selectByExample(example);
            lists.addAll(list);
        }
        return lists;
    }
}

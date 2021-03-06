package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.*;
import cn.cqu.vspace.pojo.*;
import cn.cqu.vspace.service.IndexService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class IndexServiceImp implements IndexService {

    @Autowired
    BlogMapper blogMapper;
    
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public JSONObject bestSellers() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Goods> list = goodsMapper.selectTopFour();
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(list);
            jsonObject.put("list",jsonArray);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

    @Override
    public JSONObject ourProducts() {
        JSONObject jsonObject = new JSONObject();
        JSONObject ourProductList = new JSONObject();
        JSONArray Mango = new JSONArray();
        JSONArray Vegetables = new JSONArray();
        JSONArray Fruits = new JSONArray();
        JSONArray Juice = new JSONArray();
        JSONArray Meats = new JSONArray();
        try {
            List<Integer> MangoIds = goodsCategoryMapper.selectByCategory(1);
            List<Integer> VegetableIds = goodsCategoryMapper.selectByCategory(2);
            List<Integer> FruitIds = goodsCategoryMapper.selectByCategory(3);
            List<Integer> JuiceIds = goodsCategoryMapper.selectByCategory(4);
            List<Integer> MeatsIds = goodsCategoryMapper.selectByCategory(5);


            for (Integer id : MangoIds){
                Mango.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            for (Integer id : VegetableIds){
                Vegetables.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            for (Integer id : FruitIds){
                Fruits.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            for (Integer id : JuiceIds){
                Juice.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            for (Integer id : MeatsIds){
                Meats.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            ourProductList.put("Mango",Mango);
            ourProductList.put("Vegetables",Vegetables);
            ourProductList.put("Fruits",Fruits);
            ourProductList.put("Juice",Juice);
            ourProductList.put("Meats",Meats);
            jsonObject.put("ourProductList",ourProductList);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

    @Override
    public JSONObject newArrival() {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(goodsMapper.selectNewest());
            jsonObject.put("list",jsonArray);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

    @Override
    public JSONArray season(String season) {
        JSONArray jsonArray = new JSONArray();
        try {
            GoodsExample goodsExample = new GoodsExample();
            GoodsExample.Criteria criteria = goodsExample.createCriteria();
            criteria.andGoodsSeasonEqualTo(season);
            criteria.andGoodsRateBetween("6","9");
            jsonArray.addAll(goodsMapper.selectByExample(goodsExample).subList(0,9));

        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }

    @Override
    public JSONObject blog() {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            List<Blog> blogs = blogMapper.selectTopSix();
            jsonArray.addAll(blogs);
            for (Blog blog : blogs){
                jsonArray1.addAll(userMapper.getByUserId(blog.getUserId()));
            }
            jsonObject.put("userList",jsonArray1);
            jsonObject.put("list",jsonArray);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

    @Override
    public JSONObject popularCategories() {
        JSONObject jsonObject = new JSONObject();

        JSONArray Vegetables = new JSONArray();
        JSONArray Fruits = new JSONArray();
        JSONArray Juice = new JSONArray();
        JSONArray Meats = new JSONArray();
        try {

            List<Integer> VegetableIds = goodsCategoryMapper.selectByCategory(1);
            List<Integer> FruitIds = goodsCategoryMapper.selectByCategory(2);
            List<Integer> JuiceIds = goodsCategoryMapper.selectByCategory(3);
            List<Integer> MeatsIds = goodsCategoryMapper.selectByCategory(4);

            for (Integer id : VegetableIds){
                Vegetables.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            for (Integer id : FruitIds){
                Fruits.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            for (Integer id : JuiceIds){
                Juice.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            for (Integer id : MeatsIds){
                Meats.addAll(goodsMapper.selectByPrimaryKey(id));
            }

            jsonObject.put("status","200");
            jsonObject.put("vegetable",Vegetables);
            jsonObject.put("fruit",Fruits);
            jsonObject.put("juice",Juice);
            jsonObject.put("meat",Meats);

        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }

        return jsonObject;
    }

    @Override
    public JSONObject topRated() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Goods> list = goodsMapper.selectTopThree();
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(list);
            jsonObject.put("list",jsonArray);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }




    @Override
    public JSONObject whatPeopleSay() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Review> list = reviewMapper.selectTopThree();
            List<User> userList = new ArrayList<>();
            for (Review review : list){
                Integer id = review.getUserId();
                UserExample userExample = new UserExample();
                UserExample.Criteria criteria = userExample.createCriteria();
                criteria.andUserIdEqualTo(id);
                userList.addAll(userMapper.selectByExample(userExample));
            }
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(list);
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.addAll(userList);
            jsonObject.put("list",jsonArray);
            jsonObject.put("userList",jsonArray1);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }




    @Override
    public JSONObject sale() {
        JSONObject jsonObject = new JSONObject();

        List<Goods> list = goodsMapper.selectCheapest();
        Goods goods = list.get(0);

        jsonObject.put("img-url",goods.getGoodsImgUrl());
        jsonObject.put("status","200");
        int before = (int)Double.parseDouble(goods.getGoodsOriginalPrice());
        int after = (int)Double.parseDouble(goods.getGoodsCurrentPrice());
        double sale = Math.abs(before-after) * 1.0 / before;
        List<Integer> categoryIds = goodsCategoryMapper.selectByGoods(goods.getGoodsId());
        Integer categoryId = categoryIds.get(0);
        List<Category> categories = categoryMapper.selectByPrimaryKey(categoryId);
        String kind = categories.get(0).getCategoryName();
        jsonObject.put("sale",sale);
        jsonObject.put("kind",kind);

        return jsonObject;
    }

    @Override
    public JSONObject getBlogById(Integer id) {

        JSONObject jsonObject = new JSONObject();
        try {
            BlogExample blogExample = new BlogExample();
            BlogExample.Criteria criteria = blogExample.createCriteria();
            criteria.andBlogIdEqualTo(id);

            List<Blog> blogs = blogMapper.selectByExample(blogExample);
            Integer userId = blogs.get(0).getUserId();
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria1 = userExample.createCriteria();
            criteria1.andUserIdEqualTo(userId);
            jsonObject.put("blog",blogs.get(0));
            jsonObject.put("user",userMapper.selectByExample(userExample).get(0));
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }

        return jsonObject;
    }

    @Override
    public JSONObject getReviewByBlogId(Integer blogId) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray1 = new JSONArray();
        try {
            ReviewExample reviewExample = new ReviewExample();
            ReviewExample.Criteria criteria = reviewExample.createCriteria();
            criteria.andBlogIdEqualTo(blogId);
            List<Review> reviews = reviewMapper.selectByExample(reviewExample);
            jsonArray.addAll(reviews);

            for (Review review : reviews){
                jsonArray1.addAll(userMapper.getByUserId(review.getUserId()));
            }
            jsonObject.put("list",jsonArray);
            jsonObject.put("userList",jsonArray1);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

    @Override
    public JSONObject getReviewByGoodsId(Integer goodsId) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray1 = new JSONArray();
        try {
            ReviewExample reviewExample = new ReviewExample();
            ReviewExample.Criteria criteria = reviewExample.createCriteria();
            criteria.andGoodsIdEqualTo(goodsId);
            List<Review> reviews = reviewMapper.selectByExample(reviewExample);
            jsonArray.addAll(reviews);

            for (Review review : reviews){
                jsonArray1.addAll(userMapper.getByUserId(review.getUserId()));
            }
            jsonObject.put("list",jsonArray);
            jsonObject.put("userList",jsonArray1);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

    @Override
    public JSONObject comment(String content, String token, Integer blogId) {
        JSONObject jsonObject = new JSONObject();
        try {
            Review review = new Review();
            User user = userMapper.getUserByToken(token).get(0);
            review.setBlogId(blogId);
            review.setGoodsId(null);
            review.setUserId(user.getUserId());
            review.setReviewRate(null);
            review.setReviewHot(content);
            review.setReviewDate(null);
            reviewMapper.insert(review);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }

        return jsonObject;
    }
}

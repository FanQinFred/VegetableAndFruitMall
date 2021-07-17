package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.*;
import cn.cqu.vspace.pojo.*;
import cn.cqu.vspace.service.ShopService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    UserGoodsMapper userGoodsMapper;
    @Override
    public JSONObject GoodsIdByCategoryId(String token, int category_Id) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            List<Integer>goodsIdList = categoryMapper.findGoodsIdsByCategory(category_Id);
            JSONObject result = new JSONObject();
            JSONArray array = new JSONArray();
            array.addAll(goodsIdList);
            result.put("list", array);
            result.put("status", "200");
            return result;
        }
        JSONObject error = new JSONObject();
        error.put("status","500");
        return error;
    }

    @Override
    public JSONObject GoodsInfoById(String token, int goodsId) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            GoodsExample example = new GoodsExample();
            GoodsExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsIdEqualTo(goodsId);
            List<Goods>goodsList = goodsMapper.selectByExample(example);
            if (goodsList.isEmpty()){
                JSONObject error = new JSONObject();
                error.put("status","500");
                return error;
            }
            JSONObject goodJson = new JSONObject();
            Goods good = goodsList.get(0);
            goodJson.put("id",good.getGoodsId());
            goodJson.put("currentPrice",good.getGoodsCurrentPrice());
            goodJson.put("imgUrl",good.getGoodsImgUrl());
            goodJson.put("amount",good.getGoodsAmount());
            goodJson.put("name",good.getGoodsName());
            goodJson.put("originalPrice",good.getGoodsOriginalPrice());
            goodJson.put("description",good.getGoodsDescription());
            goodJson.put("rate",good.getGoodsRate());
            goodJson.put("season",good.getGoodsSeason());
            goodJson.put("status", "200");
            return goodJson;
        }
        JSONObject error = new JSONObject();
        error.put("status","500");
        return error;
    }

    @Override
    public JSONObject addCompareList(String token, List<Integer> goodsIdList) {
        return null;
    }

    @Override
    public JSONObject AddWish(String token, List<Integer> goodsId) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            int userId = list.get(0).getUserId();
            for(int gId : goodsId){
                UserGoodsExample userGoodsExample = new UserGoodsExample();
                UserGoodsExample.Criteria criteria = userGoodsExample.createCriteria();
                criteria.andUserIdEqualTo(userId);
                criteria.andGoodsIdEqualTo(gId);
                List<UserGoods> userGoodsList = userGoodsMapper.selectByExample(userGoodsExample);
                if(userGoodsList.isEmpty()){
                    UserGoods userGoods = new UserGoods();
                    userGoods.setGoodsId(gId);
                    userGoods.setUserId(userId);
                    userGoodsMapper.insert(userGoods);
                }
            }
            JSONObject result = new JSONObject();
            result.put("status", "200");
            return result;
        }
        JSONObject error = new JSONObject();
        error.put("status","500");
        return error;
    }

    @Override
    public JSONObject AllCategories() {
        System.out.println("123123123123123123123llllllllllllllllll");
        CategoryExample example = new CategoryExample();
        JSONObject result = new JSONObject();
        List<Category> categoryList = categoryMapper.selectByExample(example);
        if(categoryList.isEmpty()){
            System.out.println("empty-------------------------");
        }else{
            JSONArray array = new JSONArray();
            System.out.println("empty-------------------------");
            for (Category c : categoryList){
                JSONObject item = new JSONObject();
                item.put("name",c.getCategoryName());
                item.put("id", c.getCategoryId());
                array.add(item);
            }
            System.out.println("empty-------------------------");
            result.put("list", array);
        }
        result.put("status","200");
        System.out.println("empty-------------------------");
        return result;
    }

    @Override
    public JSONObject GetWishList(String token) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            int userId = list.get(0).getUserId();
            JSONObject result = new JSONObject();
            UserGoodsExample userGoodsExample = new UserGoodsExample();
            UserGoodsExample.Criteria criteria = userGoodsExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<UserGoods> userGoodsList = userGoodsMapper.selectByExample(userGoodsExample);
            JSONArray array = new JSONArray();
            for(UserGoods userGoods : userGoodsList){
                JSONObject item = new JSONObject();
                item.put("goodId", userGoods.getGoodsId());
                item.put("userId", userGoods.getUserId());
                array.add(item);
            }
            result.put("list", array);
            result.put("status", "200");
            return result;
        }
        JSONObject error = new JSONObject();
        error.put("status","500");
        return error;
    }
}

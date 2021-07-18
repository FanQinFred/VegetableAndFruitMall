package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.GoodsMapper;
import cn.cqu.vspace.mapper.UserGoodsMapper;
import cn.cqu.vspace.mapper.UserMapper;
import cn.cqu.vspace.pojo.*;
import cn.cqu.vspace.service.CartService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserGoodsMapper userGoodsMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public JSONObject updateCart(String token, List<Integer> goodsId) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            User user = list.get(0);
            Integer userid = user.getUserId();
            for (int id : goodsId){
                UserGoodsExample userGoodsExample = new UserGoodsExample();
                UserGoodsExample.Criteria criteria = userGoodsExample.createCriteria();
                criteria.andGoodsIdEqualTo(id);
                criteria.andUserIdEqualTo(userid);
                criteria.andCartorwishlistNotEqualTo(1);
                List<UserGoods> userGoodsList = userGoodsMapper.selectByExample(userGoodsExample);
                if(userGoodsList.isEmpty()){
                    UserGoods userGoods = new UserGoods();
                    userGoods.setUserId(userid);
                    userGoods.setGoodsId(id);
                    userGoodsMapper.insert(userGoods.getGoodsId(), userGoods.getUserId());
                }else{
                    for(UserGoods userGoods : userGoodsList){
                        userGoodsMapper.updateAmount(userGoods.getGoodsId(), userid, userGoods.getAmount()+1);
                    }
                }
            }
            JSONObject correctInfo = new JSONObject();
            correctInfo.put("status", 200);
            return correctInfo;
        }
        JSONObject errorInfo = new JSONObject();
        errorInfo.put("status", 500);
        return errorInfo;
    }

    @Override
    public JSONObject getCart(String token) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            User user = list.get(0);
            Integer userid = user.getUserId();
            UserGoodsExample userGoodsExample = new UserGoodsExample();
            UserGoodsExample.Criteria criteria = userGoodsExample.createCriteria();
            criteria.andUserIdEqualTo(userid);
            List<UserGoods> userGoodsList = userGoodsMapper.selectByExample(userGoodsExample);
            JSONArray result = new JSONArray();
            for(UserGoods userGoods:userGoodsList){
                GoodsExample goodsExample = new GoodsExample();
                GoodsExample.Criteria criteria1 = goodsExample.createCriteria();
                criteria1.andGoodsIdEqualTo(userGoods.getGoodsId());
                criteria.andCartorwishlistNotEqualTo(1);
                List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
                for(Goods good : goodsList){
                    JSONObject goodJson = new JSONObject();
                    goodJson.put("id",good.getGoodsId());
                    goodJson.put("currentPrice",good.getGoodsCurrentPrice());
                    goodJson.put("imgUrl",good.getGoodsImgUrl());
                    goodJson.put("amount",good.getGoodsAmount());
                    goodJson.put("name",good.getGoodsName());
                    goodJson.put("originalPrice",good.getGoodsOriginalPrice());
                    goodJson.put("description",good.getGoodsDescription());
                    goodJson.put("rate",good.getGoodsRate());
                    goodJson.put("season",good.getGoodsSeason());
                    result.add(goodJson);
                }
            }
            JSONObject returnObject = new JSONObject();
            returnObject.put("status", "200");
            returnObject.put("list", result);
            return returnObject;
        }
        JSONObject errorInfo = new JSONObject();
        errorInfo.put("status", 500);
        return errorInfo;
    }


}

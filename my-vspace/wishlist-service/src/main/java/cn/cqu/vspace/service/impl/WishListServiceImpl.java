package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.UserGoodsMapper;
import cn.cqu.vspace.mapper.UserMapper;
import cn.cqu.vspace.pojo.User;
import cn.cqu.vspace.pojo.UserGoods;
import cn.cqu.vspace.pojo.UserGoodsExample;
import cn.cqu.vspace.service.WishListService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserGoodsMapper userGoodsMapper;

    @Override
    public JSONObject deleteGoodsInWishList(String token, List<Integer> goodsIdList) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            int userId = list.get(0).getUserId();
            for(int gid : goodsIdList){
                UserGoodsExample userGoodsExample = new UserGoodsExample();
                UserGoodsExample.Criteria criteria = userGoodsExample.createCriteria();
                criteria.andUserIdEqualTo(userId);
                criteria.andGoodsIdEqualTo(gid);
                List<UserGoods> userGoodsList = userGoodsMapper.selectByExample(userGoodsExample);
                for(UserGoods goods : userGoodsList){
                    if(goods.getCartorwishlist()==1){
                        userGoodsMapper.delete(gid, userId, 1);
                    }else{
                        userGoodsMapper.updateToCart(gid, userId, 2, 0);
                    }
                }

            }
            JSONObject result = new JSONObject();
            result.put("status", 200);
            return result;
        }
        JSONObject errorInfo = new JSONObject();
        errorInfo.put("status", 500);
        return errorInfo;
    }

    @Override
    public JSONObject getAllWishList(String token) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            int userId = list.get(0).getUserId();
            JSONObject result = new JSONObject();
            UserGoodsExample userGoodsExample = new UserGoodsExample();
            UserGoodsExample.Criteria criteria = userGoodsExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            criteria.andCartorwishlistNotEqualTo(0);
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
        JSONObject errorInfo = new JSONObject();
        errorInfo.put("status", 500);
        return errorInfo;
    }
}

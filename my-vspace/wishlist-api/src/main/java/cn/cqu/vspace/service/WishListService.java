package cn.cqu.vspace.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface WishListService {
    JSONObject deleteGoodsInWishList(String token, List<Integer> goodsIdList);
    JSONObject getAllWishList(String token);
}

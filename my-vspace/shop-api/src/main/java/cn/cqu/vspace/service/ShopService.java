package cn.cqu.vspace.service;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ShopService {
    JSONObject GoodsIdByCategoryId (String token, int category_Id);
    JSONObject GoodsInfoById (String token, int goodsId);
    JSONObject addCompareList (String token, List<Integer> goodsIdList);
    JSONObject AddWish (String token, List<Integer> goodsId);
    JSONObject AllCategories ();
    JSONObject GetWishList (String token);
}

package cn.cqu.vspace.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface CartService {
    JSONObject updateCart(String token, List<Integer> goodsId);
    JSONObject getCart(String token);
}

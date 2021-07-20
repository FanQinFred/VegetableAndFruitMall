package cn.cqu.vspace.service;

import com.alibaba.fastjson.JSONObject;

public interface OrderService {
    JSONObject addOrder(String token, String orderId, String goodsId, String status, String total);
    JSONObject deleteOrder(String token, String orderId);
    JSONObject showOrders(String token);
    JSONObject updateOrder(String token, String orderId, String goodsId, String status, String total);
}

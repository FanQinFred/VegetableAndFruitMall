package cn.cqu.vspace.service;

import cn.cqu.vspace.pojo.Goods;

import java.util.List;

public interface DetailService {
    String comment(String goodsid,String blogid,String yourName, String yourEmail, String yourView, String rating, String token);
    List<Goods> productDetail();
}

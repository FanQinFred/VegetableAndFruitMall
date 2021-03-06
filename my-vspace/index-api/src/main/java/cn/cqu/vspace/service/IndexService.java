package cn.cqu.vspace.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface IndexService {
    JSONObject bestSellers();
    JSONObject ourProducts();
    JSONObject newArrival();
    JSONArray season(String season);
    JSONObject blog();
    JSONObject popularCategories();
    JSONObject topRated();
    JSONObject whatPeopleSay();
    JSONObject sale();
    JSONObject getBlogById(Integer id);
    JSONObject getReviewByBlogId(Integer blogId);
    JSONObject getReviewByGoodsId(Integer goodsId);
    JSONObject comment(String content, String token, Integer blogId);
}

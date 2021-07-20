package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.*;
import cn.cqu.vspace.pojo.*;
import cn.cqu.vspace.service.IndexService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
            List<Integer> MangoIds = goodsCategoryMapper.selectByCategory(0);
            List<Integer> VegetableIds = goodsCategoryMapper.selectByCategory(1);
            List<Integer> FruitIds = goodsCategoryMapper.selectByCategory(2);
            List<Integer> JuiceIds = goodsCategoryMapper.selectByCategory(3);
            List<Integer> MeatsIds = goodsCategoryMapper.selectByCategory(4);


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
            jsonArray.addAll(blogMapper.selectTopSix());
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
            jsonObject.put("blog",blogs.get(0));
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }

        return jsonObject;
    }
}

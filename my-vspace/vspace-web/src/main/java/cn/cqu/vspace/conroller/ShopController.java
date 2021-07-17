package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.ShopService;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Reference
    ShopService shopService;

    @RequestMapping(value = "/getIdByCategoryId", method = RequestMethod.POST)
    public JSONObject GoodsIdByCategoryId (@Param("token") String token, @Param("categoryId") int category_Id){
        return shopService.GoodsIdByCategoryId(token, category_Id);
    }
    @RequestMapping(value = "/getInfoById", method = RequestMethod.POST)
    public JSONObject GoodsInfoById (@Param("token") String token, @Param("goodsId")int goodsId){
        return shopService.GoodsInfoById(token, goodsId);
    }
    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    public JSONObject addCompareList (@Param("token") String token, @Param("goodsIdList") String goodsStr){
        String[] goods = goodsStr.split("-");
        List<Integer> goodsIdList = new ArrayList<>();
        for (String good : goods) {
            goodsIdList.add(Integer.parseInt(good));
        }
        return shopService.addCompareList(token, goodsIdList);
    }
    @RequestMapping(value = "/wish", method = RequestMethod.POST)
    public JSONObject AddWish (@Param("token") String token, @Param("goodsIdList") String goodsStr){
        String[] goods = goodsStr.split("-");
        List<Integer> goodsIdList = new ArrayList<>();
        for (String good : goods) {
            goodsIdList.add(Integer.parseInt(good));
        }
        return shopService.AddWish(token, goodsIdList);
    }
    @RequestMapping(value = "/allCategories", method = RequestMethod.GET)
    public JSONObject AllCategories (){
        return shopService.AllCategories();
    }
    @RequestMapping(value = "/wishlist", method = RequestMethod.POST)
    JSONObject GetWishList (@Param("token") String token){
        return shopService.GetWishList(token);
    }
}

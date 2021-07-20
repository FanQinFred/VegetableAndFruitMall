package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.ShopService;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public JSONObject GoodsIdByCategoryId (@RequestHeader("token") String token, @Param("category_Id") int category_Id){
        return shopService.GoodsIdByCategoryId(token, category_Id);
    }
    @RequestMapping(value = "/getInfoById", method = RequestMethod.POST)
    public JSONObject GoodsInfoById (@RequestHeader("token") String token, @Param("goodsId")int goodsId){
        return shopService.GoodsInfoById(token, goodsId);
    }
    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    public JSONObject addCompareList (@RequestHeader("token") String token, @Param("id") String id){
        System.out.println(id+"   "+token);
        String[] goods = id.split("-");
        List<Integer> goodsIdList = new ArrayList<>();
        for (String good : goods) {
            goodsIdList.add(Integer.parseInt(good));
        }
        return shopService.addCompareList(token, goodsIdList);
    }
    @RequestMapping(value = "/wish", method = RequestMethod.POST)//wait
    public JSONObject AddWish (@RequestHeader("token") String token, @Param("id") String id){
        System.out.println("124124");
        System.out.println(token);
        System.out.println(id);
        String[] goods = id.split("-");
        List<Integer> goodsIdList = new ArrayList<>();
        for (String good : goods) {
            goodsIdList.add(Integer.parseInt(good));
        }
        return shopService.AddWish(token, goodsIdList);
    }
    @RequestMapping(value = "/allCategories", method = RequestMethod.GET)
    public JSONObject AllCategories (){
        return shopService.AllCategories();
//        return new JSONObject();
    }
    @RequestMapping(value = "/wishlist", method = RequestMethod.POST)  //wait
    JSONObject GetWishList (@RequestHeader("token") String token){
        return shopService.GetWishList(token);
    }
}

package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.CacheService;
import cn.cqu.vspace.service.ShopService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    @Reference
    ShopService shopService;

    @Reference
    CacheService cacheService;

    @RequestMapping(value = "/getIdByCategoryId", method = RequestMethod.POST)
    public JSONObject GoodsIdByCategoryId (@RequestHeader("token") String token, @Param("category_Id") Integer category_Id){
        return shopService.GoodsIdByCategoryId(token, category_Id);
    }
    @RequestMapping(value = "/getInfoById", method = RequestMethod.POST)
    public JSONObject GoodsInfoById (@RequestHeader("token") String token, @Param("goodsId")String goodsId){
        String[] list = goodsId.split("-");
        List<Integer> goodsList = new ArrayList<>(list.length);
        for(String item : list){
            goodsList.add(Integer.parseInt(item));
        }
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        for(int num : goodsList){
            String data = cacheService.getDataByKey(String.valueOf(num));
            if(data == null){
                JSONObject info = shopService.GoodsInfoById(token, num);
                array.add(info);
                cacheService.insertCache(String.valueOf(num), info.toJSONString());
            }else{
                JSONObject info = JSONObject.parseObject(data);
                array.add(info);
            }
        }
        result.put("list", array);
        result.put("status", "200");
        return result;
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

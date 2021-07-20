package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.CacheService;
import cn.cqu.vspace.service.ShopService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Reference
    CacheService cacheService;

    @Reference
    ShopService shopService;

    @RequestMapping(value = "/goodsById", method = RequestMethod.POST)
    public JSONObject findGoodsById(@RequestHeader("token") String token, @Param("goodsId") String goodsId){
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
}

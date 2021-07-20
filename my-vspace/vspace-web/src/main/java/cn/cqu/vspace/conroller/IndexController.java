package cn.cqu.vspace.conroller;


import cn.cqu.vspace.pojo.Goods;
import cn.cqu.vspace.service.IndexService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Random;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/index")
@CrossOrigin
public class IndexController {
    @Reference
    IndexService indexService;

    @RequestMapping(value = "/getBlogById",method = RequestMethod.POST)
    JSONObject getBlogById(@Param("id") Integer blogId){
        return indexService.getBlogById(blogId);
    }

    @RequestMapping(value = "/getReviewByBlogId", method = RequestMethod.POST)
    JSONObject getReviewByBlogId(@Param("blogId") Integer blogId){
        return indexService.getBlogById(blogId);
    }

    @RequestMapping(value = "/getReviewByGoodsId", method = RequestMethod.POST)
    JSONObject getReviewByGoodsId(@Param("goodsId") Integer goodsId){
        return indexService.getBlogById(goodsId);
    }

    @RequestMapping(value = "/bestSellers",method = RequestMethod.GET)
    JSONObject bestSellers(){
        return indexService.bestSellers();
    }

    @RequestMapping(value = "/ourProducts",method = RequestMethod.GET)
    JSONObject ourProducts(){
        return indexService.ourProducts();
    }

    @RequestMapping(value = "/season",method = RequestMethod.GET)
    JSONObject season(){
        JSONArray jsonArray = null;
        JSONObject jsonObject = new JSONObject();
        Random random  = new Random();
        String s = Calendar.getInstance().get(Calendar.MONTH)== Calendar.JANUARY ?"winter":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.FEBRUARY ?"spring":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.MARCH ?"spring":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.APRIL ?"spring":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.MAY ?"summer":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.JUNE ?"summer":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.JULY ?"summer":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.AUGUST ?"autumn":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.SEPTEMBER ?"autumn":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.OCTOBER ?"autumn":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.NOVEMBER ?"winter":
                   Calendar.getInstance().get(Calendar.MONTH)== Calendar.DECEMBER ?"winter":"";
        try {
            switch (s) {
                case "spring":
                    jsonArray = indexService.season("0");
                    break;
                case "summer":
                    jsonArray = indexService.season("1");
                    break;
                case "autumn":
                    jsonArray = indexService.season("2");
                    break;
                case "winter":
                    jsonArray = indexService.season("3");
                    break;
            }
            assert jsonArray != null;
            Goods goods = (Goods) jsonArray.get(random.nextInt(5));
            jsonObject.put("goods",goods);
            jsonObject.put("status","200");
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status","500");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/blog",method = RequestMethod.GET)
    JSONObject blog(){
        return indexService.blog();
    }

    @RequestMapping(value = "/newArrival",method = RequestMethod.GET)
    JSONObject newArrival(){
        return indexService.newArrival();
    }

    @RequestMapping(value = "/popularCategories",method = RequestMethod.GET)
    JSONObject popularCategories(){
        return indexService.popularCategories();
    }

    @RequestMapping(value = "/topRated",method = RequestMethod.GET)
    JSONObject topRated(){
        return indexService.topRated();
    }
    @RequestMapping(value = "/whatPeopleSay",method = RequestMethod.GET)
    JSONObject whatPeopleSay(){
        return indexService.whatPeopleSay();
    }

    @RequestMapping(value = "/sale",method = RequestMethod.GET)
    JSONObject sale(){
        return indexService.sale();
    }
}

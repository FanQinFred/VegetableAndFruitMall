package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.WishListService;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin
public class WishListController {

    @Reference
    WishListService wishListService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JSONObject deleteGoodsInWishList(@RequestHeader("token") String token, @Param("id") String id){
        String[] goods = id.split("-");
        List<Integer> goodsIdList = new ArrayList<>();

        for (String good : goods) {
            goodsIdList.add(Integer.parseInt(good));
        }
        return wishListService.deleteGoodsInWishList(token, goodsIdList);
    }
}

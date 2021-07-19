package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.CartService;
import com.alibaba.fastjson.JSONObject;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Reference
    CartService cartService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JSONObject updateCart(@Param("token") String token, @Param("goodsId") String goodsId){
        String[] list = goodsId.split("-");
        List<Integer> goodsList = new ArrayList<>(list.length);
        for(String item : list){
            goodsList.add(Integer.parseInt(item));
        }
        return cartService.updateCart(token, goodsList);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public JSONObject getCarList(@Param("token") String token){
        return cartService.getCart(token);
    }

}

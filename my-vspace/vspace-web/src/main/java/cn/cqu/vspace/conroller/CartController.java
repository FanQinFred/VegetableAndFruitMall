package cn.cqu.vspace.conroller;

import cn.cqu.vspace.service.CartService;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.ir.annotations.Reference;
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
    private CartService cartService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JSONObject updateCart(@Param("token") String token, @Param("goodsId") String goodsId){
        List<Integer> goodsList = null;
        return cartService.updateCart(token, goodsList);
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public JSONObject getCarList(@Param("token") String token){
        return cartService.getCart(token);
    }

}

package cn.cqu.vspace.conroller;


import cn.cqu.vspace.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Reference
    OrderService orderService;
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JSONObject addOrder(String token, String orderId, String goodsId, String status, String total){
        return orderService.addOrder(token, orderId, goodsId, status, total);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JSONObject deleteOrder(String token, String orderId){
        return orderService.deleteOrder(token, orderId);
    }
    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public JSONObject showOrders(String token){
        return orderService.showOrders(token);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JSONObject updateOrder(String token, String orderId, String goodsId, String status, String total){
        return orderService.updateOrder(token, orderId, goodsId, status, total);
    }
}

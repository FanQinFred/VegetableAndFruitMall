package cn.cqu.vspace.conroller;


import cn.cqu.vspace.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    //1
    @Reference
    OrderService orderService;
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JSONObject addOrder(@RequestHeader("token") String token, @Param("orderId") String orderId,
                               @Param("goodsId") String goodsId, @Param("status") String status, @Param("total") String total){
        return orderService.addOrder(token, orderId, goodsId, status, total);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JSONObject deleteOrder(@RequestHeader("token") String token, @Param("orderId") String orderId){
        return orderService.deleteOrder(token, orderId);
    }
    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public JSONObject showOrders(@RequestHeader("token") String token){
        return orderService.showOrders(token);
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JSONObject updateOrder(@RequestHeader("token") String token, @Param("orderId") String orderId,
                                  @Param("goodsId") String goodsId, @Param("status") String status, @Param("total") String total){
        return orderService.updateOrder(token, orderId, goodsId, status, total);
    }
}

package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.OrderMapper;
import cn.cqu.vspace.mapper.UserMapper;
import cn.cqu.vspace.pojo.Order;
import cn.cqu.vspace.pojo.OrderExample;
import cn.cqu.vspace.pojo.User;
import cn.cqu.vspace.service.OrderService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Override
    public JSONObject addOrder(String token, String orderId, String goodsId, String status, String total) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            OrderExample example = new OrderExample();
            OrderExample.Criteria criteria = example.createCriteria();
            criteria.andOrderIdEqualTo(Integer.parseInt(orderId));
            List<Order> orderList = orderMapper.selectByExample(example);
            if(orderList.isEmpty()){
                Order order = new Order();
                order.setOrderId(Integer.parseInt(orderId));
                order.setOrderStatus(status);
                order.setUserId(list.get(0).getUserId());
                order.setOrderTotal(Double.parseDouble(total));
                order.setGoodsId(Integer.parseInt(goodsId));
                orderMapper.insertSelective(order);
                JSONObject result = new JSONObject();
                result.put("status", "200");
                return result;
            }
        }
        JSONObject error = new JSONObject();
        error.put("status","500");
        return error;
    }

    @Override
    public JSONObject deleteOrder(String token, String orderId) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            OrderExample example = new OrderExample();
            OrderExample.Criteria criteria = example.createCriteria();
            criteria.andOrderIdEqualTo(Integer.parseInt(orderId));
            List<Order> orderList = orderMapper.selectByExample(example);
            if(!orderList.isEmpty()){
                orderMapper.deleteByExample(example);
                JSONObject result = new JSONObject();
                result.put("status", "200");
                return result;
            }
        }
        JSONObject error = new JSONObject();
        error.put("status","500");
        return error;
    }

    @Override
    public JSONObject showOrders(String token) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            OrderExample example = new OrderExample();
            OrderExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(list.get(0).getUserId());
            List<Order> orderList = orderMapper.selectByExample(example);
            if(!orderList.isEmpty()){
                JSONObject result = new JSONObject();
                JSONArray array = new JSONArray();
                for(Order order : orderList){
                    JSONObject item = new JSONObject();
                    item.put("id",order.getOrderId());
                    item.put("uid",order.getOrderId());
                    item.put("gid",order.getGoodsId());
                    item.put("date",order.getOrderDate());
                    item.put("total",order.getOrderTotal());
                    item.put("orderStatus",order.getOrderStatus());
                    array.add(item);
                }
                result.put("list", array);
                return result;
            }
        }
        JSONObject error = new JSONObject();
        error.put("status","500");
        return error;
    }

    @Override
    public JSONObject updateOrder(String token, String orderId, String goodsId, String status, String total) {
        List<User> list;
        list = userMapper.selectByToken(token);
        if(!list.isEmpty()){
            OrderExample example = new OrderExample();
            OrderExample.Criteria criteria = example.createCriteria();
            criteria.andOrderIdEqualTo(Integer.parseInt(orderId));
            List<Order> orderList = orderMapper.selectByExample(example);
            if(!orderList.isEmpty()){
                Order order = new Order();
                order.setOrderId(Integer.parseInt(orderId));
                order.setOrderStatus(status);
                order.setUserId(list.get(0).getUserId());
                order.setOrderTotal(Double.parseDouble(total));
                order.setGoodsId(Integer.parseInt(goodsId));
                orderMapper.updateByExampleSelective(order, example);
                JSONObject result = new JSONObject();
                result.put("status", "200");
                return result;
            }
        }
        JSONObject error = new JSONObject();
        error.put("status","500");
        return error;
    }
}

package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.service.CacheService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@Service
public class CacheServiceImpl implements CacheService {
    //自动装配一个redisTemplate模板对象
    @Autowired
    private RedisTemplate<String,String> template;
    @Override
    public void insertCache(String key, String value) {
        //将json对象存储到redis
        template.opsForValue().set(key,value);
    }
    @Override
    public String getDataByKey(String key) { //调用redis模型根据key获取对于的值
        String data = template.opsForValue().get(key);
        System.out.println(data);
        return data;
    }

}

package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.service.CacheService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class CacheServiceImpl implements CacheService {
    @Override
    public void insertCache(String key, String value) {
        
    }

    @Override
    public String getDataByKey(String key) {
        return null;
    }
}

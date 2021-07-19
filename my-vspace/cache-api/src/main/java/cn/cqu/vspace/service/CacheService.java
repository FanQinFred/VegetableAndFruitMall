package cn.cqu.vspace.service;

public interface CacheService {
    //向缓存中插入数据
    void insertCache(String key,String value);
    //从缓存中取出数据
    String getDataByKey(String key);
}
package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.pojo.Condition;
import cn.cqu.vspace.pojo.Goods;
import cn.cqu.vspace.service.SearchService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
* @Author: Stephen
* @Edition: V1.0
* @CreateDate: 2021/5/28 9:31
* @Description: 搜索服务实现类
*/
@Service
public class SearchServiceImp implements SearchService {
    //通过springIOC容器自动装配一个solrClient对象
    //集群环境下使用该对象
    // @Autowired
    // private CloudSolrClient cloudSolrClient;
    @Autowired
    private SolrClient solrClient;
    @Override
    public JSONObject searchPage(String keyWord, int pageNo, int pageSize) {
        SolrQuery query = new SolrQuery();
        query.set("q","goodsName:" + keyWord + "~");
        query.setFields("goodsName","goodsRate","goodsImgUrl",
        "goodsOriginalPrice","goodsCurrentPrice",
        "goodsSeason","goodsDescription",
        "goodsAmount");
        query.addSort("goods_price", SolrQuery.ORDER.asc);
        query.addSort("goods_id", SolrQuery.ORDER.asc);
        List<Goods> goodsList = null;
        long totalItems = 0;
        int pages = 0;
        try {
            QueryResponse queryResponse = solrClient.query(query);
            goodsList = queryResponse.getBeans(Goods.class);
            //获取数据总记录数
            SolrDocumentList results = queryResponse.getResults();
            totalItems = results.getNumFound();
        } catch (SolrServerException | IOException e) {
        e.printStackTrace();
        }
        if (totalItems % pageSize == 0) {
            pages = (int)(totalItems / pageSize);
        }else{
            pages = (int)(totalItems / pageSize) + 1;
        }
        JSONObject result = new JSONObject();
        result.put("pages", pages);
        result.put("totalItems", totalItems);
        JSONArray array = new JSONArray();
        assert goodsList != null;
        for(Goods goods : goodsList){
            JSONObject item = new JSONObject();
            item.put("id",goods.getGoodsId());
            item.put("currentPrice",goods.getGoodsCurrentPrice());
            item.put("imgUrl",goods.getGoodsImgUrl());
            item.put("amount",goods.getGoodsAmount());
            item.put("name",goods.getGoodsName());
            item.put("originalPrice",goods.getGoodsOriginalPrice());
            item.put("description",goods.getGoodsDescription());
            item.put("rate",goods.getGoodsRate());
            item.put("season",goods.getGoodsSeason());
            array.add(item);
        }
        result.put("list", array);
        return result;
    }
}
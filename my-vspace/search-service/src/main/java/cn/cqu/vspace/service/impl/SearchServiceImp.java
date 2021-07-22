package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.pojo.*;
import cn.cqu.vspace.service.SearchService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
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
        query.set("q","GOODS_NAME:" + keyWord);
        query.setFields("GOODS_NAME","GOODS_RATE","GOODS_IMG_URL",
        "GOODS_ORIGINAL_PRICE","GOODS_CURRENT_PRICE",
        "GOODS_SEASON","GOODS_DESCRIPTION",
        "GOODS_AMOUNT");
        List<Goods> goodsList = null;
        long totalItems = 0;
        int pages = 0;
        SolrDocumentList results = null;
        try {
            QueryResponse queryResponse = solrClient.query(query);
            //获取数据总记录数
            results = queryResponse.getResults();
            totalItems = results.getNumFound();
        } catch (SolrServerException | IOException e) {
        e.printStackTrace();
        }
        if (totalItems % pageSize == 0) {
            pages = (int)(totalItems / pageSize);
        }else{
            pages = (int)(totalItems / pageSize) + 1;
        }

        if(results==null ){
            JSONObject empty = new JSONObject();
            empty.put("result","empty");
            return empty;
        }
        JSONObject result = new JSONObject();
        result.put("pages", pages);
        result.put("totalItems", totalItems);
        JSONArray array = new JSONArray();
        for(SolrDocument document : results){
            Map<String, Object> map = document.getFieldValueMap();
            JSONObject item = new JSONObject();
            item.put("currentPrice",map.get("GOODS_CURRENT_PRICE"));
            item.put("imgUrl",map.get("GOODS_IMG_URL"));
            item.put("amount",map.get("GOODS_AMOUNT"));
            item.put("name",map.get("GOODS_NAME"));
            item.put("originalPrice",map.get("GOODS_ORIGINAL_PRICE"));
            item.put("description",map.get("GOODS_DESCRIPTION"));
            item.put("rate",map.get("GOODS_RATE"));
            item.put("season",map.get("GOODS_SEASON"));
            array.add(item);
        }

        result.put("list", array);
        return result;
    }
}

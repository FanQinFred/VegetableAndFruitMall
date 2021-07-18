package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.pojo.Condition;
import cn.cqu.vspace.pojo.Goods;
import cn.cqu.vspace.service.SearchService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.json.JSONObject;
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
    public JSONObject searchPage(Condition condition) {
        SolrQuery query = new SolrQuery();
        query.set("q","goodsName:" + condition.getSearchWord() + "~");
//        //添加商品价格过滤
//        query.addFilterQuery("goods_price:[" + condition.getMinPrice() + " TO " + condition.getMaxPrice() + "]");
//        //设置分页相关参数
//        //①: 设置偏移量
//        query.setStart((condition.getPageNo() - 1) * condition.getPageSize());
//        //②: 设置每页显示条数
//        query.setRows(condition.getPageSize());
        //设置回显的字段(也就是查询哪些字段进行前端展示)
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
            /*特别注意: 查询数据结果和高亮结果是分开的*/
            //判断如果查询关键字不是*号,则查询高亮显示
            if (!condition.getSearchWord().equals("*"))
            {
                //获取高亮结果(该结果为所有高亮信息的集合)
                Map<String, Map<String, List<String>>>
                highlighting = queryResponse.getHighlighting();
                if (highlighting != null) {
                    for (Goods goods :goodsList) {
                        Map<String, List<String>> highMap = highlighting.get(goods.getGoodsId() + "");
                        if (highMap != null) {
                            if (highMap.get("goods_title") != null) {
                                goods.setGoodsTitle(highMap.get("goods_title").get(0));
                            }
                            if (highMap.get("goods_description") != null) {
                                goods.setDescription(highMap.get("goods_description").get(0));
                            }
                        }
                    }
                }
            }
        } catch (SolrServerException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
        return null
    }
    @Override
    public void addSolrDoc(List list) {
        try {
            UpdateResponse updateResponse = solrClient.addBeans(list);
            //如果没有异常则提交事务
            solrClient.commit();
        } catch (SolrServerException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
    @Override
    public void deleteSolrDoc(Condition condition) {

    }
}
package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.service.SearchService;
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
    public PageResult searchPage(Condition condition) {
        SolrQuery query = new SolrQuery();
        query.set("q","goods_keywords:" + condition.getSearchString() + "");
        String categoryIdCondition = "(";
        for (Integer integer :
            condition.getCategoryIdList()) {
            categoryIdCondition += integer + " ";
        }
        categoryIdCondition = categoryIdCondition.substring(0,categoryIdCondition.length() - 1);
        categoryIdCondition += ")";
        //设置根据类型查询的查询条件
        query.setFilterQueries("goods_category_id:" + categoryIdCondition);

        //添加商品价格过滤
        query.addFilterQuery("goods_price:[" + condition.getMinPrice() + " TO " + condition.getMaxPrice() + "]");
        //设置分页相关参数
        //①: 设置偏移量
        query.setStart((condition.getPageNo() - 1) * condition.getPageSize());
        //②: 设置每页显示条数
        query.setRows(condition.getPageSize());
        //设置回显的字段(也就是查询哪些字段进行前端展示)
        query.setFields("goods_id","goods_title","goods_price","goods_discount",
        "goods_specification","goods_description",
        "goods_category_id","goods_ammount",
        "goods_image_url");
        query.addSort("goods_price", SolrQuery.ORDER.asc);
        query.addSort("goods_id", SolrQuery.ORDER.asc);
        //设置查询高亮结果显示//①: 打开高亮
        query.setHighlight(true);
        //②: 设置高亮显示的字段
        query.addHighlightField("goods_title");
        query.addHighlightField("goods_description");
        //③: 设置高亮前缀
        query.setHighlightSimplePre("<font color='red'>");
        //④: 设置高亮后缀
        query.setHighlightSimplePost("</font>");
        System.out.println("solr查询语句是: " +
        query.getQuery());
        System.out.println("solr过滤查询语句是: " + Arrays.toString(query.getFilterQueries()));
        //执行查询命令得到查询结果
        List<TbGoodsWithBLOBs> goodsList = null;
        long totalItems = 0;
        int pages = 0;
        try {
            QueryResponse queryResponse = solrClient.query(query);
            goodsList = queryResponse.getBeans(TbGoodsWithBLOBs.class);
            //获取数据总记录数
            SolrDocumentList results = queryResponse.getResults();
            totalItems = results.getNumFound();
            /*特别注意: 查询数据结果和高亮结果是分开的*/
            //判断如果查询关键字不是*号,则查询高亮显示
            if (!condition.getSearchString().equals("*"))
            {
                //获取高亮结果(该结果为所有高亮信息的集合)
                Map<String, Map<String, List<String>>>
                highlighting = queryResponse.getHighlighting();
                if (highlighting != null) {
                    for (TbGoodsWithBLOBs goods :goodsList) {
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
        //根据总记录数 和 每页显示记录数据计算总页数
        if (totalItems % condition.getPageSize() == 0) {
            pages = (int)(totalItems /
            condition.getPageSize());
        }else{
            pages = (int)(totalItems /
            condition.getPageSize()) + 1;
        }
        //创建一个PageResult对象返回给调用者
        PageResult pageResult = new PageResult();
        pageResult.setPages(pages);
        pageResult.setTotalItems(totalItems);
        pageResult.setDataList(goodsList);
        return pageResult;
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
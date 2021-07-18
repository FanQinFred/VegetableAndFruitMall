package cn.cqu.vspace.conroller;

import cn.cqu.vspace.pojo.Condition;
import cn.cqu.vspace.service.ShopService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    //使用dubbo远程调度商品类型服务
    @Reference
    private ShopService shopService; //远程调度商品服务
    @Reference
    private GoodsService goodsService; //远程调度搜索服务
    @Reference
    private SearchService searchService;
    //多条件分页查询 @RequestMapping("/findPageByCondition")
    public PageResult findPageByCondition(@RequestBody Condition condition){ //根据一级级类型编号,查询出所有的二级级类型编号
        if (condition.getCategoryId() != 0) {
            condition.setCategoryIdList(shopService.GoodsIdByCategoryId(condition.getCategoryId()));
        }
        //分页查询: 从solr索引库中查询
        PageResult pageResult = searchService.searchPage(condition);
        return pageResult;
    }
}
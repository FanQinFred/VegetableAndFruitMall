package cn.cqu.vspace.service;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
/**
 * @Author: Stephen
 * @Edition: V1.0
 * @CreateDate: 2021/5/28 9:24 * @Description: 搜索服务接口
 */
public interface SearchService {
    //创建方法: 按关键字搜索[并分页][排序]显示
//1: 将关键字、分页信息、查询条件等信息都封装到Condition中 //2: 将查询结果封装到PageResult实体中
    JSONObject searchPage(String keyWord, int pageNo, int pageSize);
}

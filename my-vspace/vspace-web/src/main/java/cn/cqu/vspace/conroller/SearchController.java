package cn.cqu.vspace.conroller;


import cn.cqu.vspace.service.SearchService;
import com.alibaba.fastjson.JSONObject;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {
    @Reference
    SearchService searchService;
    @RequestMapping(value = "/searchInfoByKeyWord", method = RequestMethod.POST)
    public JSONObject searchPage(@Param("keyWord") String keyWord, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize){
        return searchService.searchPage(keyWord, pageNo, pageSize);
    }
}

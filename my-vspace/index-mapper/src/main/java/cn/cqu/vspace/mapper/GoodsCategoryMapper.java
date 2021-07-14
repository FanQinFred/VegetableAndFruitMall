package cn.cqu.vspace.mapper;


import java.util.List;

import cn.cqu.vspace.pojo.GoodsCategory;
import cn.cqu.vspace.pojo.GoodsCategoryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsCategoryMapper {
    long countByExample(GoodsCategoryExample example);
    List<GoodsCategory> selectByExample(GoodsCategoryExample example);
    List<Integer> selectByCategory(Integer categoryId);
    List<Integer> selectByGoods(Integer goodsId);
}
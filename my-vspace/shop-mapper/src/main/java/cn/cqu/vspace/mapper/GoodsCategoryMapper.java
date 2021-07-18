package cn.cqu.vspace.mapper;


import cn.cqu.vspace.pojo.GoodsCategory;
import cn.cqu.vspace.pojo.GoodsCategoryExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsCategoryMapper {
    long countByExample(GoodsCategoryExample example);
    List<GoodsCategory> selectByExample(GoodsCategoryExample example);
    List<Integer> selectByCategory(Integer categoryId);
    List<Integer> selectByGoods(Integer goodsId);
}
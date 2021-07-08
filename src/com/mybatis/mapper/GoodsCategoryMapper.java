package com.mybatis.mapper;

import com.mybatis.po.GoodsCategory;
import com.mybatis.po.GoodsCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCategoryMapper {
    int countByExample(GoodsCategoryExample example);

    int deleteByExample(GoodsCategoryExample example);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    List<GoodsCategory> selectByExample(GoodsCategoryExample example);

    int updateByExampleSelective(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    int updateByExample(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);
}
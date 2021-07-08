package com.mybatis.mapper;

import com.mybatis.po.UserGoods;
import com.mybatis.po.UserGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGoodsMapper {
    int countByExample(UserGoodsExample example);

    int deleteByExample(UserGoodsExample example);

    int insert(UserGoods record);

    int insertSelective(UserGoods record);

    List<UserGoods> selectByExample(UserGoodsExample example);

    int updateByExampleSelective(@Param("record") UserGoods record, @Param("example") UserGoodsExample example);

    int updateByExample(@Param("record") UserGoods record, @Param("example") UserGoodsExample example);
}
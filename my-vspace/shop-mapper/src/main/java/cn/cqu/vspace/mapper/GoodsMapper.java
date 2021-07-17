package cn.cqu.vspace.mapper;


import cn.cqu.vspace.pojo.Goods;
import cn.cqu.vspace.pojo.GoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    List<Integer> findGoodsById(int goodsId);
}

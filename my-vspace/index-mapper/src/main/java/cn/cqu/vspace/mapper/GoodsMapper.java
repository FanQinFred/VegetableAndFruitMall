package cn.cqu.vspace.mapper;

import java.util.List;

import cn.cqu.vspace.pojo.Goods;
import cn.cqu.vspace.pojo.GoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    List<Goods> selectTopFour();

    List<Goods> selectByPrimaryKey(Integer goodsId);

    List<Goods> selectNewest();

    List<Goods> selectTopThree();

    List<Goods> selectCheapest();

}
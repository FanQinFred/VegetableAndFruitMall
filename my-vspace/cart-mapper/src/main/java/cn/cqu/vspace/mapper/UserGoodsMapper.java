package cn.cqu.vspace.mapper;

import cn.cqu.vspace.pojo.UserGoods;
import cn.cqu.vspace.pojo.UserGoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserGoodsMapper {
    int insert(@Param("goodsId") int goodsId, @Param("userId") int userId);
    List<UserGoods> selectByExample(UserGoodsExample record);
}

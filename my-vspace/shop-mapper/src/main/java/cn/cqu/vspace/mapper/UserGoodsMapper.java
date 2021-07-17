package cn.cqu.vspace.mapper;

import cn.cqu.vspace.pojo.UserGoods;
import cn.cqu.vspace.pojo.UserGoodsExample;

import java.util.List;

public interface UserGoodsMapper {
    int insert(UserGoods goods);
    List<UserGoods> selectByExample(UserGoodsExample record);
}

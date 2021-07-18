package cn.cqu.vspace.mapper;

import cn.cqu.vspace.pojo.UserGoods;
import cn.cqu.vspace.pojo.UserGoodsExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserGoodsMapper {
    int insert(int GOODS_ID, int USER_ID, int CartOrWishList, int AMOUNT);
    List<UserGoods> selectByExample(UserGoodsExample record);

}

package cn.cqu.vspace.mapper;

import cn.cqu.vspace.pojo.UserGoods;
import cn.cqu.vspace.pojo.UserGoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserGoodsMapper {
    int insert(@Param("GOODS_ID") int GOODS_ID,@Param("USER_ID") int USER_ID,
               @Param("CartOrWishList") int CartOrWishList,@Param("AMOUNT") int AMOUNT);
    List<UserGoods> selectByExample(UserGoodsExample record);

}

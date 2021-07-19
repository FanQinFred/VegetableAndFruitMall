package cn.cqu.vspace.mapper;

import cn.cqu.vspace.pojo.UserGoods;
import cn.cqu.vspace.pojo.UserGoodsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.ManagedBean;
import java.util.List;

@Mapper
public interface UserGoodsMapper {
    int insert(UserGoods goods);
    List<UserGoods> selectByExample(UserGoodsExample record);
    int delete(@Param("gid") int gid, @Param("uid") int uid, @Param("cartOrWish") int cartOrWish);
    int updateToCart(@Param("gid") int gid, @Param("uid") int uid, @Param("cartOrWish") int cartOrWish);
}

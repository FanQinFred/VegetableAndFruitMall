package cn.cqu.vspace.mapper;

import java.util.List;

public interface ShopMapper {
    List<Integer> findGoodsIdsByCategory(int categoryId);
    List<Integer> findGoodsById(int goodsId);

}

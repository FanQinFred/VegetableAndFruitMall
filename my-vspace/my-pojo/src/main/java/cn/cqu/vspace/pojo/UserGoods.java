package cn.cqu.vspace.pojo;

import java.io.Serializable;

public class UserGoods implements Serializable {
    private Integer goodsId;

    private Integer userId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
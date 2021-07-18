package cn.cqu.vspace.pojo;

public class UserGoods {
    private Integer goodsId;

    private Integer userId;

    private Integer cartorwishlist;

    private Integer amount;

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

    public Integer getCartorwishlist() {
        return cartorwishlist;
    }

    public void setCartorwishlist(Integer cartorwishlist) {
        this.cartorwishlist = cartorwishlist;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
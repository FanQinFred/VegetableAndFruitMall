package com.example.demo.entity;

public class Goods {
    private String goodsId;

    private String goodsName;

    private String goodsRate;

    private String goodsImgUrl;

    private String goodsOriginalPrice;

    private String goodsCurrentPrice;

    private String goodsSeason;

    private String goodsDescription;

    private String goodsAmount;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsRate() {
        return goodsRate;
    }

    public void setGoodsRate(String goodsRate) {
        this.goodsRate = goodsRate == null ? null : goodsRate.trim();
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl == null ? null : goodsImgUrl.trim();
    }

    public String getGoodsOriginalPrice() {
        return goodsOriginalPrice;
    }

    public void setGoodsOriginalPrice(String goodsOriginalPrice) {
        this.goodsOriginalPrice = goodsOriginalPrice == null ? null : goodsOriginalPrice.trim();
    }

    public String getGoodsCurrentPrice() {
        return goodsCurrentPrice;
    }

    public void setGoodsCurrentPrice(String goodsCurrentPrice) {
        this.goodsCurrentPrice = goodsCurrentPrice == null ? null : goodsCurrentPrice.trim();
    }

    public String getGoodsSeason() {
        return goodsSeason;
    }

    public void setGoodsSeason(String goodsSeason) {
        this.goodsSeason = goodsSeason == null ? null : goodsSeason.trim();
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }

    public String getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(String goodsAmount) {
        this.goodsAmount = goodsAmount == null ? null : goodsAmount.trim();
    }
}
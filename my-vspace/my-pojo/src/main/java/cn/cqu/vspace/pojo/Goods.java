package cn.cqu.vspace.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;


public class Goods implements Serializable {
    @Field("GOODS_ID")
    private Integer goodsId;

    @Field("GOODS_NAME")
    private String goodsName;

    @Field("GOODS_RATE")
    private String goodsRate;

    @Field("GOODS_IMG_URL")
    private String goodsImgUrl;

    @Field("GOODS_ORIGINAL_PRICE")
    private String goodsOriginalPrice;

    @Field("GOODS_CURRENT_PRICE")
    private String goodsCurrentPrice;

    @Field("GOODS_SEASON")
    private String goodsSeason;

    @Field("GOODS_DESCRIPTION;")
    private String goodsDescription;

    @Field("GOODS_AMOUNT")
    private String goodsAmount;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

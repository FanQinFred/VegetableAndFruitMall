package cn.cqu.vspace.pojo;

import java.io.Serializable;

public class Review implements Serializable {
    private Integer reviewId;

    private Integer blogId;

    private Integer goodsId;

    private Integer userId;

    private String reviewRate;

    private String reviewHot;

    private String reviewDate;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

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

    public String getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(String reviewRate) {
        this.reviewRate = reviewRate == null ? null : reviewRate.trim();
    }

    public String getReviewHot() {
        return reviewHot;
    }

    public void setReviewHot(String reviewHot) {
        this.reviewHot = reviewHot == null ? null : reviewHot.trim();
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate == null ? null : reviewDate.trim();
    }
}
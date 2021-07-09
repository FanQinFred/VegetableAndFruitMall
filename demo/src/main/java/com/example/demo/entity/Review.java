package com.example.demo.entity;

public class Review {
    private String reviewId;

    private String blogId;

    private String goodsId;

    private String userId;

    private String reviewRate;

    private String reviewHot;

    private String reviewDate;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId == null ? null : reviewId.trim();
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId == null ? null : blogId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
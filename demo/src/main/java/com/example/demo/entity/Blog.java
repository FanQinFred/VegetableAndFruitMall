package com.example.demo.entity;

public class Blog {
    private String blogId;

    private String userId;

    private String blogImgUrl;

    private String blogDate;

    private String blogContent;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId == null ? null : blogId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBlogImgUrl() {
        return blogImgUrl;
    }

    public void setBlogImgUrl(String blogImgUrl) {
        this.blogImgUrl = blogImgUrl == null ? null : blogImgUrl.trim();
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate == null ? null : blogDate.trim();
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}
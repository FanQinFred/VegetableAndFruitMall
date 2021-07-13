package cn.cqu.vspace.pojo;


import java.io.Serializable;

public class Blog implements Serializable {
    private Integer blogId;

    private Integer userId;

    private String blogImgUrl;

    private String blogDate;

    private String blogContent;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
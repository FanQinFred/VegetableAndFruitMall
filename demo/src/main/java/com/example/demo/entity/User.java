package com.example.demo.entity;

public class User {
    private String userId;

    private String email;

    private String pwd;

    private String token;

    private Byte tokenValid;

    private String imgUrl;

    private String role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Byte getTokenValid() {
        return tokenValid;
    }

    public void setTokenValid(Byte tokenValid) {
        this.tokenValid = tokenValid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", token='" + token + '\'' +
                ", tokenValid=" + tokenValid +
                ", imgUrl='" + imgUrl + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
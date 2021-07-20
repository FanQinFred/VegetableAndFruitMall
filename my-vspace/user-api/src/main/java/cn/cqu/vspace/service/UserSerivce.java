package cn.cqu.vspace.service;

public interface UserSerivce {
    String login(String email,String pwd);
    String logout(String token);
    String register(String email,String pwd);
}

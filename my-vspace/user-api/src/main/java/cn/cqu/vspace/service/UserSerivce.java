package cn.cqu.vspace.service;

public interface UserSerivce {
    String login(String email,String pwd);
    String logout(String email,String pwd);
    String register(String email,String pwd);
}

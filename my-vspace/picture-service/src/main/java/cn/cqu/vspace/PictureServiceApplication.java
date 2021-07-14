package cn.cqu.vspace;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//启用springboot
@SpringBootApplication
//启动dubbo
@EnableDubbo
//启动事务管理器
@EnableTransactionManagement
public class PictureServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PictureServiceApplication.class,args);
    }
}

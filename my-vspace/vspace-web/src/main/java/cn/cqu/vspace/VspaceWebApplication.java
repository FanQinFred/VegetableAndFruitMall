package cn.cqu.vspace;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//启用springboot
@SpringBootApplication
//启动dubbo
@EnableDubbo
public class VspaceWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(VspaceWebApplication.class,args);
    }
}

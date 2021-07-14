package cn.cqu.vspace.nginx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@PropertySource(value = "classpath:nginx.yml")

public class NginxInfo implements Serializable {
    @Value("${ip}")
    private String ip;
    @Value("${port}")
    private Integer port;

    @Override
    public String toString() {
        return "NginxInfo{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}

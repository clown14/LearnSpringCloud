package com.wkcto.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer //开启Eureka注册中心服务端
public class Application8761 {

    public static void main(String[] args) {
        SpringApplication.run(Application8761.class, args);
    }

}

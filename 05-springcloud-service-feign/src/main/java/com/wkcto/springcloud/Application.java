package com.wkcto.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication //SpringBoot注解开发
//@EnableEurekaClient //开启eureka客户端
//@EnableCircuitBreaker //开启熔断器功能


//@EnableDiscoveryClient @EnableEurekaClient //相似
@SpringCloudApplication
@EnableFeignClients //开启feign客户端支持
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


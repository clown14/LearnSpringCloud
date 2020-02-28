package com.wkcto.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-02-26 22:02
 **/

@Configuration //等价于一个Spring applicationContext.xml配置文件
public class BeanConfig {

    /**
     * @Bean 等价于：
     *
     * <bean id="restTemplate" class="xxx.xxx.xxx.RestTemplate">
     *
     * </bean>
     *
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

    
package com.wkcto.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
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
    @LoadBalanced   //使用ribbon实现负载均衡调用
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 覆盖掉原来ribbon默认的轮询负载均衡策略
     *
     * @return
     */
    @Bean
    public IRule iRule() {
        //return new RandomRule();    //采用随机的负载均衡策略
        return new RetryRule();     //采用重拾的负载均衡策略
    }


}

    
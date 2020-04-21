package com.wkcto.springcloud.service;

import com.wkcto.springcloud.fallback.MyFallback;
import com.wkcto.springcloud.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-04-21 15:23
 **/

/**
 * 使用feign的客户端注解绑定远程服务的名称
 * 远程服务的名称可以大写，也可以小写
 */

@FeignClient(name = "01-springcloud-service-provider",fallbackFactory = MyFallbackFactory.class)
public interface HelloService {
    /**
     * 声明一个方法，这个方法就是远程的服务提供者提供的那个方法
     *
     * @return
     */
    @RequestMapping("/service/hello")
    public String hello();
}

    
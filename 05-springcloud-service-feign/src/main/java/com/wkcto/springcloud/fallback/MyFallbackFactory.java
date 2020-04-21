package com.wkcto.springcloud.fallback;

import com.wkcto.springcloud.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-04-21 16:08
 **/

@Component
public class MyFallbackFactory implements FallbackFactory<HelloService> {

    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hello() {
                return throwable.getMessage();
            }
        };
    }
}

    
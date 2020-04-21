package com.wkcto.springcloud.controller;

import com.wkcto.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-04-21 15:28
 **/

@RestController
public class FeignController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/web/hello")
    public String hello() {

        //调用声明式的接口方法，实现对远程服务的调用
        return helloService.hello();
    }
}

    
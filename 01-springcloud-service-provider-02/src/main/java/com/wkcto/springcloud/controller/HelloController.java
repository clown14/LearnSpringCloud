package com.wkcto.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-02-26 21:51
 **/

@RestController
public class HelloController {

    @RequestMapping("/service/hello")
    public String hello() {
        //业务处理
        System.out.println("服务提供者2.。。。。。。。。。。");
        return "Hello, SpirngCloud，provider2";
    }
}

    
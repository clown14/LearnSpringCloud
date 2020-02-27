package com.wkcto.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-02-26 21:59
 **/

@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello() {
        //逻辑判断

        //调用SpringCloud服务提供者提供的服务

        return restTemplate.getForEntity("http://localhost:8080/service/hello", String.class).getBody();
    }
}

    
package com.wkcto.springcloud.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-05-12 15:28
 **/

@RestController
public class GateWayController {
    @RequestMapping("/api/local")
    public String hello() {

        System.out.println("在api gateway中执行逻辑处理。。。");

        return "exec the api gateway";
    }
}

    
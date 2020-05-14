package com.wkcto.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-05-13 20:53
 **/

@RestController
@RefreshScope
public class ConfigController {
    @Value("${url}")
    private String url;

    @RequestMapping("/cloud/url")
    public String url() {
        return url;
    }
}

    
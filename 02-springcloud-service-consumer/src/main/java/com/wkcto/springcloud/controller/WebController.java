package com.wkcto.springcloud.controller;

import com.wkcto.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

        //return restTemplate.getForEntity("http://localhost:8080/service/hello", String.class).getBody();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class);
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        String body = responseEntity.getBody();

        System.out.println(statusCodeValue);
        System.out.println(httpStatus);
        System.out.println(httpHeaders);
        System.out.println(body);

        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();
    }

    @RequestMapping("/web/user")
    public String user() {
        //逻辑判断

        //调用SpringCloud服务提供者提供的服务

        //return restTemplate.getForEntity("http://localhost:8080/service/hello", String.class).getBody();
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user", User.class);
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        User body = responseEntity.getBody();

        System.out.println(statusCodeValue);
        System.out.println(httpStatus);
        System.out.println(httpHeaders);
        System.out.println(body.getId() + "--" + body.getName() + "--" + body.getPhone());

        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user", String.class).getBody();
    }

    @RequestMapping("/web/getUser")
    public User getUser() {
        //逻辑判断

        String[] strArray = {"105", "李四", "136666666"};

        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id", 104);
        paramMap.put("name", "王五");
        paramMap.put("phone", "134444444");

        //调用SpringCloud服务提供者提供的服务

        //return restTemplate.getForEntity("http://localhost:8080/service/hello", String.class).getBody();
        //ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={0}&name={1}&phone={2}", User.class, strArray);

        //ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={id}&name={name}&phone={phone}", User.class, paramMap);

        User body1 = restTemplate.getForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={id}&name={name}&phone={phone}", User.class, paramMap);

        User body2 = restTemplate.getForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={0}&name={1}&phone={2}", User.class, strArray);

//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        HttpStatus httpStatus = responseEntity.getStatusCode();
//        HttpHeaders httpHeaders = responseEntity.getHeaders();
//        User body = responseEntity.getBody();
//
//        System.out.println(statusCodeValue);
//        System.out.println(httpStatus);
//        System.out.println(httpHeaders);
        System.out.println(body1.getId() + "--" + body1.getName() + "--" + body1.getPhone());

        System.out.println(body2.getId() + "--" + body2.getName() + "--" + body2.getPhone());

        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={id}&name={name}&phone={phone}", User.class, paramMap).getBody();
    }
}

    
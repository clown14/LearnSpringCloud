package com.wkcto.springcloud.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wkcto.springcloud.hystrix.MyHystrixCommand;
import com.wkcto.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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


    /**
     * 消费者调用 -addUser方法
     * @return
     */
    @RequestMapping("/web/addUser")
    public User addUser() {
        //逻辑判断

        String[] strArray = {"105", "李四", "136666666"};

        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id", 104);
        paramMap.put("name", "王五");
        paramMap.put("phone", "134444444");

        //要传的表单信息，参数数据（坑人）
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap();
        dataMap.add("id", 104);
        dataMap.add("name", "王五");
        dataMap.add("phone", "134444444");

        //调用SpringCloud服务提供者提供的服务
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/addUser",dataMap, User.class);

        User body1 = restTemplate.postForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser", dataMap, User.class);


        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        User body2 = responseEntity.getBody();

        System.out.println(body2.getId() + "--" + body2.getName() + "--" + body2.getPhone());

        System.out.println(statusCodeValue);
        System.out.println(httpStatus);
        System.out.println(httpHeaders);
        System.out.println(body1.getId() + "--" + body1.getName() + "--" + body1.getPhone());


        return restTemplate.postForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/addUser", dataMap, User.class).getBody();
    }

    /**
     * 消费者调用 -updateUser方法
     * @return
     */
    @RequestMapping("/web/updateUser")
    public String updateUser() {
        //逻辑判断

        String[] strArray = {"105", "李四", "136666666"};

        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id", 104);
        paramMap.put("name", "王五");
        paramMap.put("phone", "134444444");

        //要传的表单信息，参数数据（坑人）
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap();
        dataMap.add("id", 104);
        dataMap.add("name", "王五");
        dataMap.add("phone", "134444444");

        //调用SpringCloud服务提供者提供的服务
        restTemplate.put("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/updateUser", dataMap);

        restTemplate.put("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/updateUser", dataMap);

        return "success";
    }

    /**
     * 消费者调用 -deleteUser方法
     * @return
     */
    @RequestMapping("/web/deleteUser")
    public String deleteUser() {
        //逻辑判断

        String[] strArray = {"105", "李四", "136666666"};

        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id", 104);
        paramMap.put("name", "王五");
        paramMap.put("phone", "134444444");

        //要传的表单信息，参数数据（坑人）
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap();
        dataMap.add("id", 104);
        dataMap.add("name", "王五");
        dataMap.add("phone", "134444444");

        //调用SpringCloud服务提供者提供的服务
        restTemplate.delete("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/deleteUser?id={0}&name={1}&phone={2}", strArray);

        restTemplate.delete("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/deleteUser?id={id}&name={name}&phone={phone}", paramMap);

        return "success";
    }

    /**
     * hystrix超时时间3.5s
     *
     * @return
     */
    @RequestMapping("/web/hystrix")
    @HystrixCommand(fallbackMethod = "error", ignoreExceptions = RuntimeException.class, commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3500")})
    public String hystrix() {

        //int a = 10 / 0; //除数不能为0

        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();
    }

    public String error(Throwable throwable) {

        System.out.println("异常:" + throwable.getMessage());
        //访问远程服务失败，该如何处理？
        //处理逻辑
        return "error";
    }

    @RequestMapping("/web/hystrix2")
    public String hystrix2() throws ExecutionException,InterruptedException{

        //int a = 10 / 0; //除数不能为0
        MyHystrixCommand myHystrixCommand = new MyHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")), restTemplate);

        //同步调用（该方法执行后，会等待远程的返回结果，拿到了远程的返回结果，该方法才返回，然后代码继续往下执行）
        //String str = myHystrixCommand.execute();

        //异步调用（该方法执行后，不会马上有远程的返回结果，将来会有结果
        Future<String> future = myHystrixCommand.queue();

        //写一些业务逻辑

        //阻塞的方法，直到拿到结果
        String str = future.get();

        //写一些业务逻辑

        return str;
    }
}

    
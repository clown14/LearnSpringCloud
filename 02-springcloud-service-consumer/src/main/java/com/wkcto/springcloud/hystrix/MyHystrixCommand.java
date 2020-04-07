package com.wkcto.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义hystrix请求
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-04-07 16:17
 **/

public class MyHystrixCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {

        int a = 10 / 0;
        //调用远程服务
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();
    }

    /**
     * 当远程服务超时、异常、不可用等情况时，会触发熔断方法
     * @return
     */
    @Override
    public String getFallback() {

        Throwable throwable = super.getExecutionException();
        System.out.println(throwable.getMessage());
        System.out.println(throwable.getStackTrace());

        //实现服务熔断/降级逻辑
        return "error2";
    }
}

    
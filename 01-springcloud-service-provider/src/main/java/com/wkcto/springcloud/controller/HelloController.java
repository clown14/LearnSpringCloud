package com.wkcto.springcloud.controller;

import com.wkcto.springcloud.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @program: wkctoProjects
 * @author: onion
 * @create: 2020-02-26 21:51
 **/

@RestController //等价于@Controller + @ResponseBody
public class HelloController {

//    @RequestMapping("/service/hello")
    @GetMapping("/service/hello")
    public String hello() {
        //业务处理
        System.out.println("服务提供者1.。。。。。。。。。。");
        return "Hello, SpirngCloud，provider1";
    }

    @RequestMapping("/service/user")
    public User user() {
        //业务处理
        System.out.println("服务提供者1.。。。。。。。。。。");
        User user = new User();
        user.setId(108);
        user.setName("张三");
        user.setPhone("138888888");

        return user;
    }

    @RequestMapping("/service/getUser")
    public User getUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone) {
        //业务处理
        System.out.println("服务提供者1.。。。。。。。。。。");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);

        return user;
    }

    //@RequestMapping(value = "/service/addUser",method = RequestMethod.POST)
    @PostMapping("/service/addUser")
    public User addUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone) {
        //业务处理
        System.out.println("服务提供者1.。。。。。。。。。。");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);

        //将user对象插入数据库（省略）
        return user;
    }

    //@RequestMapping(value = "/service/updateUser",method = RequestMethod.PUT)
    @PutMapping("/service/updateUser")
    public User updateUser(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone) {
        //业务处理
        System.out.println("服务提供者1.。。。。。。。。。。" + id + "--" + name + "--" + phone);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);

        //将user对象插入数据库（省略）
        return user;
    }

    //@RequestMapping(value = "/service/deleteUser",method = RequestMethod.DELETE)
    @DeleteMapping("/service/deleteUser")
    public User deleteUser(@RequestParam("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("phone") String phone) {
        //业务处理
        System.out.println("服务提供者1.。。。。。。。。。。" + id + "--" + name + "--" + phone);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);

        //将user对象插入数据库（省略）
        return user;
    }
}

    
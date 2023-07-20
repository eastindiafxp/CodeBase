package com.eastindia.springcloud.controller;

import com.eastindia.springcloud.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/service/hello")
    public String hello () {
//        System.out.println("服务提供者11111111");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello World!provider1";
    }

    @RequestMapping("/service/fxpTest1")
    public String fxpTest1() {

        System.out.println("服务提供者1111111---fxpTest");
        return "fxpTest1==============================";
    }

    @RequestMapping("/service/user")
    public User user () {

        System.out.println("服务提供者11111111111111111111111111111111");

        User user = new User(108, "张三丰", "19999999999");
        return user;
    }

    @RequestMapping("/service/getUser")
    public User getUserInfo(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("phone") String phone) {

        System.out.println("服务提供者11111111111111111111111111111111");
        User user = new User(id, name, phone);
        return user;
    }

//    @RequestMapping(value = "/service/addUser", method = RequestMethod.POST)
    @PostMapping(value = "/service/addUser")
    public User addUser(@RequestParam("id") int id,
                            @RequestParam("name") String name,
                            @RequestParam("phone") String phone) {

        System.out.println("服务提供者11111111111111111111111111111111");
        User user = new User(id, name, phone);
        //将user对象插入数据库。。。
        return user;
    }

    @PutMapping(value = "/service/updateUser")
    public User updateUser(@RequestParam("id") int id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone) {

        System.out.println("服务提供者11111111111111111111111111111111");
        User user = new User(id, name, phone);
        System.out.println(user);
        //将user对象插入数据库。。。
        return user;
    }

    @DeleteMapping(value = "/service/deleteUser")
    public User deleteUser(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("phone") String phone) {

        System.out.println("服务提供者11111111111111111111111111111111");
        User user = new User(id, name, phone);
        System.out.println(user);
        //将user对象插入数据库。。。
        return user;
    }

}

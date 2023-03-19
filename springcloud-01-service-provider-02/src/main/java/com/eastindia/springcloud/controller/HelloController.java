package com.eastindia.springcloud.controller;

import com.eastindia.springcloud.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/service/hello")
    public String hello () {
        System.out.println("服务提供者222222222");
//        int a = 10/0;//抛出一个运行时异常
        return "Hello World!provider2";
    }

    @RequestMapping("/service/user")
    public User user () {
        System.out.println("服务提供者2222222222222222222222222222222");

        User user = new User(108, "张三丰", "19999999999");
        return user;
    }

    @RequestMapping("/service/getUser")
    public User getUserInfo(@RequestParam("id") int id,
                            @RequestParam("name") String name,
                            @RequestParam("phone") String phone) {

        System.out.println("服务提供者2222222222222222222222222222222");
        User user = new User(id, name, phone);
        return user;
    }

    @PostMapping(value = "/service/addUser")
    public User addUser(@RequestParam("id") int id,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone) {

        System.out.println("服务提供者22222222222222222222222222222222");
        User user = new User(id, name, phone);
        //将user对象插入数据库。。。
        return user;
    }

    @PutMapping(value = "/service/updateUser")
    public User updateUser(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("phone") String phone) {

        System.out.println("服务提供者2222222222222222222222222222222222");
        User user = new User(id, name, phone);
        System.out.println(user);
        return user;
    }

    @DeleteMapping(value = "/service/deleteUser")
    public User deleteUser(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("phone") String phone) {

        System.out.println("服务提供者2222222222222222222222222222");
        User user = new User(id, name, phone);
        System.out.println(user);
        //将user对象插入数据库。。。
        return user;
    }

}

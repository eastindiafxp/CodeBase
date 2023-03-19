package com.eastindia.springcloud.controller;

import com.eastindia.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/web/hello")
    public String hello() {

        //调用声明式接口方法，实现对远程服务的调用
        return helloService.hello();
    }

}

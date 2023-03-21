package com.eastindia.springcloud.controller;

import com.eastindia.springcloud.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping("testRedis")
    public void testRedis() {

        redisService.testRedis();
    }

    @RequestMapping("testJedis")
    public void testJedis() {

        redisService.testJedis();
    }


}

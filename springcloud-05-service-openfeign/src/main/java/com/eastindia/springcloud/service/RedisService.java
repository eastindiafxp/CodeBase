package com.eastindia.springcloud.service;

import com.eastindia.springcloud.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "springcloud-08-redis", fallbackFactory = MyFallbackFactory.class)
public interface RedisService {

    @RequestMapping("/redis/testRedis")
    public void testRedis();

}

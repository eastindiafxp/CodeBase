package com.eastindia.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("redis")
public class RedisDemoController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/testRedis")
    public void testRedis() {

//      一、  String
//        set
        redisTemplate.opsForValue().set("name1", "张三");
//        get
        System.out.println("111:" + redisTemplate.opsForValue().get("name1"));
//        delete
        redisTemplate.delete("name");
        System.out.println("222:" + redisTemplate.opsForValue().get("name"));

//        二、list
        redisTemplate.opsForList().leftPush("name2", "v1");
        List<String> list = redisTemplate.opsForList().range("name2", 0, -1);

        for (String str : list) {
            System.out.println("name2:" + str);
        }
//        lpop
        System.out.println(redisTemplate.opsForList().leftPop("name2"));

//        三、set
        redisTemplate.opsForSet().add("name3", "v1", "v2", "v3");
        Set<String> set = redisTemplate.opsForSet().members("name3");
        for (String str : set) {
            System.out.println("name2:" + str);
        }

//        四、hash
        redisTemplate.opsForHash().put("name4", "name", "张三");
        System.out.println("name4:" + redisTemplate.opsForHash().get("name4", "name"));

//        五、zset
        redisTemplate.opsForZSet().add("name5", "v1", 5);
        redisTemplate.opsForZSet().add("name5", "v2", 6);
        redisTemplate.opsForZSet().add("name5", "v3", 7);
        redisTemplate.opsForZSet().add("name5", "v4", 8);
        redisTemplate.opsForZSet().add("name5", "v5", 9);

        Long index1 = redisTemplate.opsForZSet().rank("name5", "v1");
        Long index2 = redisTemplate.opsForZSet().rank("name5", "v3");
        System.out.println("name5-v1-index:" + index1);
        System.out.println("name5-v3-index:" + index2);





    }
}
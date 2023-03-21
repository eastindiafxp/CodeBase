package com.eastindia.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * 实战中都是使用redisTemplate，而不是用原生的jedis
 */
@RestController
@RequestMapping("redis")
public class RedisDemoController {

    @Autowired
    RedisTemplate redisTemplate;

    JedisPool jedisPool;

    @RequestMapping("/testRedis")
    public void testRedis() {

//        springboot对redis操作有两套api
//        1、第一套：
        redisTemplate.opsForValue().set("age", "18");
        redisTemplate.opsForHash().put("map", "name", "zhangsan");

//        2、第二套
        redisTemplate.boundValueOps("user").set("lisi");
        redisTemplate.boundHashOps("map1").put("username", "fxp");

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

    @RequestMapping("/testJedis")
    public void testJedis() {

        //1.创建连接
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);//最大空闲连接数
        config.setMinIdle(5);//最小空闲连接
        config.setMaxWait(Duration.ofSeconds(3));//最大阻塞等待时间
        config.setMaxTotal(50);//最大连接数
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);

        //2.获得连接
        Jedis jedis = jedisPool.getResource();
        jedis.auth("952008fxpdl");

        //3.操作

//        String
//        String pv = jedis.set("pv", "0");
//        String pv1 = jedis.get("pv");
//        System.out.println(pv1);
//        jedis.set("pv", "1000");
//        System.out.println(jedis.get("pv"));
//
//        jedis.incr("pv");
//        jedis.incrBy("pv", 1000);
//        System.out.println(jedis.get("pv"));


//        hash
//        jedis.hset("goods", "iphone13", "10000");
//        jedis.hset("goods", "huawei", "5000");
//
//        Set<String> goods = jedis.hkeys("goods");
//        for (String good : goods) {
//            System.out.println(good);
//        }
//
//        jedis.hincrBy("goods", "huawei", 3000);
//        String str = jedis.hget("goods", "huawei");
//        System.out.println(str);
//
//        jedis.del("good");

//        list
//        jedis.lpush("phoneno", "13333333333", "18888888888", "19999999999");
//        String no1 = jedis.rpop("phoneno");
//        System.out.println(no1);
//
//        List<String> list = jedis.lrange("phoneno", 0, -1);
//        for (String ss : list) {
//            System.out.println(ss);
//        }

//        set
        jedis.sadd("uv", "user1");
        jedis.sadd("uv", "user2");
        jedis.sadd("uv", "user1");

        long uv = jedis.scard("uv");
        System.out.println(uv);



//        Set<String> keys = jedis.keys("*");
//
//        for (String key : keys) {
//            System.out.println(key);
//        }

//        关闭jedis
        jedis.close();
        //9.关闭连接
        jedisPool.close();

    }


}
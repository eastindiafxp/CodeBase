package com.eastindia.springcloud.service;

import com.eastindia.springcloud.fallback.MyFallbackFactory;
import com.eastindia.springcloud.fallback.Myfallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用feign客户端注解绑定远程服务的名称，不区分大小写
 */
@FeignClient(name = "springcloud-01-service-provider",
//        fallback = Myfallback.class,
fallbackFactory = MyFallbackFactory.class)//配置服务提供者的名称，不区分大小写。底层集成了负载均衡ribbon
public interface HelloService {

    /**
     * 声明一个方法，这个方法就是远程的服务提供者提供的那个方法
     * @return
     */
    @RequestMapping("/service/hello")
    public String hello();
}

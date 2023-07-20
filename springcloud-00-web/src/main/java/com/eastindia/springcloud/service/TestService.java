package com.eastindia.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="springcloud-01-service-provider")
public interface TestService {

    @RequestMapping("/service/fxpTest1")
    public String fxpTest();

}

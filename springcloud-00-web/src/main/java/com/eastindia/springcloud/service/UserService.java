package com.eastindia.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(contextId="userClient", name="springcloud-01-service-provider")
public interface UserService {

    @RequestMapping("/provider/user/getAllUserList")
    public List getAllUsers();
}

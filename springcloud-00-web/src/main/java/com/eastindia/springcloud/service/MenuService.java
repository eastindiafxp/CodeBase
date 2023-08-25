package com.eastindia.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId="menuClient", name="springcloud-01-service-provider")
public interface MenuService {

    @RequestMapping("/provider/menu/getMenu")
    String getMenu(@RequestParam(value="roleIds") String roleIds);
}

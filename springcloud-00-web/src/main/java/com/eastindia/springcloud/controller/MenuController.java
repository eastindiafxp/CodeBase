package com.eastindia.springcloud.controller;

import com.eastindia.springcloud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/web/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/getMenu")
    public String getMenu(String roleIds) {

        String listStr = menuService.getMenu(roleIds);
        return listStr;
    }

}

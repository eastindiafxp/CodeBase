package com.eastindia.springcloud.controller;

import com.eastindia.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/web/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getAllUsers")
    public List getAllUsers() {

        List list = userService.getAllUsers();
        return list;
    }

}

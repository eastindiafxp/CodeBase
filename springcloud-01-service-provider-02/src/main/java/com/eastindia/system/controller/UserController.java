package com.eastindia.system.controller;

import com.eastindia.system.bean.SysUser;
import com.eastindia.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider/user")
public class UserController {

    @Autowired
    UserService userservice;

    @RequestMapping("/getAllUserList")
    public List<SysUser> getAllUserList() {

        List<SysUser> list = userservice.getAllUserList();
        System.out.println("22222222222222222222222");
        return list;
    }

}

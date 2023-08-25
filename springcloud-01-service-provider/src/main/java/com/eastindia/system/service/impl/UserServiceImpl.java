package com.eastindia.system.service.impl;

import com.eastindia.system.mapper.UserMapper;
import com.eastindia.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List getAllUserList() {

        List userList = userMapper.getAllUserList();
        return userList;
    }


}

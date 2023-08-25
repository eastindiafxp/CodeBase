package com.eastindia.system.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {

    private Integer id;
    private String idCardNo;
    private String userName;
    private Integer age;
    private String gender;
    private String phoneNo;
    private Integer departmentId;
    private String password;
    private String salt;
    private Integer errCount;
    private String showStatus;

    private Date updateTime;
    private Date createTime;
}

package com.eastindia.system.mapper;

import com.eastindia.system.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

//    @Select("select id, id_card_no idCardNo, user_name userName, age, gender, phone_no phoneNo, department_id departmentId, password, salt, err_count errCount,\n" +
//            "show_status showStatus, update_time updateTime, create_time createTime from sys_user")
    List<SysUser> getAllUserList();
}

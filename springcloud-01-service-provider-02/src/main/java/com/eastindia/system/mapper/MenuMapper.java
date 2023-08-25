package com.eastindia.system.mapper;

import com.eastindia.system.bean.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface MenuMapper {

//    @Select("select * from sys_menu")
    List<SysMenu> getMenuList(Map param);
}

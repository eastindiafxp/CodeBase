package com.eastindia.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.eastindia.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/provider/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    /**
     * 根据权限获取菜单
     * @param roleIds 当前用户的角色id集合，各个id直接以英文逗号分隔
     * @return
     */
    @RequestMapping(value="/getMenu", produces="application/json;charset=utf-8")
    public String getMenu(@RequestParam(value="roleIds") String roleIds) {

        Map menus = null;
        if (StringUtils.hasLength(roleIds)) {
            menus = menuService.getMenus(roleIds);
        }
        return JSONObject.toJSONString(menus).toString();
    }


}

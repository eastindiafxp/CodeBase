package com.eastindia.system.service.impl;

import com.eastindia.system.bean.SysMenu;
import com.eastindia.system.mapper.MenuMapper;
import com.eastindia.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public Map getMenus(String roleIds) {

        Map param = new HashMap();
        if (StringUtils.hasLength(roleIds)) {
            String[] roleids = roleIds.split(",");
            Integer[] roles = new Integer[roleids.length];
            for (int i = 0; i < roleids.length; i++) {
                roles[i] = Integer.parseInt(roleids[i]);
            }
            param.put("roleId", roles);
        }
        List<SysMenu> menuList = menuMapper.getMenuList(param);

        List<SysMenu> listAll = new ArrayList<>();
        Map<String, List<SysMenu>> map = new LinkedHashMap<>();     //用于存储菜单
        for (SysMenu pageMenu : menuList) {
            if(pageMenu == null)  continue;
            List<SysMenu> list = map.get(pageMenu.getPageType());
            if (list == null) {
                list = new ArrayList<>();
                map.put(pageMenu.getPageType(), list);
            }

            SysMenu menu = new SysMenu();
            menu.setId(pageMenu.getId());
            menu.setUrl(pageMenu.getUrl());
            menu.setName(pageMenu.getName());
            menu.setPageType(pageMenu.getPageType());
            menu.setMenuLevel(pageMenu.getMenuLevel());

            if (1 == pageMenu.getMenuLevel()) {//一级菜单
//                SysMenu menu = new SysMenu();
//                menu.setId(pageMenu.getId());
//                menu.setUrl(pageMenu.getUrl());
//                menu.setName(pageMenu.getName());
//                menu.setPageType(pageMenu.getPageType());
//                menu.setMenuLevel(pageMenu.getMenuLevel());
                list.add(menu);
//                listAll.add(menu);
            } else {//二级菜单
                SysMenu parentMenu = getParenMenu(listAll, pageMenu);
                if (parentMenu == null) {
                    break;
                }
                List<SysMenu> submenuList = parentMenu.getSubMenu();
                if (submenuList == null) {
                    submenuList = new ArrayList<>();
                    parentMenu.setSubMenu(submenuList);
                }
//                SysMenu subMenu = new SysMenu();
//                subMenu.setId(pageMenu.getId());
//                subMenu.setName(pageMenu.getName());
//                subMenu.setUrl(pageMenu.getUrl());
//                subMenu.setMenuLevel(pageMenu.getMenuLevel());
//                subMenu.setPageType(pageMenu.getPageType());
                //加入子级菜单项中
                submenuList.add(menu);
                // 加入到所有菜单列表中，用于查找父级菜单
//                listAll.add(subMenu);
            }
            // 加入到所有菜单列表中，用于查找父级菜单
            listAll.add(menu);
        }
        return map;
    }


    /**
     * 在给定的菜单list中获取指定菜单
     * @param list
     * @param thisMenu
     * @return
     */
    public SysMenu getParenMenu(List<SysMenu> list, SysMenu thisMenu) {

        for(SysMenu pageMenu : list) {
            if((thisMenu.getHigherLevelId() == pageMenu.getId() || thisMenu.getHigherLevelId().equals(pageMenu.getId()))
                    && thisMenu.getPageType().equalsIgnoreCase(pageMenu.getPageType())) {
                return pageMenu;
            }
        }
        return  null;
    }



}

package com.eastindia.system.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 菜单表实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SysMenu {

    /** 唯一标识 */
    private String id;
    /** 菜单对应的网页文件（jsp等）地址 */
    private String url;
    /** 菜单名称 */
    private String name;
    /** 菜单类型（分类） */
    private String pageType;
    /** 菜单级别 */
    private Integer menuLevel;
    /** 唯一标识 */
    private String higherLevelId;
    /** 菜单项的排序依据 */
    private Integer orderby;

    /** 子菜单 */
    public List<SysMenu> subMenu;
//    public List<SysMenu> getSubMenu() {
//        return subMenu;
//    }
//
//    public void setSubMenu(List<SysMenu> subMenu) {
//        this.subMenu = subMenu;
//    }


    @Override
    public String toString() {
        return super.toString();
    }
}
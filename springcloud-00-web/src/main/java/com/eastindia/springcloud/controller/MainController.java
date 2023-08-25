package com.eastindia.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/mainPage")
    public String RequestSubPage(HttpServletRequest request, HttpServletResponse response,
                                 String token, String pageName, String menuname/*,String username,String roleid*/) {

//        String username =(String) SecurityUtils.getSubject().getSession().getAttribute("loginUserName");
//        String roleid =(String) SecurityUtils.getSubject().getSession().getAttribute("roleid");
//        //System.out.println(pageName);
//        request.setAttribute("PageName",menuname);
//        int count = forecastMenuService.GetMenuCount(pageName,roleid);
//        if (count != 0) {
//            return pageName;
//        } else { //该用户下面菜单没有权限处理
//            return "error";
//        }
        return pageName;
    }

}

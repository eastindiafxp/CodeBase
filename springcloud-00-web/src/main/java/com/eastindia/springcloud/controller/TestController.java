package com.eastindia.springcloud.controller;

import com.eastindia.springcloud.service.TestService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("test")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/web/index")
//    @ResponseBody
    public String index2() {

        System.out.println("00000000000999999999");
        return "index";
//        return testService.fxpTest();
    }

}

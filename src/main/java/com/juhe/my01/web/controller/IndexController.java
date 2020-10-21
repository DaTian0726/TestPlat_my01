package com.juhe.my01.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: IndexController
 * Description:
 * date: 2020/8/28 13:46
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping
public class IndexController {

   //TODO   设置入网拦截，实现内部网络可以使用


    /**
     * 聚合测试平台首页
     * @return
     */
    @RequestMapping("/")
    public ModelAndView Index(){
        return new ModelAndView("common/index");
    }

    @GetMapping("/index")
    public ModelAndView TestGet(){
            return new ModelAndView("index");
    }
    @GetMapping("/test")
    public ModelAndView TestPost(){
        return new ModelAndView("test");

    }

}

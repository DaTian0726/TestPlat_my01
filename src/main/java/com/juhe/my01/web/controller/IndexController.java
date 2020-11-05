package com.juhe.my01.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    static List<String> list = new ArrayList<>();
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

//    /*
//    异步通知N001接口
//     */
//    @RequestMapping("/asyn")
//    public void AsynCallBack(HttpServletResponse response,HttpServletRequest request){
//        String  result = "";
//        try {
//             result = getResUtil(request);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        list.add(result);
//        System.out.println(result);
//
//    }
//
//    public  String getResUtil(HttpServletRequest request) throws  Exception{
//
//        BufferedReader    reader = request.getReader();
//
//
//        StringBuilder sb = new StringBuilder();
//        String temp = "";
//        while ((temp = reader.readLine()) != null){
//                sb.append(temp);
//        }
//
//        return sb.toString();
//    }

}

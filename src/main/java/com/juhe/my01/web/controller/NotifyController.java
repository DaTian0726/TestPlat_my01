package com.juhe.my01.web.controller;

import com.juhe.my01.web.service.juhe.NotifyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName: NotifyService
 * Description:
 * date: 2020/11/5 15:42
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping
public class NotifyController {

    static List<String> list = new ArrayList<>();

    NotifyService notifyService = new NotifyService();

    /**
     * 异步通知N001接口
     * @param response
     * @param request
     */
    @RequestMapping("/asyn")
    public void AsynCallBack(HttpServletResponse response, HttpServletRequest request){
        NotifyService notifyService = new NotifyService();
        String  result = "";
        Writer writer;
        try {
            result = notifyService.getResUtil(request);
            writer = response.getWriter();
            if(StringUtils.isNotBlank(result)){
                writer.write("SUCCESS = Y");
            }else {
                writer.write("SUCCESS = N");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        list.add(result);
        System.out.println(result);

    }

    /**
     *
     * @param request
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/notify")
    public ModelAndView NotifyGet(HttpServletRequest request, HttpServletResponse response, Map map){
//        map.put("list",list);
        if(list.isEmpty()){
            map.put("state","1");
            map.put("list","");
        }else {
            List list1 = notifyService.ResultTransShow("","",list);
            map.put("list",list1);
            map.put("state","0");

        }
        return new ModelAndView("juhe/notify",map);
    }

    /**
     *
     * @param transId
     * @param mhtOrderNo
     * @param map
     * @return
     */
    @PostMapping("/notify")
    public ModelAndView NotifyListQuery(@RequestParam String transId,
                                        @RequestParam String mhtOrderNo,
                                        Map map){
        if(list.isEmpty()){
            map.put("state","1");
            map.put("list","");
        }else {
            List list1 = notifyService.ResultTransShow(transId,mhtOrderNo,list);
            map.put("list",list1);
            map.put("state","0");

        }
        return new ModelAndView("juhe/notify",map);
    }




}

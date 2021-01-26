package com.juhe.my01.web.controller;

import com.alibaba.fastjson.JSON;
import com.juhe.my01.utils.EncryDecryUtils;
import com.juhe.my01.utils.Undecode_util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * ClassName: UtilsController
 * Description:
 * date: 2020/9/4 17:54
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping
public class UtilsController {

    private  static final String KEY_TEST = "doxfqtoh69gosffefmqcuaqk";
    private  static final String KEY_LINE = "o751qdkkv4ymc6xohpsl1qmw";


    /**
     * 清结算退款报文DES解析
     * @return
     */
    @GetMapping("/des")
    public ModelAndView DESGet(Map map){
        map.put("des","");
        return new ModelAndView("utils/des",map);
    }

    @PostMapping("/des")
    public ModelAndView DESPost(@RequestParam("verifySign") String verifySign,
                                @RequestParam("key") String key,
                                HttpServletRequest request, HttpServletResponse response, Map map){
        if(verifySign.equals("")){
            map.put("des","");
            return new ModelAndView("utils/des",map);
        }
        if(request.getParameter("submit").equals("test")){
            if(StringUtils.isNotBlank(key)){
                String result = EncryDecryUtils.decryptFromBase64DES(key, Undecode_util.res(verifySign));//测试环境
                map.put("des", JSON.toJSONString(result, true));
            }else {
                String result = EncryDecryUtils.decryptFromBase64DES(KEY_TEST, Undecode_util.res(verifySign));//测试环境
                map.put("des", JSON.toJSONString(result, true));
            }
        }else {
            if(key.equals("")){
                String result = EncryDecryUtils.decryptFromBase64DES(KEY_LINE, Undecode_util.res(verifySign));//生产环境
                map.put("des", JSON.toJSONString(result, true));
            }else {
                String result = EncryDecryUtils.decryptFromBase64DES(key, Undecode_util.res(verifySign));//生产环境
                map.put("des", JSON.toJSONString(result, true));
            }
        }

        return new ModelAndView("utils/des",map);
    }


    /**
     *
     *
     */

    @GetMapping("/url")
    public ModelAndView UrlGet(Map map){
        map.put("res","");
        return new ModelAndView("utils/url",map);

    }
    @PostMapping("/url")
    public ModelAndView UrlPost(@RequestParam("verifySign") String verifySign,
                                HttpServletRequest request, HttpServletResponse response, Map map){
        if(verifySign.equals("")){
            map.put("res","");
            return new ModelAndView("utils/url",map);
        }

        if(request.getParameter("submit").equals("encode")){
            map.put("res",Undecode_util.encode(verifySign));
            return new ModelAndView("utils/url",map);
        }else if(request.getParameter("submit").equals("decode")){
            map.put("res",Undecode_util.res(verifySign));
            return new ModelAndView("utils/url",map);
        }else{
            map.put("res","");
            return new ModelAndView("utils/url",map);
        }
    }
}

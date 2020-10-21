package com.juhe.my01.web.controller;

import com.juhe.my01.models.juhe.WeChatModel;
import com.juhe.my01.web.model.juhe.*;
import com.juhe.my01.web.service.juhe.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CMBController
 * Description:
 * date: 2020/9/10 10:04
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping
public class CMBController {

    private static Map result = new HashMap();
    /**
     * 主扫业务处理逻辑
     * @param request
     * @param response
     * @param activeModel
     * @return
     */
    @PostMapping("/CMBActivePay")
    public ModelAndView ActivePayPost(HttpServletRequest request, HttpServletResponse response , ActiveModel activeModel, Map<String,Object> map){
        ActiveService activeService = new ActiveService();
        if(request.getParameter("submit").equals("test")){
            activeModel.setUrl("https://cmb-test-payapi.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            activeModel.setUrl("https://ipaynow.acquire.cmbchina.com/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            activeModel.setUrl("https://ipaynow.acquire.cmbchina.com/");
        }
        result = activeService.Active(activeModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state",result.get("state"));
        return new ModelAndView("cmb/result",map);
    }
    @GetMapping("/CMBActivePay")
    public ModelAndView ActivePayGet(Map<String,Object> map){
        ActiveModel activeModel = new ActiveModel();
        activeModel.setAppId("154217605294057");
        activeModel.setAppKey("kfdrLtVfohI046XZe2RY5m2CQ5vhSt0R");
        map.put("activeModel",activeModel);
        return new ModelAndView("cmb/activePay",map);
    }

    /**
     * 被扫业务系统处理逻辑
     * @param request
     * @param response
     * @param barcodeModel
     * @return
     */

    @PostMapping("/CMBBarcodePay")
    public ModelAndView BarcodePayPost(HttpServletRequest request, HttpServletResponse response , BarcodeModel barcodeModel, Map map){
        BarcodeService barcodeService = new BarcodeService();
        if(request.getParameter("submit").equals("test")){
            barcodeModel.setUrl("https://cmb-test-payapi.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            barcodeModel.setUrl("https://ipaynow.acquire.cmbchina.com/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            barcodeModel.setUrl("https://ipaynow.acquire.cmbchina.com/");
        }
        result = barcodeService.Barcode(barcodeModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state","");
        return new ModelAndView("cmb/result",map);
    }
    @GetMapping("/CMBBarcodePay")
    public ModelAndView BarcodePayGet(Map<String,Object> map){
        BarcodeModel barcodeModel = new BarcodeModel();
        barcodeModel.setAppId("153197674775958");
        barcodeModel.setAppKey("0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");
        map.put("barcodeModel",barcodeModel);
        return new ModelAndView("cmb/barcodePay",map);
    }

    /**
     * 退款业务系统逻辑
     * @param request
     * @param response
     * @param refundModel
     * @return
     */

    @PostMapping("/CMBRefund")
    public ModelAndView RefundPost(HttpServletRequest request, HttpServletResponse response , RefundModel refundModel, Map map){
        RefundService refundService = new RefundService();
        if(request.getParameter("submit").equals("test")){
            refundModel.setUrl("http://192.168.105.5:8780/cmb_refund_access");
        }else if (request.getParameter("submit").equals("pre")){
            refundModel.setUrl("https://ipaynow.acquire.cmbchina.com/api_release/refund/refundOrder");
        }else if(request.getParameter("submit").equals("line")){
            refundModel.setUrl("https://ipaynow.acquire.cmbchina.com/refund/refundOrder");
        }
        result = refundService.Refund(refundModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state","");
        return new ModelAndView("cmb/result",map);
    }
    @GetMapping("/CMBRefund")
    public ModelAndView RefundGet(Map map){
        RefundModel refundModel = new RefundModel();
        refundModel.setAppId("154760518510533");
        refundModel.setAppKey("RogwtWL5OeZjoZ9RgNDenefAtbbCVJj6");
        refundModel.setVersion("1.1.0");
        map.put("refundModel",refundModel);
        return new ModelAndView("cmb/refund");
    }


    /**
     * 聚合码业务系统处理逻辑
     * @param request
     * @param response
     * @param mediaModel
     * @return
     */

    @PostMapping("/CMBJuHeMaPay")
    public ModelAndView JuHeMaPayPost(HttpServletRequest request, HttpServletResponse response , MediaModel mediaModel, Map map){
        MediaService mediaService = new MediaService();
        if(request.getParameter("submit").equals("test")){
            mediaModel.setUrl("https://cmb-test-payapi.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            mediaModel.setUrl("https://ipaynow.acquire.cmbchina.com/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            mediaModel.setUrl("https://ipaynow.acquire.cmbchina.com/");
        }
        result = mediaService.Media(mediaModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state",result.get("state"));
        return new ModelAndView("cmb/result",map);
    }
    @GetMapping("/CMBJuHeMaPay")
    public ModelAndView JuHeMaPayGet(Map<String,Object> map){
        MediaModel mediaModel = new MediaModel();
        mediaModel.setAppId("156506034823529");
        mediaModel.setAppKey("Id2dkbEnAxh8powzRwJNkrYMWA7U7EPs");
        map.put("mediaModel",mediaModel);
        return new ModelAndView("cmb/mediaPay",map);
    }

    /**
     * 聚合码业务系统处理逻辑
     * @param request
     * @param response
     * @param weChatModel
     * @return
     */

    @PostMapping("/CMBWeChatPay")
    public ModelAndView WeChatPayPost(HttpServletRequest request, HttpServletResponse response , WeChatPayModel weChatModel, Map map){
        WeChatService weChatService = new WeChatService();
        if(request.getParameter("submit").equals("test")){
            weChatModel.setUrl("https://cmb-test-payapi.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            weChatModel.setUrl("https://ipaynow.acquire.cmbchina.com/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            weChatModel.setUrl("https://ipaynow.acquire.cmbchina.com/");
        }
        result = weChatService.WeChatPay(weChatModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state","1");
        return new ModelAndView("cmb/result",map);
    }
    @GetMapping("/CMBWeChatPay")
    public ModelAndView WeChatPayGet(Map<String,Object> map){
        WeChatPayModel weChatPayModel = new WeChatPayModel();
        weChatPayModel.setAppId("152404910235570");
        weChatPayModel.setAppKey("1uhtXpWBOOc4i7TlaGYmo18REZXoCSAx");
        map.put("wechatModel",weChatPayModel);
        return new ModelAndView("cmb/wechatPay",map);
    }

}

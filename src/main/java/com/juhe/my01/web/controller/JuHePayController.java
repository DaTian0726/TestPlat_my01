package com.juhe.my01.web.controller;

import com.juhe.my01.utils.EnumTransUtil;
import com.juhe.my01.web.model.juhe.*;
import com.juhe.my01.web.service.juhe.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: JuHePayController
 * Description:
 * date: 2020/8/31 17:51
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping
public class JuHePayController {

    private static Map result = new HashMap();

    /**
     * 主扫业务处理逻辑
     * @param request
     * @param response
     * @param activeModel
     * @return
     */
    @PostMapping("/activePay")
    public ModelAndView ActivePayPost(HttpServletRequest request, HttpServletResponse response , ActiveModel activeModel, Map<String,Object> map){
        ActiveService activeService = new ActiveService();
        activeModel.setUrl(EnumTransUtil.TransEnum(request.getParameter("URL"),request.getParameter("Service")));
        return new ModelAndView("common/result",InitMap(activeService.Active(activeModel)));
    }
    @GetMapping("/activePay")
    public ModelAndView ActivePayGet(Map<String,Object> map){
        ActiveModel activeModel = new ActiveModel();
        activeModel.setAppId("152756470127858");
        activeModel.setAppKey("H6pcftsbad9GImomudOYAhNJDVUiTcTq");
        map.put("activeModel",activeModel);
        return new ModelAndView("juhe/activePay",map);
    }

    /**
     * 被扫业务系统处理逻辑
     * @param request
     * @param response
     * @param barcodeModel
     * @return
     */

    @PostMapping("/barcodePay")
    public ModelAndView BarcodePayPost(HttpServletRequest request, HttpServletResponse response , BarcodeModel barcodeModel, Map map){
        BarcodeService barcodeService = new BarcodeService();
        barcodeModel.setUrl(EnumTransUtil.TransEnum(request.getParameter("URL"),request.getParameter("Service")));
        return new ModelAndView("common/result",InitMap(barcodeService.Barcode(barcodeModel)));
    }
    @GetMapping("/barcodePay")
    public ModelAndView BarcodePayGet(Map<String,Object> map){
        BarcodeModel barcodeModel = new BarcodeModel();
        barcodeModel.setAppId("160922204184042");
        barcodeModel.setAppKey("2jMS7NnjwJg0zLqHqMcKVrkyro3MqmuK");
        map.put("barcodeModel",barcodeModel);
        return new ModelAndView("juhe/barcodePay",map);
    }

    /**
     * 聚合码业务系统逻辑
     * @param request
     * @param response
     * @param mediaJuHeMaModel
     * @return
     */

    @PostMapping("/mediaPay_JuHeMa")
    public ModelAndView MediaPayJuHeMaPost(HttpServletRequest request, HttpServletResponse response , MediaJuHeMaModel mediaJuHeMaModel , Map map){
        MediaJuHeMaService mediaJuHeMaService = new MediaJuHeMaService();
        mediaJuHeMaModel.setUrl(EnumTransUtil.TransEnum(request.getParameter("URL"),request.getParameter("Service")));
        return new ModelAndView("common/result",InitMap(mediaJuHeMaService.Media(mediaJuHeMaModel)));
    }
    @GetMapping("/mediaPay_JuHeMa")
    public ModelAndView MediaPayJuHeMaGet(Map map){
        MediaJuHeMaModel mediaModel = new MediaJuHeMaModel();
        mediaModel.setAppId("156517474833930");
        mediaModel.setAppKey("WN13LDFjir9t9B0d3ZN0ySmpdL9AMEfU");
        map.put("mediaModel",mediaModel);
        return new ModelAndView("juhe/mediaPay_JuHeMa",map);
    }


    /**
     * 公众号业务系统逻辑
     * @param request
     * @param response
     * @param mediaJuHeMaModel
     * @return
     */

    @PostMapping("/mediaPay")
    public ModelAndView MediaPayPost(HttpServletRequest request, HttpServletResponse response , MediaJuHeMaModel mediaJuHeMaModel , Map map){
        MediaJuHeMaService mediaService = new MediaJuHeMaService();
        mediaJuHeMaModel.setUrl(EnumTransUtil.TransEnum(request.getParameter("URL"),request.getParameter("Service")));
        return new ModelAndView("common/result",InitMap(mediaService.Media(mediaJuHeMaModel)));
    }
    @GetMapping("/mediaPay")
    public ModelAndView MediaPayGet(Map map){
        MediaJuHeMaModel mediaModel = new MediaJuHeMaModel();
        mediaModel.setAppId("156517474833930");
        mediaModel.setAppKey("WN13LDFjir9t9B0d3ZN0ySmpdL9AMEfU");
        map.put("mediaModel",mediaModel);
        return new ModelAndView("juhe/mediaPay",map);
    }

    /**
     * 卡牌业务系统逻辑
     * @param state
     * @param map
     * @return
     */
    @RequestMapping("/cardPay")
    public ModelAndView CardPayGet(@RequestParam("state") String state,Map map){
        map.put("state",state);
        return new ModelAndView("juhe/cardPay",map);
    }

    /**
     * H5业务系统逻辑
     * @param request
     * @param response
     * @param tradeModel
     * @return
     */

    @PostMapping("/tradePay")
    public ModelAndView TradePayPost(HttpServletRequest request, HttpServletResponse response , TradeModel tradeModel, Map map){
        TradeService tradeService = new TradeService();
        tradeModel.setUrl(EnumTransUtil.TransEnum(request.getParameter("URL"),request.getParameter("Service")));
        return new ModelAndView("common/result",InitMap(tradeService.Trade(tradeModel)));
    }
    @GetMapping("/tradePay")
    public ModelAndView TradePayGet(Map map){
        TradeModel tradeModel = new TradeModel();
        tradeModel.setAppId("153429926277911");
        tradeModel.setAppKey("el9ztwDnmBFYMqmAvODnhsbMPVUuKg8D");
        tradeModel.setPayChannelType("13");
        map.put("tradeModel",tradeModel);
        return new ModelAndView("juhe/tradePay",map);
    }

    /**
     * 退款业务系统逻辑
     * @param request
     * @param response
     * @param refundModel
     * @return
     */

    @PostMapping("/refund")
    public ModelAndView RefundPost(HttpServletRequest request, HttpServletResponse response , RefundModel refundModel, Map map){
        RefundService refundService = new RefundService();
        refundModel.setUrl(EnumTransUtil.TransEnum(request.getParameter("URL"),request.getParameter("Service")));
        return new ModelAndView("common/result",InitMap(refundService.Refund(refundModel,request.getParameter("Service"))));
    }
    @GetMapping("/refund")
    public ModelAndView RefundGet(Map map){
        RefundModel refundModel = new RefundModel();
        refundModel.setAppKey("7yd2Y5qqhRKvjE36HxuFTU8bS1hr3Nxm");
        refundModel.setAppId("161059515751715");
        map.put("refundModel",refundModel);

    return new ModelAndView("juhe/refund");
    }

    /**
     * 小程序业务系统逻辑
     * @param request
     * @param response
     * @param weChatPayModel
     * @return
     */

    @PostMapping("/wechatPay")
    public ModelAndView WeChatPayPost(HttpServletRequest request, HttpServletResponse response , WeChatPayModel weChatPayModel,Map map){
        WeChatService weChatService = new WeChatService();
        weChatPayModel.setUrl(EnumTransUtil.TransEnum(request.getParameter("URL"),request.getParameter("Service")));
        return new ModelAndView("common/result",InitMap(weChatService.WeChatPay(weChatPayModel)));
    }
    @GetMapping("/wechatPay")
    public ModelAndView WeChatPayGet(Map map){
        map.put("wechatModel",new WeChatPayModel());
        return new ModelAndView("juhe/wechatPay",map);
    }

    /**
     * 监控业务系统逻辑
     * @param
     * @param
     * @param
     * @return
     */
    @GetMapping("/monitor")
    public ModelAndView MonitorGet(){
        return new ModelAndView("juhe/monitor/ipaynow-op");
    }

    /**
     * 通用封装
     * @param map
     * @return
     */
    public Map InitMap(Map map){
        map.put("request",map.get("request"));
        map.put("response",map.get("response"));
        map.put("img",map.get("img"));
        map.put("state",map.get("state"));
        return map;
    }

}

package com.juhe.my01.web.controller;

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
        if(request.getParameter("submit").equals("test")){
            activeModel.setUrl("https://dby.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            activeModel.setUrl("https://pay.ipaynow.cn/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            activeModel.setUrl("https://pay.ipaynow.cn/");
        }
        result = activeService.Active(activeModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state",result.get("state"));
        return new ModelAndView("common/result",map);
    }
    @GetMapping("/activePay")
    public ModelAndView ActivePayGet(Map<String,Object> map){
        ActiveModel activeModel = new ActiveModel();
        activeModel.setAppId("151142878420675");
        activeModel.setAppKey("qiMP78S5HHvHEmFUcrr9kOG4wngkrXos");
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
        if(request.getParameter("submit").equals("test")){
            barcodeModel.setUrl("https://dby.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            barcodeModel.setUrl("https://pay.ipaynow.cn/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            barcodeModel.setUrl("https://pay.ipaynow.cn/");
        }
        result = barcodeService.Barcode(barcodeModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state","");
        return new ModelAndView("common/result",map);
    }
    @GetMapping("/barcodePay")
    public ModelAndView BarcodePayGet(Map<String,Object> map){
        map.put("barcodeModel",new BarcodeModel());
        return new ModelAndView("juhe/barcodePay",map);
    }

    /**
     * 聚合码业务系统逻辑
     * @param request
     * @param response
     * @param mediaModel
     * @return
     */

    @PostMapping("/mediaPay")
    public ModelAndView MediaPayPost(HttpServletRequest request, HttpServletResponse response , MediaModel mediaModel , Map map){
        MediaService mediaService = new MediaService();
        if(request.getParameter("submit").equals("test")){
            mediaModel.setUrl("https://dby.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            mediaModel.setUrl("https://pay.ipaynow.cn/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            mediaModel.setUrl("https://pay.ipaynow.cn/");
        }
        result = mediaService.Media(mediaModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state",result.get("state"));
        return new ModelAndView("common/result",map);
    }
    @GetMapping("/mediaPay")
    public ModelAndView MediaPayGet(Map map){
        map.put("mediaModel",new MediaModel());
        return new ModelAndView("juhe/mediaPay",map);
    }

    /**
     * 卡牌业务系统逻辑
     * @param request
     * @param response
     * @param activeModel
     * @return
     */

    @PostMapping("/cardPay")
    public ModelAndView CardPayPost(HttpServletRequest request, HttpServletResponse response ,ActiveModel activeModel){
        return new ModelAndView("juhe/cardPay");
    }
    @GetMapping("/cardPay")
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
        if(request.getParameter("submit").equals("test")){
            tradeModel.setUrl("https://dby.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            tradeModel.setUrl("https://pay.ipaynow.cn/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            tradeModel.setUrl("https://pay.ipaynow.cn/");
        }
        result = tradeService.Trade(tradeModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state",result.get("state"));
        return new ModelAndView("common/result",map);
    }
    @GetMapping("/tradePay")
    public ModelAndView TradePayGet(Map map){
        map.put("tradeModel",new TradeModel());
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
        if(request.getParameter("submit").equals("test")){
            refundModel.setUrl("http://192.168.99.54:8790/refund_access/refundOrder");
        }else if (request.getParameter("submit").equals("pre")){
            refundModel.setUrl("https://pay.ipaynow.cn/api_release/refund/refundOrder");
        }else if(request.getParameter("submit").equals("line")){
            refundModel.setUrl("https://pay.ipaynow.cn/refund/refundOrder");
        }
        result = refundService.Refund(refundModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state","");
        return new ModelAndView("common/result",map);
    }
    @GetMapping("/refund")
    public ModelAndView RefundGet(Map map){
        map.put("refundModel",new RefundModel());
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
        if(request.getParameter("submit").equals("test")){
            weChatPayModel.setUrl("https://dby.ipaynow.cn/api/payment/");
        }else if (request.getParameter("submit").equals("pre")){
            weChatPayModel.setUrl("https://pay.ipaynow.cn/api_release/");
        }else if(request.getParameter("submit").equals("line")){
            weChatPayModel.setUrl("https://pay.ipaynow.cn/");
        }
        result = weChatService.WeChatPay(weChatPayModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state",result.get("state"));
        return new ModelAndView("common/result",map);
    }
    @GetMapping("/wechatPay")
    public ModelAndView WeChatPayGet(Map map){
        map.put("wechatModel",new WeChatPayModel());
        return new ModelAndView("juhe/wechatPay",map);
    }

    /**
     * 监控业务系统逻辑
     * @param request
     * @param response
     * @param activeModel
     * @return
     */

    @PostMapping("/monitor")
    public ModelAndView MonitorPost(HttpServletRequest request, HttpServletResponse response ,ActiveModel activeModel){
        return new ModelAndView("juhe/monitor");
    }
    @GetMapping("/monitor")
    public ModelAndView MonitorGet(){
        return new ModelAndView("juhe/monitor");
    }
}

package com.juhe.my01.web.service.juhe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.TradeWap;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import com.juhe.my01.web.model.juhe.TradeModel;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TradeService
 * Description:
 * date: 2020/9/2 10:38
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class TradeService {

    public Map<String, String> Trade(TradeModel tradeModel) {

        JSONObject ob = new JSONObject();
        JSONObject res = new JSONObject();

        //拼接请求参数Wp001
        JSONObject wp001 = TradeWap.Wap_WP001();
        wp001.put("canal", "WP001");//渠道
        wp001.put("url", tradeModel.getUrl());//请求地址
        wp001.put("appId", tradeModel.getAppId());//应用ID
        wp001.put("appKey", tradeModel.getAppKey());//应用Key
        wp001.put("payChannelType", tradeModel.getPayChannelType());
        wp001.put("mhtLimitPay", tradeModel.getMhtLimitPay());
        wp001.put("version", tradeModel.getVersion());
        wp001.put("mhtOrderAmt", tradeModel.getMhtOrderAmt());
        wp001.put("outputType", tradeModel.getOutputType());// 0\1\2\4\6
        wp001.put("mhtOrderName", tradeModel.getMhtOrderName());
        wp001.put("mhtOrderDetail", tradeModel.getMhtOrderDetail());
        wp001.put("mhtOrderTimeOut", tradeModel.getMhtOrderTimeOut());
        wp001.put("notifyUrl", tradeModel.getNotifyUrl());
        if(tradeModel.getPayChannelType().equals("13")
                &&tradeModel.getOutputType().equals("0")
                ||tradeModel.getOutputType().equals("1")
                ||tradeModel.getOutputType().equals("2")
                ||tradeModel.getOutputType().equals("4")
                ||tradeModel.getOutputType().equals("6")){
            wp001.put("consumerCreateIp", tradeModel.getConsumerCreateIp());
        }


        JSONObject mq002= TradeWap.Wap_MQ002();
        mq002.put("canal", "MQ002");//渠道
        mq002.put("url", tradeModel.getUrl());//请求地址
        mq002.put("version", tradeModel.getVersion());
        mq002.put("appId", tradeModel.getAppId());
        mq002.put("appKey", tradeModel.getAppKey());//应用Key
        mq002.put("mhtOrderNo", wp001.get("mhtOrderNo"));

        //判断新老版本号，进行MD验签操作
        if (tradeModel.getVersion().equals("1.0.0")) {
            ob = API_Version.RequestApi(wp001);
            res = API_Version.RequestApi(mq002);
        } else {
            ob = API_NoVer.RequestApi(wp001);
            res = API_NoVer.RequestApi(mq002);
        }
        //使用undecode解密返回报文
        System.out.println("WP001响应报文：：：：" + ob);
        System.out.println("WP001响应报文的body：：：：：：" + ob.getString("body"));
        String img = Undecode_util.res(ob.getString("body"));
        String response = Undecode_util.res(res.getString("body"));
        System.out.println("解密WP001响应报文："+img);
        System.out.println("解密MQ002响应报文："+response);
        //封装数据报文
        Map<String, String> result = new HashMap<>();
        result.put("request", JSON.toJSONString(wp001, true));
        result.put("response", JSON.toJSONString(SpiltSpringUtil.StringToJson(response),true));
        result.put("img", SpiltSpringUtil.JsonSys_resp(img));
        result.put("state", tradeModel.getOutputType());
//        System.out.println("result:" + result);
        return result;
    }


}

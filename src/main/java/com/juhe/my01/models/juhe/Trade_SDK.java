package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class Trade_SDK {
    public static JSONObject Model_SDK(){
        JSONObject js=new JSONObject();
        js.put("funcode","WP001");
        js.put("version","1.0.3");
        js.put("appId","");
        js.put("mhtOrderNo", GetNowTime.NowTime()+"Test");
        js.put("mhtSubMchId","");
        js.put("mhtOrderName","订单名称");
        js.put("mhtOrderType","05");
        js.put("mhtCurrencyType","156");
        js.put("mhtOrderAmt","1");
        js.put("mhtOrderDetail","订单详情");
        js.put("mhtOrderTimeOut","3600");
        js.put("mhtOrderStartTime",GetNowTime.NowTime());
        js.put("notifyUrl","http://mock-api.com/0ZzRmXKe.mock/qqq");
        js.put("mhtCharset","UTF-8");
        js.put("deviceType","01");
        js.put("payChannelType","");
        js.put("mhtReserved","保留域");
        js.put("mhtSubAppId","");
        js.put("mhtLimitPay","");//0：禁用信用卡1：允许使用信用卡
        js.put("consumerId","");
        js.put("consumerName","");
        js.put("mhtGoodsTag","");
        js.put("consumerCreateIp","");//用户端IP，微信时必填
        js.put("mhtSignType","MD5");//MD5
        js.put("mhtSignature","");
        return js;
    }

    public static JSONObject QuerySDK(){
        JSONObject js=new JSONObject();
        js.put("funcode","MQ002");
        js.put("version","");
        js.put("deviceType","01");
        js.put("appId","");
        js.put("mhtOrderNo","");
        js.put("mhtCharset","UTF-8");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        return js;
    }
}

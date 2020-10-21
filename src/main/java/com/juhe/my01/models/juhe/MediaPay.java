package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class MediaPay {
    public static JSONObject MediaPay_Var() {
        JSONObject js = new JSONObject();
        js.put("funcode","WP001");
        js.put("version","1.0.0");
        js.put("appId","");
        js.put("mhtOrderNo", GetNowTime.NowTime()+"Test");
        js.put("mhtSubMchId","");
        js.put("mhtOrderName","订单名称");
        js.put("mhtOrderType","01");
        js.put("mhtCurrencyType","156");
        js.put("mhtOrderAmt","1");
        js.put("mhtOrderDetail","订单详情");
        js.put("mhtOrderTimeOut","3600");
        js.put("mhtOrderStartTime",GetNowTime.NowTime());
        js.put("notifyUrl","http://mock-api.com/0ZzRmXKe.mock/qqq");
        js.put("frontNotifyUrl","");
        js.put("mhtCharset","UTF-8");
        js.put("deviceType","0600");
        js.put("payChannelType","");
        js.put("mhtReserved","保留域");
        js.put("outputType","");
        js.put("mhtSubAppId","");
        js.put("consumerId","");
        js.put("mhtLimitPay","");
        js.put("mhtGoodsTag","");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        return js;
    }
}

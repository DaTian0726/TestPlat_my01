package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class ActiveScan {

    public static JSONObject ActiveScanModel(){
        JSONObject js=new JSONObject();
        js.put("funcode","WP001");
        js.put("version","");
        js.put("appId","");
        js.put("mhtOrderNo",GetNowTime.NowTime()+"ActiveTest");
        js.put("mhtOrderName","mhtOrderName");
        js.put("mhtOrderType","01");
        js.put("mhtCurrencyType","156");
        js.put("mhtOrderAmt","1");
        js.put("mhtOrderDetail","mhtOrderDetail");
        js.put("mhtOrderTimeOut","3600");
        js.put("mhtOrderStartTime", GetNowTime.NowTime());
        js.put("notifyUrl","http://mock-api.com/dno4ooKX.mock/qqq");//
        js.put("frontNotifyUrl","http://mock-api.com/dno4ooKX.mock/qqq");
        js.put("mhtCharset","UTF-8");
        js.put("deviceType","08");//扫码支付
        js.put("payChannelType","");
        js.put("mhtReserved","mhtReserved");
        js.put("mhtSubAppId","");
        js.put("mhtGoodsTag","");
        js.put("mhtLimitPay","");
        js.put("outputType","");// 0 返回二维码  1 返回支付链接
        js.put("mhtSubMchId","");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        return js;
    }

    public static JSONObject QueryActive(){
        JSONObject js=new JSONObject();
        js.put("funcode","MQ002");
        js.put("version","1.0.0");
        js.put("deviceType","08");
        js.put("appId","");
        js.put("mhtOrderNo","");
        js.put("mhtCharset","UTF-8");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        return js;
    }
}

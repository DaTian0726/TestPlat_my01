package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class WeChatModel {

    /**
     * 查询接口数据封装MQ002 -- 小程序
     * @return
     */
    public static JSONObject QueryWx_Model(){
        JSONObject js = new JSONObject();
        js.put("funcode","MQ002");
        js.put("version","1.0.0");
        js.put("deviceType","14");
        js.put("appId","");
        js.put("mhtOrderNo","");
        js.put("mhtCharset","UTF-8");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        return js;
    }


    /**
     * 查询接口数据封装MQ002 -- 小程序
     * @return
     */
    public static JSONObject WcChat_applet(){
        JSONObject js = new JSONObject();
        js.put("funcode","WP001");
        js.put("version","1.0.0");
        js.put("appId","");
        js.put("mhtOrderNo", "Wx"+ GetNowTime.NowTime());
        js.put("mhtSubMchId","");
        js.put("mhtOrderName","ipaynow");
        js.put("mhtOrderType","05");//01为普通消费，05为代理消费
        js.put("mhtCurrencyType","156");
        js.put("mhtOrderAmt","1");
        js.put("oriMhtOrderAmt","1");
        js.put("discountAmt","0");
        js.put("mhtOrderDetail","mhtOrderDetail");
        js.put("mhtStoreId","");
        js.put("mhtOrderTimeOut","3600");
        js.put("mhtOrderStartTime",GetNowTime.NowTime());
        js.put("notifyUrl","http://mock-api.com/dno4ooKX.mock/qqq");
        js.put("frontNotifyUrl","http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");
        js.put("mhtCharset","UTF-8");
        js.put("deviceType","14");
        js.put("payChannelType","13");
        js.put("mhtReserved","mhtReserved666");
        js.put("outputType","1");
        js.put("mhtSubAppId","wx694abcd10bf94a26");
        js.put("consumerId","o0wwA0RsmX9AM_SZ8NBmdF9fNMl4");//o0wwA0RsmX9AM_SZ8NBmdF9fNMl4
        js.put("mhtLimitPay","");//0表示限制，1表示不限制
        js.put("mhtGoodsTag","");
        js.put("mhtSignType","RSA");//RSA
        js.put("mhtSignature","");
        return js;
    }
}

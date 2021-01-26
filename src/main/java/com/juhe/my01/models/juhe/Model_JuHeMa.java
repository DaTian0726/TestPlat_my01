package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class Model_JuHeMa {

    /**
     * WP001
     * @return
     */
    public static JSONObject JuHeMa_WP001(){
        JSONObject js=new JSONObject();
        js.put("funcode","WP001");
        js.put("version","1.0.0");
        js.put("appId","");
        js.put("mhtOrderNo", GetNowTime.NowTime()+"juhema");
        js.put("mhtSubMchId","");
        js.put("mhtOrderName","mhtOrderName");
        js.put("mhtOrderType","05");
        js.put("mhtCurrencyType","156");
        js.put("mhtOrderAmt","1");
        js.put("mhtOrderDetail","mhtOrderDetail");
        js.put("mhtOrderTimeOut","3600");
        js.put("mhtOrderStartTime",GetNowTime.NowTime());
        js.put("notifyUrl","http://mock-api.com/VnZ894zw.mock/payNotify");
        js.put("mhtCharset","UTF-8");
        js.put("deviceType","20");
        js.put("mhtReserved","mhtReserved");
        js.put("mhtLimitPay","");
        js.put("outputType","");
        js.put("mhtGoodsTag","");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        js.put("payChannelType","12");
        return js;
    }
    /**
     * MQ002
     * @return
     */
    public static JSONObject JuHeMa_MQ002(){
        JSONObject js=new JSONObject();
        js.put("funcode","MQ002");
        js.put("version","1.0.0");
        js.put("deviceType","20");
        js.put("appId","");
        js.put("mhtOrderNo","");
        js.put("mhtCharset","UTF-8");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        return js;
    }
}

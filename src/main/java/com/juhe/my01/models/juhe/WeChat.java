package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class WeChat {
    public  static JSONObject WeChatModel(){
    JSONObject js = new JSONObject();
    js.put("funcode","WP001");
    js.put("version","1.0.0");
    js.put("appId","");
    js.put("mhtOrderNo", GetNowTime.NowTime()+"wc");
    js.put("mhtSubMchId","");
    js.put("mhtOrderName","mhtOrderName");
    js.put("mhtOrderType","01");
    js.put("mhtCurrencyType","156");
    js.put("mhtOrderAmt","1");
    js.put("oriMhtOrderAmt","1");
    js.put("discountAmt","1");
    js.put("mhtOrderDetail","mhtOrderDetail");
    js.put("mhtStoreId","");
    js.put("mhtOrderTimeOut","3600");
    js.put("mhtOrderStartTime","");
    js.put("notifyUrl","");
    js.put("mhtCharset","");
    js.put("deviceType","");
    js.put("payChannelType","");
    js.put("mhtReserved","");
    js.put("outputType","");
    js.put("mhtSubAppId","");
    js.put("consumerId","");
    js.put("mhtLimitPay","");
    js.put("mhtGoodsTag","");
    js.put("mhtSignType","");
    js.put("mhtSignature","");


    return js;
    }


}

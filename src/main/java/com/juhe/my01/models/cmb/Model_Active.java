package com.juhe.my01.models.cmb;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class Model_Active {

    public static JSONObject Cmb_Ac_WP001(){
        JSONObject js=new JSONObject();
        js.put("funcode","WP001");
        js.put("version","1.0.0");
        js.put("appId","");
        js.put("mhtOrderNo", GetNowTime.NowTime()+"Test");
        js.put("mhtOrderName","订单名称");
        js.put("mhtOrderType","05");
        js.put("mhtCurrencyType","156");
        js.put("mhtOrderAmt","1");
        js.put("mhtOrderDetail","订单详情");
        js.put("mhtOrderTimeOut","3600");
        js.put("mhtOrderStartTime",GetNowTime.NowTime());
        js.put("notifyUrl","http://mock-api.com/dno4ooKX.mock/qqq");
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");
        js.put("mhtCharset","UTF-8");
        js.put("deviceType","08");
        js.put("payChannelType","");
        js.put("mhtReserved","保留域");
        js.put("mhtSubAppId","");
        js.put("mhtGoodsTag","");
        js.put("outputType","");
        js.put("mhtSubMchId","");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");

        return js;
    }
}

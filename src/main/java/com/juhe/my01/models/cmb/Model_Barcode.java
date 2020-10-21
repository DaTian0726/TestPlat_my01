package com.juhe.my01.models.cmb;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class Model_Barcode {
    public static JSONObject CMB_Bar(){
        JSONObject js=new JSONObject();
        js.put("funcode","WP001");
        js.put("version","1.0.0");
        js.put("appId","");
        js.put("mhtSubMchId","");
        js.put("mhtOrderNo", GetNowTime.NowTime()+"Test");
        js.put("channelAuthCode","");
        js.put("mhtOrderName","订单名称");
        js.put("mhtOrderType","05");
        js.put("mhtCurrencyType","156");
        js.put("mhtOrderAmt","1");
        js.put("mhtOrderDetail","订单详情");
        js.put("mhtOrderTimeOut","3600");
        js.put("mhtOrderStartTime",GetNowTime.NowTime());
        js.put("notifyUrl","");
        js.put("mhtCharset","UTF-8");
        js.put("deviceType","05");
        js.put("payChannelType","");
        js.put("terminalId","");
        js.put("batchId","");
        js.put("sysTraceId","");
        js.put("mhtGoodsTag","");
        js.put("mhtReserved","");
        js.put("mhtSubAppId","");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        js.put("longitude","");//经度
        js.put("latitude","");//纬度
        js.put("address","");//地址
        return js;
    }
}

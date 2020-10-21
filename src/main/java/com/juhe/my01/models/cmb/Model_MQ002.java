package com.juhe.my01.models.cmb;

import com.alibaba.fastjson.JSONObject;

public class Model_MQ002 {
    public static JSONObject TestMQ002() {
        JSONObject js = new JSONObject();
        js.put("funcode","MQ002");
        js.put("version","1.0.0");
        js.put("deviceType","");
        js.put("appId","");
        js.put("mhtOrderNo","");
        js.put("mhtCharset","UTF-8");
        js.put("mhtSignType","MD5");
        js.put("mhtSignature","");
        return js;
    }
}

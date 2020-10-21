package com.juhe.my01.models.cmb;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class Model_Refund {

    public static JSONObject TestRefund(){
        JSONObject js = new JSONObject();
        js.put("funcode","R001");
        js.put("version","");
        js.put("appId","");
        js.put("appKey","");
        js.put("mhtOrderNo","");
        js.put("mhtRefundNo",GetNowTime.NowTime()+"Refund");
        js.put("amount","1");
        js.put("reason","退款测试");
        js.put("mhtCharset","UTF-8");
        js.put("notifyUrl","");
        js.put("signType","MD5");
        js.put("mhtSignature","");
        return js;
    }

    public static JSONObject TestQueery() {
        JSONObject js = new JSONObject();
        js.put("funcode","Q001");
        js.put("appId","");
        js.put("mhtRefundNo","");
        js.put("mhtCharset","UTF-8");
        js.put("signType","MD5");
        js.put("mhtSignature","");
        return js;
    }
}

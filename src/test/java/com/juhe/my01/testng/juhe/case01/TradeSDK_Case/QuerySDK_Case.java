package com.juhe.my01.testng.juhe.case01.TradeSDK_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Trade_SDK;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class QuerySDK_Case {
    /**
     * 切换测试地址：
     * 预发布： https://pay.ipaynow.cn/api_release/
     * 生产： https://pay.ipaynow.cn/
     */
    private final String Test_URL = "https://pay.ipaynow.cn/";

    @Test
    public void Test01() {
        JSONObject js= Trade_SDK.QuerySDK();
        js.put("canal", "汇付天下-支付宝-生产");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("version","1.0.0");
        js.put("appId", "156819422676129");//应用ID
        js.put("appKey", "tl2nbpBcC50sCLHSJRzBPe1Ydbz3tzP8");//应用Key
        js.put("mhtOrderNo","20191022141515Test");
        JSONObject ob= API_Version.RequestApi(js);
        System.out.println("查询结果：——\n"+ Undecode_util.res(ob.toString()));
    }
}

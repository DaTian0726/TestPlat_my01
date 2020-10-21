package com.juhe.my01.testng.XunHuan;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Trade_SDK;
import com.juhe.my01.toapi.API_Version;
import org.testng.annotations.Test;

public class Test_XuanHaun {
    /**
     * 切换测试地址：
     * 预发布： https://pay.ipaynow.cn/api_release/
     * 生产： https://pay.ipaynow.cn/
     */
    public final String Test_URL="https://pay.ipaynow.cn/";
    @Test(invocationCount = 10,threadPoolSize =2 )
    public void Test01(){
        JSONObject js= Trade_SDK.Model_SDK();
        js.put("canal", "汇付天下-支付宝-生产");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", "156819422676129");//应用ID
        js.put("appKey", "tl2nbpBcC50sCLHSJRzBPe1Ydbz3tzP8");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "1");//0：禁用信用卡 1：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version","1.0.3");
        js.put("mhtOrderAmt","1");
        js.put("consumerId","");
        js.put("consumerName","");
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + res);
    }
}

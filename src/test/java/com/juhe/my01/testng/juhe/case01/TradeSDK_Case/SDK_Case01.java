package com.juhe.my01.testng.juhe.case01.TradeSDK_Case;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Trade_SDK;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class SDK_Case01 {
    /**
     * 切换测试地址：
     * 预发布： https://pay.ipaynow.cn/api_release/
     * 生产： https://pay.ipaynow.cn/
     */
    public final String Test_URL="https://pay.ipaynow.cn/";
//    public final String Test_URL="https://dby.ipaynow.cn/api/payment/";

    /**
     * 带版本号---支付宝（无不带版本号）----------SDK-H5支付
     * 1.禁用信用卡功能测试
     * 2.版本号测试  ----1.0.0/1.0.3
     * (invocationCount = 50,threadPoolSize =2)
     */
    @Test(invocationCount = 50,threadPoolSize = 1)
    public void Test01(){
        JSONObject js= Trade_SDK.Model_SDK();
        js.put("canal", "汇付天下-支付宝-生产");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", "156819422676129q");//应用ID
        js.put("appKey", "tl2nbpBcC50sCLHSJRzBPe1Ydbz3tzP8");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "1");//0：禁用信用卡 1：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version","1.0.3");
        js.put("mhtOrderAmt","10000000000");
        js.put("consumerId","");
        js.put("consumerName","");
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }

    /**
     * 带版本号---微信（无不带版本号）------SDK-小程序支付
     * 1.禁用信用卡功能测试
     * 2.版本号测试  ----1.0.0/1.0.3
     * 注：  SDK-H5支付，可返回支付链接，在手机上中可拉起支付
     *          SDK-小程序支付，返回内容 （暂无拉起手段）
     */
    @Test
    public void Test02(){
        JSONObject js= Trade_SDK.Model_SDK();
        js.put("canal", "信钛-微信-生产");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", "153364179531679");//应用ID
        js.put("appKey", "IinpIVLL23S0MJjvMZoIoBvdXiRoawBU");//应用Key
        js.put("payChannelType", "13");
        js.put("mhtLimitPay", "0");//0：禁用信用卡 1：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version","1.0.3");
        js.put("mhtSubAppId","wx392e53828b385e65");
        js.put("consumerCreateIp","60.253.242.122");//用户端IP，微信时必填
        JSONObject res = API_Version.RequestApi(js);

        System.out.println("请求结果：" + Undecode_util.res(JSON.toJSONString(res.getString("body"))));
    }

    /**
     * 带版本号---微信（无不带版本号）------SDK-小程序支付
     * 1.禁用信用卡功能测试
     * 2.版本号测试  ----1.0.0/1.0.3
     * 注：  SDK-H5支付，可返回支付链接，在手机上中可拉起支付
     *          SDK-小程序支付，返回内容 （暂无拉起手段）
     */
    @Test
    public void Test03(){
        JSONObject js= Trade_SDK.Model_SDK();
        js.put("canal", "官方-微信-生产");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", "153364179531679");//应用ID
        js.put("appKey", "IinpIVLL23S0MJjvMZoIoBvdXiRoawBU");//应用Key
        js.put("payChannelType", "13");
        js.put("mhtLimitPay", "0");//0：禁用信用卡 1：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version","1.0.3");
        js.put("mhtSubAppId","wx392e53828b385e65");
        js.put("consumerCreateIp","60.253.242.122");//用户端IP，微信时必填
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + res);
    }
}

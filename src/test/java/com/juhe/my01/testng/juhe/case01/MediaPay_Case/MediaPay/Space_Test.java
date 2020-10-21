package com.juhe.my01.testng.juhe.case01.MediaPay_Case.MediaPay;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.MediaPay;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import org.testng.annotations.Test;

public class Space_Test {


    /**
     * 生产环境测试地址      https://pay.ipaynow.cn/
     * 预发布环境测试地址    https://pay.ipaynow.cn/api_release/
     * 测试环境测试地址     https://dby.ipaynow.cn/api/payment/
     */
    private final String Test_URL="https://pay.ipaynow.cn/api_release/";
    private final String appId="154113053321091";
    private final String appKey="d2ZpGmAP8BIZIpuHSWNnlNAOuRZAA722";
//===================================================

    /**
     * 带版本号---1 模式
     */
    @Test
    public void Test_zfb_1() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + res.toString());
    }

    /**
     * 不带版本号---1 模式
     */
    @Test
    public void Test_zfb_1_noV() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "");//outputType=0时必填
        js.put("mhtLimitPay", "no_credit");// 默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        js.put("version", "");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + res.toString());
    }

    //===================================================
    //==================汇付天下--微信=======================
    /**
     * 带版本号---1 模式
     */
    @Test
    public void Test_wx_1() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "oxBhM0wVqGvbw0ZnCYIxr9u4V3tQ");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "wx99df53752bdf6df2");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + res);
    }
    /**
     * 不带版本号---1 模式
     */
    @Test
    public void Test_wx_1_noV() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "");//outputType=0时必填
        js.put("mhtLimitPay", "no_credit");// 默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        js.put("version", "");
        js.put("mhtSubOpenId", "oxBhM0wVqGvbw0ZnCYIxr9u4V3tQ");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "wx99df53752bdf6df2");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + res);
    }

}

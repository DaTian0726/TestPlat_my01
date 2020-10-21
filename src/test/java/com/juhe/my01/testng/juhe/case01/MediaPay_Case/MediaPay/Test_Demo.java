package com.juhe.my01.testng.juhe.case01.MediaPay_Case.MediaPay;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.MediaPay;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class Test_Demo {

    private final String Test_URL="https://dby.ipaynow.cn/api/payment/";
    /**
     * 带版本号
     * 1模式
     * 支付宝
     */
    @Test
    public void Test_zfb_1() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-支付宝-测试");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", "154271215265954");//应用ID
        js.put("appKey", "Huqog2MC661G202cnDJIsFetv3CpYt6h");//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
    /**
     * 带版本号
     * 1模式
     * 微信
     */
    @Test
    public void Test_wx_1() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "官方-微信");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", "154271215265954");//应用ID
        js.put("appKey", "Huqog2MC661G202cnDJIsFetv3CpYt6h");//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "oxBhM0wVqGvbw0ZnCYIxr9u4V3tQ");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "wx99df53752bdf6df2");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
}

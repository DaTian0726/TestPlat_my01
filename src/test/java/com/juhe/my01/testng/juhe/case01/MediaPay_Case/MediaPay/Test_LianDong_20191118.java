package com.juhe.my01.testng.juhe.case01.MediaPay_Case.MediaPay;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.MediaPay;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 公众号接入联动优势
 * 2019-11-18
 */
public class Test_LianDong_20191118 {
    /**
     * 生产环境测试地址      https://pay.ipaynow.cn/
     * 预发布环境测试地址    https://pay.ipaynow.cn/api_release/
     * 测试环境测试地址     https://dby.ipaynow.cn/api/payment/
     */
    private final String Test_URL = "https://pay.ipaynow.cn/";
    private final String appId = "156146374859918";
    private final String appKey = "AHxAHVuHQhldpUmR9VbMzrX0XXcXT6uD";

    //    ========================支付宝=============================
    @Test
    public void Test_1_V() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }

    @Test
    public void Test_1_NOV() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "");//  0：允许使用信用卡  默认禁用信用卡
        js.put("version", "");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }

    //    =======================微信=========================
    @Test
    public void Test_wx_1_V() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "oeMyBjm_NWi5LpSRKO40SsONY3YA");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "wx99df53752bdf6df2");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
    @Test
    public void Test_wx_1_NOV() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        js.put("version", "");
        js.put("mhtSubOpenId", "oeMyBjm_NWi5LpSRKO40SsONY3YA");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "wx99df53752bdf6df2");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
}

package com.juhe.my01.testng.juhe.case01.MediaPay_Case.MediaPay;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.MediaPay;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 公众号  1模式   新老版本
 * 全渠道回测交易
 */
public class Test_ALL {

    /**
     * 生产环境测试地址      https://pay.ipaynow.cn/
     * 预发布环境测试地址    https://pay.ipaynow.cn/api_release/
    * 测试环境测试地址     https://dby.ipaynow.cn/api/payment/
     */
    private final String Test_URL="https://pay.ipaynow.cn/";
    /**
     * 支付宝
     * 带版本号
     * 1模式
     */
    @Test(dataProvider = "mediapay_zfb",dataProviderClass = Test_Data.class,invocationCount = 20,threadPoolSize = 1)
    public void Test_zfb_1(Object[] objects) {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
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
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
    /**
     * 支付宝
     * 不带版本号
     * 1模式
     */
    @Test(dataProvider = "mediapay_zfb",dataProviderClass = Test_Data.class)
    public void Test_zfb_1_noV(Object[] objects) {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "");//outputType=0时必填
        js.put("mhtLimitPay", "no_credit");// 默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        js.put("version", "");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
    /**
     * 微信
     * 带版本号
     * 1模式
     */
    @Test(dataProvider = "mediapay_wx",dataProviderClass = Test_Data.class,invocationCount = 20,threadPoolSize = 1)
    public void Test_wx_1(Object[] objects) {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", objects[4]);//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", objects[3]);//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
    /**
     * 微信
     * 不带版本号
     * 1模式
     */
    @Test(dataProvider = "mediapay_wx",dataProviderClass = Test_Data.class)
    public void Test_wx_1_noV(Object[] objects) {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "");//outputType=0时必填
        js.put("mhtLimitPay", "no_credit");// 默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        js.put("version", "");
        js.put("mhtSubOpenId", objects[4]);//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", objects[3]);//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
}

package com.juhe.my01.testng.juhe.case01.MediaPay_Case.MediaPay;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.MediaPay;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;
/**
 * 公众号 0模式 使用方式为   页面 重定向到API ----->API重定向到支付宝 ------------->支付宝进行判断返回UTL
 * 使用接口请求是错误的方式
 */
public class MediaPay_Case01 {
    //===================================================
    //==================汇付天下--支付宝======================
    /**
     * 带版本号---1 模式
     * (invocationCount = 50,threadPoolSize =2)
     */
    @Test(invocationCount = 20,threadPoolSize = 1)
    public void TestHuiFu_zfb_1() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-支付宝-生产");//渠道
        js.put("url", "https://pay.ipaynow.cn/");//请求地址
        js.put("appId", "156817458081430");//应用ID
        js.put("appKey", "1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtOrderAmt","10000");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }

    /**
     * 不带版本号---1 模式
     */
    @Test
    public void TestHuiFu_zfb_1_noV() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-支付宝-生产");//渠道
        js.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        js.put("appId", "156817458081430");//应用ID
        js.put("appKey", "1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh");//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "1");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "");//outputType=0时必填
        js.put("mhtLimitPay", "no_credit");// 默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        js.put("version", "");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + res);
    }

    /**
     * 带版本号---0模式
     * 返回支付页面（只是请求到支付宝，具体是否成功 无法确定）
     */
    @Test
    public void TestHuiFu_zfb_0() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-支付宝-生产");//渠道
        js.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        js.put("appId", "156817458081430");//应用ID
        js.put("appKey", "1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh");//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "0");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + res);
    }

    /**
     * 不带版本号---0模式
     */
    @Test
    public void TestHuiFu_zfb_0_noV() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-支付宝-生产");//渠道
        js.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        js.put("appId", "156817458081430");//应用ID
        js.put("appKey", "1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh");//应用Key
        js.put("payChannelType", "12");
        js.put("outputType", "0");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "no_credit");// 默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        js.put("version", "");
        js.put("consumerId", "2088712676954977");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + res);
    }
    //===================================================
    //==================汇付天下--微信=======================
    /**
     * 带版本号---1 模式
     */
    @Test
    public void TestHuiFu_wx_1() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-微信-生产");//渠道
        js.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        js.put("appId", "156817458081430");//应用ID
        js.put("appKey", "1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh");//应用Key
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
    public void TestHuiFu_wx_1_noV() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-微信-生产");//渠道
        js.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        js.put("appId", "156817458081430");//应用ID
        js.put("appKey", "1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh");//应用Key
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
    /**
     * 带版本号---0模式
     */
    @Test
    public void TestHuiFu_wx_0() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-微信-生产");//渠道
        js.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        js.put("appId", "156817458081430");//应用ID
        js.put("appKey", "1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh");//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "0");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "1");// 1：禁用信用卡 0：允许使用信用卡  默认禁用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        js.put("version", "1.0.0");
        js.put("consumerId", "");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + res);
    }
    /**
     * 不带版本号---0模式
     */
    @Test
    public void TestHuiFu_wx_0_noV() {
        JSONObject js = MediaPay.MediaPay_Var();
        js.put("canal", "汇付天下-微信-生产");//渠道
        js.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        js.put("appId", "156817458081430");//应用ID
        js.put("appKey", "1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh");//应用Key
        js.put("payChannelType", "13");
        js.put("outputType", "0");//0 直接调起支付   1 返回支付凭证
        //0模式无须配置微信公众平台开发者id及支付授权目录，需通过前端通过表单形式进行数据提交，提交后直接拉起微信支付；
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        js.put("mhtLimitPay", "no_credit");// 默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        js.put("version", "");
        js.put("mhtSubOpenId", "");//outputType=1必填，值为用户关注公众号后的openid
        js.put("mhtSubAppId", "");//outputType=1且paychannelType=13时必传，值为微信公众平台的开发者ID
       JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + res.toString());
    }
}

package com.juhe.my01.testng.juhe.case01.TradeWap_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.TradeWap;
import com.juhe.my01.testng.duanyan.ResAssert;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 测试H5
 * 测试环境地址：    https://dby.ipaynow.cn/api/payment/
 * 预发布环境地址：  https://pay.ipaynow.cn/api_release/
 * 生产环境地址：    https://pay.ipaynow.cn/
 */
public class TradeWap_WP001 {
    private final  String Test_URL="https://pay.ipaynow.cn/";

    //#######################################################################
    // #######################汇付天下渠道测试###################################
    /**
     * 带版本号 --
     */
    @Test(invocationCount = 1,threadPoolSize = 1)
    public void Test01() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "汇付天下-支付宝-生产");//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", "148972242878838");//应用ID
        ob.put("appKey", "p1AJ0Bb7AwgBy3iPO1JjJsPspmXok8yz");//应用Key
        ob.put("payChannelType", "13");
        ob.put("mhtLimitPay", "1");//0：禁用信用卡    1：允许使用信用卡    默认 可使用信用卡（不传）
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        ob.put("version", "1.0.0");
        ob.put("mhtOrderAmt", "1");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
//        //进行断言
//        String duanyan = ResAssert.Duan(res);
//        System.out.println("断言结果：" + duanyan);
    }

    /**
     * 不带版本号
     */
    @Test
    public void Test02() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "汇付天下-支付宝-生产");//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", "156819459648279");//应用ID
        ob.put("appKey", "QmTw4yM9bgpQfUrV6A6fLSENCSSq78Tc");//应用Key
        ob.put("payChannelType", "12");
        ob.put("mhtLimitPay", "");  //默认为启用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        ob.put("version", "");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }
    //#######################################################################
    // ############################官方微信##############################
    /**
     * 带版本号 --
     */
    @Test(invocationCount = 1)
    public void Test1() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "微信-ISV-预发布");//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", "153364169308830");//应用ID   153364169308830
        ob.put("appKey", "UYko5ZEZHb9WrGL8Jws6Qr14kGkOBrxf");//应用Key   UYko5ZEZHb9WrGL8Jws6Qr14kGkOBrxf
        ob.put("payChannelType", "13");
        ob.put("mhtOrderAmt", "1");
        ob.put("consumerCreateIp", "60.253.242.122");  //paychanneltype=13且outputtype=0、1、5时必填
        ob.put("outputType", "1");//0模式 返回 支付网页  1模式返回支付报文
        ob.put("mhtLimitPay", "1");//0：禁用信用卡 1：允许使用信用卡  默认可使用信用卡
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }

    /**
     * 不带版本号
     */
    @Test
    public void Test2() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "微信-ISV-预发布");//渠道
        ob.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        ob.put("appId", "153429926277911");//应用ID
        ob.put("appKey", "el9ztwDnmBFYMqmAvODnhsbMPVUuKg8D");//应用Key
        ob.put("payChannelType", "13");
        ob.put("mhtLimitPay", "");  //默认为禁用        测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit   默认可使用信用类支付
        ob.put("deviceType", "06");

        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }
    //#######################################################################
    // ############################官方支付宝##############################
    /**
     * 带版本号 --
     */
    @Test
    public void ISV_zfb() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "ISV-支付宝-生产");//渠道
        ob.put("url", "https://dby.ipaynow.cn/api/payment/");//请求地址
        ob.put("appId", "148972242878838");//应用ID
        ob.put("appKey", "p1AJ0Bb7AwgBy3iPO1JjJsPspmXok8yz");//应用Key
        ob.put("payChannelType", "12");
        ob.put("outputType", "1");//0模式 返回 支付网页  1模式返回支付报文
        ob.put("mhtLimitPay", "");//0：禁用信用卡    1：允许使用信用卡    默认 可使用信用卡（不传）
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        ob.put("version", "1.0.0");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
//        //进行断言
//        String duanyan = ResAssert.Duan(res);
//        System.out.println("断言结果：" + duanyan);
    }

    /**
     * 不带版本号
     */
    @Test(invocationCount = 1,threadPoolSize =1)
    public void ISVZfb() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "ISV-支付宝-生产");//渠道
        ob.put("url", "https://dby.ipaynow.cn/api/payment/");//请求地址
        ob.put("appId", "148972242878838");//应用ID
        ob.put("appKey", "p1AJ0Bb7AwgBy3iPO1JjJsPspmXok8yz");//应用Key
        ob.put("payChannelType", "12");
        ob.put("mhtOrderAmt","1");
        ob.put("mhtLimitPay", "");  //默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        ob.put("version", "");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }

    //#######################################################################
    // ############################河北银商-支付宝##############################
    /**
     * 带版本号 --
     */
    @Test
    public void TestHeBei_zfb() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "河北银商-支付宝-生产");//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", "156586309973453");//应用ID
        ob.put("appKey", "m2OcycfJqaZHJhPH7il8dcg8o9bpO6bn");//应用Key
        ob.put("payChannelType", "12");
        ob.put("mhtLimitPay", "1");//0：禁用信用卡    1：允许使用信用卡    默认 可使用信用卡（不传）
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        ob.put("version", "1.0.0");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + res);
//        //进行断言
//        String duanyan = ResAssert.Duan(res);
//        System.out.println("断言结果：" + duanyan);
    }

    /**
     * 不带版本号
     */
    @Test
    public void TestHeBei() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "河北银商-支付宝-生产");//渠道
        ob.put("url", "https://pay.ipaynow.cn/api_release/");//请求地址
        ob.put("appId", "156586309973453");//应用ID
        ob.put("appKey", "m2OcycfJqaZHJhPH7il8dcg8o9bpO6bn");//应用Key
        ob.put("payChannelType", "12");
        ob.put("mhtLimitPay", "no_credit");  //默认为禁用  测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        ob.put("version", "");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }
}

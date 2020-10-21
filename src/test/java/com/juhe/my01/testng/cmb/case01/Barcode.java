package com.juhe.my01.testng.cmb.case01;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.cmb.Model_Barcode;
import com.juhe.my01.models.cmb.Model_MQ002;
import com.juhe.my01.testng.duanyan.ResAssert;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import org.testng.annotations.Test;

public class Barcode {

    @Test
    public void Barcode_WP001_wx_01(){
        JSONObject ob = Model_Barcode.CMB_Bar();
        ob.put("canal", "测试-网联-微信");//渠道
        ob.put("url", "https://cmb-test-payapi.ipaynow.cn/api/payment/");//请求地址   api_release/
        ob.put("appId", "153897045119581");//应用ID
        ob.put("appKey", "m4KEdSCZoGTtuj1SHsOOdm01gO2EJPSO");//应用Key
        ob.put("channelAuthCode", "135243137218044304");//支付码
        ob.put("payChannelType", "13");

        String Key=ob.getString("appKey");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + res);
//        //进行验签
//        String yan= TestSign.CheckSignMD5_Version(res,Key);
//        System.out.println("\n验签结果："+yan);
        //进行断言
//        String duanyan = ResAssert.Duan(res);
//        System.out.println("断言结果：" + duanyan);
    }

    @Test
    public void Barcode_WP001_zfb_01(){
        JSONObject ob = Model_Barcode.CMB_Bar();
        ob.put("canal", "测试-网联-支付宝");//渠道
        ob.put("url", "https://cmb-test-payapi.ipaynow.cn/api/payment/");//请求地址   api_release/
        ob.put("appId", "153897045119581");//应用ID
        ob.put("appKey", "m4KEdSCZoGTtuj1SHsOOdm01gO2EJPSO");//应用Key
        ob.put("channelAuthCode", "288006589342881350");//支付码
        ob.put("payChannelType", "12");

        String Key=ob.getString("appKey");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + res);
//        //进行验签
//        String yan= TestSign.CheckSignMD5_Version(res,Key);
//        System.out.println("\n验签结果："+yan);
//        //进行断言
//        String duanyan = ResAssert.Duan(res);
//        System.out.println("断言结果：" + duanyan);
    }


    /**
     * 带版本号
     * 交易查询接口
     */
    @Test
    public void MQ002_01(){
        JSONObject ob = Model_MQ002.TestMQ002();
        ob.put("url", "https://ipaynow.acquire.cmbchina.com/api_release/");//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("deviceType", "05");
        ob.put("mhtOrderNo","20191009141325Test");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }

    /**
     * 不带版本号
     * 交易查询接口
     */
    @Test
    public void MQ002_02(){
        JSONObject ob = Model_MQ002.TestMQ002();
        ob.put("url", "https://ipaynow.acquire.cmbchina.com/api_release/");//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("deviceType", "05");
        ob.put("mhtOrderNo","20191009141325Test");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("------------"+ob.getString("appKey"));
        System.out.println("请求结果：" + res);
    }
}

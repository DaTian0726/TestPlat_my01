package com.juhe.my01.testng.juhe.case01.ActiceScan_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.ActiveScan;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 *  * 测试环境地址：https://dby.ipaynow.cn/api/payment/
 *  * 生产环境测试地址：  https://pay.ipaynow.cn/
 *  * 预发布环境地址： https://pay.ipaynow.cn/api_release/
 */
public class TestCase_ALL {
    private final String Test_Url="https://pay.ipaynow.cn/api_release/";

    /**
     * 测试主扫
     * 主扫 -带 版本号 1模式
     * @param objects
     */
    @Test(dataProvider = "AllCanal",dataProviderClass = TestCase_Data.class)
    public void Test01(Object[] objects){
        JSONObject js= ActiveScan.ActiveScanModel();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
        js.put("payChannelType",objects[3]);
        js.put("mhtLimitPay","");
        js.put("version","1.0.0");
        js.put("outputType","1");// 0 返回二维码  1 返回支付链接
        JSONObject ob= API_Version.RequestApi(js);
        System.out.println("返回结果----\n"+ Undecode_util.res(ob.getString("body")));
    }

    /**
     * 测试主扫
     * 主扫 -带版本号 0模式
     * @param objects
     */
    @Test(dataProvider = "AllCanal",dataProviderClass = TestCase_Data.class)
    public void Test02(Object[] objects){
        JSONObject js= ActiveScan.ActiveScanModel();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
        js.put("payChannelType",objects[3]);
        js.put("mhtLimitPay","");
        js.put("version","1.0.0");
        js.put("outputType","0");// 0 返回二维码  1 返回支付链接
        JSONObject ob= API_Version.RequestApi(js);
        System.out.println("返回结果----\n"+ Undecode_util.res(ob.getString("body")));
    }
    /**
     * 测试主扫
     * 主扫 -不带版本号 1模式
     * @param objects
     */
    @Test(dataProvider = "AllCanal",dataProviderClass = TestCase_Data.class)
    public void Test03(Object[] objects){
        JSONObject js= ActiveScan.ActiveScanModel();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
        js.put("payChannelType",objects[3]);
        js.put("mhtLimitPay","");
        js.put("version","");
        js.put("outputType","1");// 0 返回二维码  1 返回支付链接
        JSONObject ob= API_NoVer.RequestApi(js);
        System.out.println("返回结果----\n"+ Undecode_util.res(ob.getString("body")));
    }
    /**
     * 测试主扫
     * 主扫 -不带版本号 0模式
     * @param objects
     */
    @Test(dataProvider = "AllCanal",dataProviderClass = TestCase_Data.class)
    public void Test04(Object[] objects){
        JSONObject js= ActiveScan.ActiveScanModel();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
        js.put("payChannelType",objects[3]);
        js.put("mhtLimitPay","");
        js.put("version","");
        js.put("outputType","0");// 0 返回二维码  1 返回支付链接
        js.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");//outputType=0时必填
        JSONObject ob= API_NoVer.RequestApi(js);
        System.out.println("返回结果----\n"+ Undecode_util.res(ob.getString("body")));
    }
}

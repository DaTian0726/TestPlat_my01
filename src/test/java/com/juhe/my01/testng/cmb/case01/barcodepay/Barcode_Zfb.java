package com.juhe.my01.testng.cmb.case01.barcodepay;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.cmb.Model_Barcode;
import com.juhe.my01.testng.duanyan.ResAssert;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 测试网联支付宝-
 * 测试环境地址：      https://ipaynow.acquire.cmbchina.com/
 * 预发布环境地址：  https://ipaynow.acquire.cmbchina.com/api_release/
 * 生产环境地址：     https://cmb-test-payapi.ipaynow.cn/api/payment/
 */
public class Barcode_Zfb {
    public final String Test_URL="https://ipaynow.acquire.cmbchina.com/";
    /**
     * 带版本号   正常下单支付
     */
    @Test
    public void Barcode_WP001_zfb_01() {
        JSONObject ob = Model_Barcode.CMB_Bar();
        ob.put("canal", "测试-网联-支付宝");//渠道
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "156765443950942");//应用ID
        ob.put("appKey", "03QGYANujoaLriRuJMV5qBDzSxCUzJmq");//应用Key
        ob.put("channelAuthCode", "289371442733456163");//支付码
        ob.put("payChannelType", "12");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + res);
//        //进行验签
//        String yan= TestSign.CheckSignMD5_Version(res,Key);
//        System.out.println("\n验签结果："+yan);
        //进行断言
//        String duanyan = ResAssert.Duan(res);
//        System.out.println("断言结果：" + duanyan);
    }

    /**
     * 带版本号   带经纬度的下单支付
     */
    @Test
    public void Barcode_WP001_zfb_02() {
        JSONObject ob = Model_Barcode.CMB_Bar();
        ob.put("canal", "测试-网联-支付宝");//渠道
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("channelAuthCode", "283674954910348197");//支付码
        ob.put("payChannelType", "12");
        ob.put("longitude", "东经E88°33′35.31″");//经度
        ob.put("latitude", "北纬N43°46′29.02″");//纬度
        ob.put("address", "新疆维吾尔自治区乌鲁木齐市达坂城区阿克苏乡");//地址
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
    /**
     * 不带版本号   下单支付
     */
    @Test
    public void Barcode_WP001_zfb_03() {
        JSONObject ob = Model_Barcode.CMB_Bar();
        ob.put("canal", "测试-网联-支付宝");//渠道
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("channelAuthCode", "289556590892936351");//支付码
        ob.put("payChannelType", "12");
        ob.put("longitude", "");//经度
        ob.put("latitude", "");//纬度
        ob.put("address", "");//地址
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }
    /**
     * 不带版本号    带经纬度的下单支付
     * 注：------------不带版本号 不支持带经纬度的下单支付
     */
    @Test
    public void Barcode_WP001_zfb_04() {
        JSONObject ob = Model_Barcode.CMB_Bar();
        ob.put("canal", "测试-网联-支付宝");//渠道
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("channelAuthCode", "288044369380885138");//支付码
        ob.put("payChannelType", "12");
        ob.put("longitude", "东经E88°33′35.31″");//经度
        ob.put("latitude", "北纬N43°46′29.02″");//纬度
        ob.put("address", "新疆维吾尔自治区乌鲁木齐市达坂城区阿克苏乡");//地址
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }
    /**
     * 带版本号   正常下单支付
     * 支持信用类支付（限制条件：1. 交易下单传入mhtLimitPay进行限制  2.应用中心限制）
     * 信用类支付为    花呗+++信用卡（两种类型）
     */
    @Test
    public void Barcode_WP001_zfb_05() {
        JSONObject ob = Model_Barcode.CMB_Bar();
        ob.put("canal", "测试-网联-微信");//渠道
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("channelAuthCode", "281845812181165283");//支付码
        ob.put("payChannelType", "12");
        ob.put("mhtLimitPay","1");//被扫改字段 非必传 默认不支持     1为不支持  0支持  {用例：   1.不传mhtLimitPay      2.mhtLimitPay为0     3.mhtLimitPay为1}
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }
    /**
     * 不带版本号   正常下单支付
     * 支持信用类支付
     * 信用类支付为    花呗+++信用卡（两种类型）
     */
    @Test
    public void Barcode_WP001_zfb_06() {
        JSONObject ob = Model_Barcode.CMB_Bar();
        ob.put("canal", "测试-网联-微信");//渠道
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("channelAuthCode", "135152072901791778");//支付码
        ob.put("payChannelType", "12");
        ob.put("mhtLimitPay","");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }
}

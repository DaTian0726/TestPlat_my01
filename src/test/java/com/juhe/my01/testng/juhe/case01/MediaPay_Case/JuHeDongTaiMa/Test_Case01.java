package com.juhe.my01.testng.juhe.case01.MediaPay_Case.JuHeDongTaiMa;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Model_JuHeMa;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class Test_Case01 {

    /**
     * 测试环境地址：   https://dby.ipaynow.cn/api/payment/
     * 预发布环境地址： https://pay.ipaynow.cn/api_release/
     * 生产环境地址：   https://pay.ipaynow.cn/
     */
//    private final String Test_URL = "https://pay.ipaynow.cn/";
    private final String Test_URL = "https://ipaynow.acquire.cmbchina.com/";

    /**
     * 自动化
     * @param objects
     * 返回链接及二维码无法拉起支付    订单已失效
     */
    @Test(dataProvider = "juhema",dataProviderClass = JuHeMa_Data.class)
    public void Test01(Object[] objects) {
        JSONObject js = Model_JuHeMa.JuHeMa_WP001();
        js.put("canal", objects[0]);//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", objects[1]);//应用ID
        js.put("appKey", objects[2]);//应用Key
        js.put("version","1.0.0");
        js.put("mhtLimitPay",objects[3]);//0不限制信用卡  1禁用信用卡  默认为0，不限制信用卡
        js.put("outputType",objects[4]); //0 返回二维码串1 返回支付链接 默认为1，返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果为——\n" + Undecode_util.res(ob.toString()));
    }

    @Test(invocationCount = 1,threadPoolSize = 1)
    public void Test001() {
        JSONObject js = Model_JuHeMa.JuHeMa_WP001();
        js.put("canal", "汇付- 聚合码花呗分期");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", "156506034823529");//应用ID
        js.put("appKey", "Id2dkbEnAxh8powzRwJNkrYMWA7U7EPs");//应用Key
        js.put("version","1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("mhtLimitPay","");//0不限制信用卡  1禁用信用卡  默认为0，不限制信用卡
        js.put("outputType","0"); //0 返回二维码串1 返回支付链接 默认为1，返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果为——\n" + Undecode_util.res(ob.getString("body")));
    }

    @Test
    public void MQ001_Test(){
        JSONObject js = Model_JuHeMa.JuHeMa_MQ002();
        js.put("canal", "联动");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", "157888525409429");//应用ID
        js.put("appKey", "obVkzrHQYBEvFAmInRe5zunmXBCnUoZm");//应用Key
        js.put("version","1.0.0");
        js.put("mhtOrderNo","20200729135159juhema");
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果为——\n" + Undecode_util.res(ob.toString()));
    }
}

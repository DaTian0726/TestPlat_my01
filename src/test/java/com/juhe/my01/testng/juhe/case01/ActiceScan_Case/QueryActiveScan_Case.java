package com.juhe.my01.testng.juhe.case01.ActiceScan_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.ActiveScan;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.TestSign;
import com.juhe.my01.utils.TestSign_TestQuery;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;
/**
 * 主扫查询接口
 * 测试环境地址：https://dby.ipaynow.cn/api/payment/
 * 生产环境测试地址：  https://pay.ipaynow.cn/
 * 预发布环境地址： https://pay.ipaynow.cn/api_release/
 */
public class QueryActiveScan_Case {
    private final String Test_Url="https://pay.ipaynow.cn/";
    private final String appKey = "pXv0IX956mH3ms5mbXQuZc3GGDkQZMUf";
    @Test
    public void Test01() {
        JSONObject js = ActiveScan.QueryActive();
        js.put("canal", "支付宝ISV-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("version", "1.0.0");
        js.put("appId", "155921496682171");
        js.put("appKey", "suQn1qiUvJFwjRwcOKYb9ToAUgSu10BH");//应用Key
        js.put("mhtOrderNo", "20191022140327ActiveTest");
        JSONObject ob= API_Version.RequestApi(js);
        System.out.println("查询结果：——\n"+ ob.getString("body"));
        //对返回结果进行验签
        String flag= TestSign.CheckSignMD5(ob.getString("body"),appKey);
        System.out.println(flag);
        //将返回结果按接口文档重新赋值 进行验签
        String flag2= TestSign_TestQuery.CheckSignMD5(ob.getString("body"),appKey,js.getString("deviceType"));
        System.out.println(flag2);
    }
}

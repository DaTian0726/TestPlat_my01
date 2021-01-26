package com.juhe.my01.testng.juhe.case01.ActiceScan_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.ActiveScan;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.TestSign;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 主扫测试
 * 测试环境地址：https://dby.ipaynow.cn/api/payment/
 * 生产环境测试地址：  https://pay.ipaynow.cn/
 * 预发布环境地址： https://pay.ipaynow.cn/api_release/
 */
public class ActiveScan_TestCase2 {

    private final String Test_Url = "https://dby.ipaynow.cn/api/payment/";
//        private final String appId = "154867341558958";
//    private final String appKey = "zpfqk8rUsiCPCbgfc7173M0PssV8BZIQ";

    @Test(invocationCount = 1)
    public void Test01() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "支付宝ISV-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "155011680219391");//应用ID
        js.put("appKey", "NrR3GtknOXKFBb6oOxXYeH6uwjLJ4drl");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
//        对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"qiMP78S5HHvHEmFUcrr9kOG4wngkrXos");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }

    @Test(invocationCount = 1)
    public void Test02() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "财付通-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "151142878420675");//应用ID
        js.put("appKey", "qiMP78S5HHvHEmFUcrr9kOG4wngkrXos");//应用Key
        js.put("payChannelType", "13");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
       JSONObject ob = API_Version.RequestApi(js);
       System.out.println("返回结果----\n" + ob.getString("body"));
       //对返回结果进行验签
       String flag = TestSign.CheckSignMD5(ob.getString("body"),"qiMP78S5HHvHEmFUcrr9kOG4wngkrXos");
       System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
    //@Test
    public void Test03() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "易宝-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "155921496682171");//应用ID
        js.put("appKey", "suQn1qiUvJFwjRwcOKYb9ToAUgSu10BH");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"suQn1qiUvJFwjRwcOKYb9ToAUgSu10BH");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
//    @Test
    public void Test04() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "易宝-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "155921496682171");//应用ID
        js.put("appKey", "suQn1qiUvJFwjRwcOKYb9ToAUgSu10BH");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"suQn1qiUvJFwjRwcOKYb9ToAUgSu10BH");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
    @Test
    public void Test05() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "随行付-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "154831563347656");//应用ID
        js.put("appKey", "pXv0IX956mH3ms5mbXQuZc3GGDkQZMUf");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"pXv0IX956mH3ms5mbXQuZc3GGDkQZMUf");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
  @Test
    public void Test06() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "随行付-微信");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "154831563347656");//应用ID
        js.put("appKey", "pXv0IX956mH3ms5mbXQuZc3GGDkQZMUf");//应用Key
        js.put("payChannelType", "13");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"pXv0IX956mH3ms5mbXQuZc3GGDkQZMUf");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
    @Test
    public void Test13() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "随行付-银联");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "154831563347656");//应用ID
        js.put("appKey", "pXv0IX956mH3ms5mbXQuZc3GGDkQZMUf");//应用Key
        js.put("payChannelType", "27");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"pXv0IX956mH3ms5mbXQuZc3GGDkQZMUf");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
    @Test
    public void Test07() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "联动优势-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "155011680219391");//应用ID
        js.put("appKey", "NrR3GtknOXKFBb6oOxXYeH6uwjLJ4drl");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"HtW4hrNsz3VEaA6kcggSyrffe4zguokL");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
   @Test
    public void Test08() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "网商-支付宝");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "155212752507588");//应用ID
        js.put("appKey", "4icNXyfTuohQ4xjQY3x60oqVHj96Lk8F");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
       JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"BsE9OVgpzh8qnIUa1byeXyN3zs5DayAZ");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
    @Test
    public void Test09() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "汇付-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "155212752507588");//应用ID
        js.put("appKey", "4icNXyfTuohQ4xjQY3x60oqVHj96Lk8F");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"hr4wPSqDJHymrHaInYBn4iX9Ut4vwXwz");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
//   @Test
    public void Test10() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "汇付-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "156817447672951");//应用ID
        js.put("appKey", "hr4wPSqDJHymrHaInYBn4iX9Ut4vwXwz");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"hr4wPSqDJHymrHaInYBn4iX9Ut4vwXwz");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
    @Test
    public void Test11() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "招行-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "155859013856734");//应用ID
        js.put("appKey", "9GFNXrv3p99ppu6tHicLsUmI1HvAFAyD");//应用Key
        js.put("payChannelType", "27");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"1XEOzNLN0bXUwg87GG7RBUkaYdMPdBfi");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
    @Test
    public void Test12() {
        JSONObject js = ActiveScan.ActiveScanModel();
        js.put("canal", "招行-测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", "157888520476750");//应用ID
        js.put("appKey", "1XEOzNLN0bXUwg87GG7RBUkaYdMPdBfi");//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);
        System.out.println("返回结果----\n" + ob.getString("body"));
        //对返回结果进行验签
        String flag = TestSign.CheckSignMD5(ob.getString("body"),"1XEOzNLN0bXUwg87GG7RBUkaYdMPdBfi");
        System.out.println(flag);

        //对结果重新赋值，进行验签
//        String flag2 = TestSIgn_Test.CheckSignMD5(ob.getString("body"),appKey,ob.getString("deviceType"));
//        System.out.println(flag2);
    }
}

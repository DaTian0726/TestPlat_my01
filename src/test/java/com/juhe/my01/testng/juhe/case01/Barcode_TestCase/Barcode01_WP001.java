package com.juhe.my01.testng.juhe.case01.Barcode_TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Barcode;
import com.juhe.my01.testng.juhe.data.BarcodeData;
import com.juhe.my01.testng.duanyan.ResAssert;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.TestSign;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 异常用例：
 *  1. payChannelType为12，支付宝，使用微信的支付码支付
 *  2. payChannelType为13，微信，使用支付宝的支付码支付
 */
public class Barcode01_WP001 {

    @Test(dataProvider = "BarcodeAll_P", dataProviderClass = BarcodeData.class)
    public void TestAll(JSONObject ob) {
//        JSONObject object= Barcode.object();
//        String res= API_Version.RequestApi(object);
//        System.out.println("请求结果："+res);
        System.out.println(ob.toString());
    }

    /**
     * 被扫
     * 测试环境地址     https://dby.ipaynow.cn/api/payment/
     * 预发布环境地址   https://pay.ipaynow.cn/api_release/
     * 生产环境地址     https://pay.ipaynow.cn/
     */
    private final String Test_URL="https://pay.ipaynow.cn/";

    /**
     * 带版本号
     * 带通知地址
     * (invocationCount = 50,threadPoolSize = 1)
     */
    @Test(invocationCount = 1)
    public void Test01() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", "随行付-微信-生产");//渠道
        ob.put("url", "https://tls-pay.ipaynow.cn/api_release/");//请求地址
        ob.put("appId", "159844431675813");//应用ID
        ob.put("appKey", "Mw6sulhJ3amQRwwqXfVn0KsKZ3Shvdi4");//应用Key
        ob.put("channelAuthCode", "134609738467718887" +
                        "" +
                        ""
                );//支付码
        ob.put("payChannelType", "13");
        ob.put("notifyUrl", "http://mock-api.com/dno4ooKX.mock/qqq");//
        ob.put("version", "1.0.0");
        ob.put("mhtLimitPay", "");//
        ob.put("mhtOrderAmt", "1");
        // 测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        JSONObject res = API_Version.RequestApi(ob);
//        System.out.println(res.toJSONString());

        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
//        //进行断言
//        String duanyan = ResAssert.Duan(res);
//        System.out.println("断言结果：" + duanyan);
    }

    /**
     * 带版本号
     * 不带通知地址
     */
    @Test(invocationCount = 1)
    public void Test02() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", "招总行-支付宝-生产");//渠道
//        ob.put("url", Test_URL);//请求地址
        ob.put("appId", "156091321622013");//应用ID
        ob.put("appKey", "86JdCekIKGu2oan1qJLfxb9EbLP6sE0s");//应用Key
        ob.put("channelAuthCode", "2821937136715986041" +
                "" +
                "");//支付码
        ob.put("payChannelType", "13");
        ob.put("version", "1.0.0");
        ob.put("notifyUrl", "http://mock-api.com/dno4ooKX.mock/qqq");//http://mock-api.com/dno4ooKX.mock/qqq
        ob.put("mhtLimitPay", "");//
        ob.put("mhtOrderAmt", "1");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }

    @Test
    public void Test03() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", "官方-微信-生产");//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", "155013525666136");//应用ID
        ob.put("appKey", "FUbQ2mZs6CEpbYSzzQeSVD487HeCgV0U");//应用Key
        ob.put("channelAuthCode", "134681263424429054" +
                "" +
                "");//支付码
        ob.put("payChannelType", "13");

        String Key = ob.getString("appKey");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }

    /**
     * 不带版本号
     */
    @Test
    public void Test04() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", "汇付");//渠道
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "156817450336917");//应用ID
        ob.put("appKey", "PG8PvI8He8rlmz8ACyvBi17ekjtRPIyQ");//应用Key
        ob.put("channelAuthCode", "135177135556366000" +
                "" +
                "");//支付码
        ob.put("payChannelType", "13");
        ob.put("notifyUrl", "");
        ob.put("mhtLimitPay", "no_credit");//
        // 测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        String Key = ob.getString("appKey");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + JSON.toJSONString(res,true));
    }


    /**
     * 测试环境 带版本号
     */
    @Test
    public void Test001() {
        JSONObject ob = Barcode.WP001Vars();

        ob.put("canal", "联动新平台-支付宝-测试");//渠道
        ob.put("url", "https://dby.ipaynow.cn/api/payment/");//请求地址
        ob.put("appId", "156134538804645");//应用ID
        ob.put("appKey", "rXuFW3RjJ4ppUSE0ItFcGXuo0tB8wM1D");//应用Key
        ob.put("channelAuthCode", "134783909140033903" +
                "");//支付码
        ob.put("payChannelType", "13");
        ob.put("notifyUrl", "http://mock-api.com/dno4ooKX.mock/qqq");//http://mock-api.com/dno4ooKX.mock/qqq
        ob.put("mhtLimitPay", "");//
        ob.put("mhtOrderAmt","1");
        String Key = ob.getString("appKey");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(JSONObject.toJSONString(res)));
    }

    /**
     * 测试环境 不带版本号
     */
    @Test(invocationCount = 10)
    public void Test002() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", "官方-微信-测试");//渠道
        ob.put("url", "https://dby.ipaynow.cn/api/payment/");//请求地址
        ob.put("appId", "156134538804645");//应用ID
        ob.put("appKey", "rXuFW3RjJ4ppUSE0ItFcGXuo0tB8wM1D");//应用Key
        ob.put("channelAuthCode",
                "135066907734697333");//支付码
        ob.put("payChannelType", "13");
        ob.put("mhtOrderAmt","1");
        String Key = ob.getString("appKey");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(JSONObject.toJSONString(res)));
    }
}

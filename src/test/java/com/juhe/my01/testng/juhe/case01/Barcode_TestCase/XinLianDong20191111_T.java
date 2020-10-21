package com.juhe.my01.testng.juhe.case01.Barcode_TestCase;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Barcode;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class XinLianDong20191111_T {

    /**
     * 被扫
     * 测试环境地址     https://dby.ipaynow.cn/api/payment/
     * 预发布环境地址   https://pay.ipaynow.cn/api_release/
     * 生产环境地址     https://pay.ipaynow.cn/
     */
    private final String Test_URL="https://pay.ipaynow.cn/";

    private final String appId="156146164420827";
    private final String appKey="lfzwMygl9cpQP98CVLU5e0U0GvILbfsY";

    /**
     * TestCase
     * 1.带版本号--微信/支付宝
     * 2.带版本号--禁用信用卡
     * 3.带版本号--大额
     *
     *
     */
    @Test
    public void Test01() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", "Test");//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", appId);//应用ID
        ob.put("appKey", appKey);//应用Key
        ob.put("channelAuthCode", "134782930377551707" +
                "" );//支付码
        ob.put("payChannelType", "13");
        ob.put("notifyUrl", "");
        ob.put("version", "1.0.0");
        ob.put("mhtLimitPay", "1");//
        ob.put("mhtOrderAmt", "1");
        // 测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }

    @Test
    public void Test002() {
        JSONObject js = Barcode.MQ002Vars();
        js.put("canal", "TEST");//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("mhtOrderNo", "20191114174248Test");
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }

    /**
     * 不带版本号
     */
    @Test
    public void Test02() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", "汇付");//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", appId);//应用ID
        ob.put("appKey", appKey);//应用Key
        ob.put("channelAuthCode", "134660806947401756");//支付码
        ob.put("payChannelType", "13");
        ob.put("notifyUrl", "");
        ob.put("mhtLimitPay", "no_credit");//
        // 测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        String Key = ob.getString("appKey");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + res);
    }

    /**
     *
     */
    @Test
    public void Test_huice() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", "Test");//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", "154113047611218");//应用ID
        ob.put("appKey", "VSO3MhOB2saRGmgpav1GNgpCsyjuPYyu");//应用Key
        ob.put("channelAuthCode", "6235456110887066597" +
                "" +
                "" +
                "");//支付码
        ob.put("payChannelType", "27");
        ob.put("notifyUrl", "");
        ob.put("version", "1.0.0");
        ob.put("mhtLimitPay", "1");//
        ob.put("mhtOrderAmt", "1");
        // 测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
}

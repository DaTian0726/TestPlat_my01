package com.juhe.my01.testng.juhe.case01.TradeWap_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.TradeWap;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 通用脚本，
 * 调试 测试单个渠道使用
 */
public class Public_TestCase {

    /**
     * 生产环境测试地址      https://pay.ipaynow.cn/
     * 预发布环境测试地址    https://pay.ipaynow.cn/api_release/
     * 测试环境测试地址     https://dby.ipaynow.cn/api/payment/
     */
    private final String Test_URL = "https://pay.ipaynow.cn/api_release/";

    /**
     * H5网页
     * 带版本号   0模式
     */
    @Test
    public void Test_1_V() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "河北银商");//渠道
        ob.put("url",Test_URL);//请求地址
        ob.put("appId", "156586309973453");//应用ID
        ob.put("appKey", "m2OcycfJqaZHJhPH7il8dcg8o9bpO6bn");//应用Key
        ob.put("payChannelType", "12");
        ob.put("mhtLimitPay", "1");//0：禁用信用卡    1：允许使用信用卡    默认 可使用信用卡（不传）
        //测试信用类支付用例：  1.  禁用信用卡  mhtLimitPay 为0   2.允许使用信用类支付   mhtLimitPay 为1  3.不传 mhtLimitPay
        ob.put("version", "1.0.0");
        ob.put("outputType", "1");
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
    /**
     * H5网页
     * 带版本号   0模式
     */
    @Test
    public void Test_1_NoV() {
        JSONObject ob = TradeWap.Wap_WP001();
        ob.put("canal", "河北银商");//渠道
        ob.put("url",Test_URL);//请求地址
        ob.put("appId", "156586309973453");//应用ID
        ob.put("appKey", "m2OcycfJqaZHJhPH7il8dcg8o9bpO6bn");//应用Key
        ob.put("payChannelType", "12");
        ob.put("mhtLimitPay", "");////默认为启用 测试信用类支付用例：  1.   mhtLimitPay 为空  2.  mhtLimitPay为 no_credit
        ob.put("version", "");
        ob.put("outputType", "1");
        JSONObject res = API_NoVer.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
}

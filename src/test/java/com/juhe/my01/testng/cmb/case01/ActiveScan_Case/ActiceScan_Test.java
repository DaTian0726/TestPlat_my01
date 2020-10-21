package com.juhe.my01.testng.cmb.case01.ActiveScan_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.cmb.Model_Active;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class ActiceScan_Test {

    /**
     *  *  生产环境地址：     https://ipaynow.acquire.cmbchina.com/
     *  * 预发布环境地址：  https://ipaynow.acquire.cmbchina.com/api_release/
     *  * 测试环境地址：    https://cmb-test-payapi.ipaynow.cn/api/payment/
     */
    private final String Test_Url="https://ipaynow.acquire.cmbchina.com/";
    private final String appId="154217605294057";
    private final String appKey="kfdrLtVfohI046XZe2RY5m2CQ5vhSt0R";

    @Test
    public void Test_v_0(){
        JSONObject js= Model_Active.Cmb_Ac_WP001();
        js.put("canal", "支付宝测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "1");
        js.put("version", "1.0.0");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_Version.RequestApi(js);

        System.out.println("返回结果----\n" + Undecode_util.res(ob.getString("body")));
    }
    @Test
    public void Test_nv_0(){
        JSONObject js= Model_Active.Cmb_Ac_WP001();
        js.put("canal", "支付宝测试");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("payChannelType", "12");
        js.put("mhtLimitPay", "");
        js.put("version", "");
        js.put("mhtOrderAmt","1");
        js.put("outputType", "0");// 0 返回二维码  1 返回支付链接
        JSONObject ob = API_NoVer.RequestApi(js);
        System.out.println("返回结果----\n" + Undecode_util.res(ob.getString("body")));
    }
}

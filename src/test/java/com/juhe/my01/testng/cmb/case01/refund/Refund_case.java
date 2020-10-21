package com.juhe.my01.testng.cmb.case01.refund;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.cmb.Model_Refund;
import com.juhe.my01.toapi.ToRefund;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 退款测试：    http://192.168.105.5:8780/cmb_refund_access
 * *生产环境：   https://ipaynow.acquire.cmbchina.com/refund/refundOrder
 * *预发布环境：   https://ipaynow.acquire.cmbchina.com/api_release/refund/refundOrder
 */
public class Refund_case {
    public final String  Test_URL="https://ipaynow.acquire.cmbchina.com/refund/refundOrder";
    /**
     * 正常退款---不带版本号
     */
    @Test(invocationCount = 1)
    public void Test01() {
        JSONObject ob = Model_Refund.TestRefund();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("mhtOrderNo", "20201014104711Test");
        ob.put("amount", "1");
        ob.put("funcode","R001");
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }

    /**
     * 正常退款---带版本号带通知地址
     */
    @Test
    public void Test02() {
        JSONObject ob = Model_Refund.TestRefund();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("mhtOrderNo", "20191024202816Test");
        ob.put("amount", "1");
        ob.put("version", "1.1.0");
        ob.put("notifyUrl", "http://mock-api.com/0ZzRmXKe.mock/qqq");
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }

    /**
     * 退款查询-----不带版本号
     */
    @Test
    public void TestQuery01() {
        JSONObject ob = Model_Refund.TestQueery();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("mhtRefundNo", "20191024202915Refund");
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }
    /**
     * 退款查询-----带版本号
     */
    @Test
    public void TestQuery02() {
        JSONObject ob = Model_Refund.TestQueery();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("mhtRefundNo", "20191024202915Refund");
        ob.put("version", "1.1.0");
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }

    /**
     * 撤销
     */
    @Test
    public void Test03() {
        JSONObject ob = Model_Refund.TestRefund();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("mhtOrderNo", "20191024202520Test");
        ob.put("amount", "1");
        ob.put("funcode", "R002");
        ob.put("reason", "撤销");
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }
    /**
     * 撤销查询--不带版本号
     */
    @Test
    public void TestQuery001() {
        JSONObject ob = Model_Refund.TestQueery();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("mhtRefundNo", "20191024203048Refund");
        ob.put("funcode","Q002");
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }
    /**
     * 撤销查询--带版本号
     */
    @Test
    public void TestQuery002() {
        JSONObject ob = Model_Refund.TestQueery();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "153197674775958");//应用ID
        ob.put("appKey", "0wpmRS1nzyrAqXO8syiX6JLg6B7nY79u");//应用Key
        ob.put("mhtRefundNo", "20191024203048Refund");
        ob.put("version", "1.1.0");
        ob.put("funcode","Q002");
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }
}

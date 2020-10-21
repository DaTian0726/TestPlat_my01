package com.juhe.my01.testng.juhe.case01.Refund_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Model_Refund;
import com.juhe.my01.toapi.ToRefund;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 2019-11-13
 * 退款系统接入联动优势
 */
public class Refund_20191113_LainDong {

    /**
     * 测试环境退款地址：  http://192.168.99.54:8790/refund_access/refundOrder
     * 退款 预发布环境       https://pay.ipaynow.cn/api_release/refund/refundOrder
     * 生产环境地址：        https://pay.ipaynow.cn/refund/refundOrder
     * https://dby.ipaynow.cn/api/payment/
     */
    private final String Test_URL = "https://pay.ipaynow.cn/refund/refundOrder";
    private final String appId="156146164420827";
    private final String appKey="lfzwMygl9cpQP98CVLU5e0U0GvILbfsY";

    @Test
    public void Test_Refund() {
        JSONObject js = Model_Refund.Refund_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("mhtOrderNo", "20191114195241Test");
        js.put("amount", "1");
        js.put("version","");
//        js.put("notifyUrl","http://mock-api.com/0ZzRmXKe.mock/qqq");
        js.put("funcode", "R002");//R002 撤销   R001 退款
        JSONObject res = ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.get("body").toString()));
    }

    @Test
    public void Test_Query(){
        JSONObject js=Model_Refund.Refund_Q001();
        js.put("url", Test_URL);//请求地址   api_release/
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("mhtRefundNo", "20191114202550Refund");
        js.put("version", "1.0.0");
        JSONObject ob=ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res( ob.getString("body")));
    }

    @Test
    public void Test_Huice() {
        JSONObject js = Model_Refund.Refund_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", "156817450336917");//应用ID
        js.put("appKey", "PG8PvI8He8rlmz8ACyvBi17ekjtRPIyQ");//应用Key
        js.put("mhtOrderNo", "20191114163644Test");
        js.put("amount", "1");
        js.put("version","");
        js.put("funcode", "R001");//R002 撤销   R001 退款
        JSONObject res = ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.get("body").toString()));
    }
}

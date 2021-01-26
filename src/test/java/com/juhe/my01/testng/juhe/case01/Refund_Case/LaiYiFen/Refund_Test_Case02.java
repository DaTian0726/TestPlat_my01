package com.juhe.my01.testng.juhe.case01.Refund_Case.LaiYiFen;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Model_Refund;
import com.juhe.my01.testng.juhe.case01.Barcode_TestCase.LaiYiFen.LaiyifenOrderDetail;
import com.juhe.my01.toapi.ToRefund;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 2019-10-29提测
 * 退款新增：
 * * 1.0.1版本
 * * 退款查询、通知、增加字段 discountDetail（支付优惠明细）
 */
public class Refund_Test_Case02 {

    private final String Test_URL = "http://192.168.99.54:8790/refund_access/refundOrder";
    private final String canal = "银联大单优惠-测试";
    private final String appId = "157121716806210";
    private final String appKey = "Uhkc3OreEWmHtoqR84UCguVZbQElufGy";

    /**
     * 退款 1.0.1版本demo
     *  退款返回中 没有discountDetail字段
     */
    @Test
    public void Test_refund_V101() {
        JSONObject js = Model_Refund.Refund_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("mhtOrderNo", "20191030142736Test");
        js.put("amount", "16000");//
        js.put("version", "1.0.1");
        js.put("notifyUrl", "http://mock-api.com/0ZzRmXKe.mock/qqq");
        //获取订单详情
        String acqAddnData = LaiyifenOrderDetail.OrderDetail();
        js.put("acqAddnData", acqAddnData);
        JSONObject res = ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }

    /**
     * 退款版本为 1.0.1的退款查询
     * 查询版本号：
     *         1.0.1  ——有discountDetail字段
     *         1.0.0  ——有discountDetail字段
     *         空     ——有discountDetail字段
     */
    @Test
    public void Test_Refund_Query_V101() {
        JSONObject js = Model_Refund.Refund_Q001();
        js.put("version", "");
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("mhtRefundNo", "20191030142831Refund");
        JSONObject res = ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
    }
}

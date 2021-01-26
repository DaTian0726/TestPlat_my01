package com.juhe.my01.testng.juhe.case01.Refund_Case.LaiYiFen;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Model_Refund;
import com.juhe.my01.testng.juhe.case01.Barcode_TestCase.LaiYiFen.LaiyifenOrderDetail;
import com.juhe.my01.toapi.ToRefund;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;
/**
 * 退款
 * 对接大单优惠接口，新增订单详情字段，为来伊份定制新增订单详情字段
 * 备注：  银联不支持部分退款
 *       撤销--关单
 *       暂无生产测试号
 * 2019-10-23
 */
public class Refund_Test_Case01 {

    private final String Test_URL="http://192.168.99.54:8790/refund_access/refundOrder";
    private final String canal = "银联大单优惠-测试";
    private final String appId = "157121716806210";
    private final String appKey = "Uhkc3OreEWmHtoqR84UCguVZbQElufGy";
    /**
     * 退款，不带版本号
     * 不支持部分退款
     */
    @Test
    public void Refund_Test(){
        JSONObject js= Model_Refund.Refund_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("mhtOrderNo", "20191030140104Test");
        js.put("amount", "40000");
        //获取订单详情
        String acqAddnData= LaiyifenOrderDetail.OrderDetail();
        js.put("acqAddnData",acqAddnData);
        JSONObject res = ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res( res.getString("body")));
    }
    /**
     * 退款，带版本号  带通知地址
     */
    @Test
    public void Refund_Test_VN(){
        JSONObject js= Model_Refund.Refund_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);//应用ID
        js.put("appKey", appKey);//应用Key
        js.put("mhtOrderNo", "20191023194744Test");
        js.put("amount", "1");
        js.put("notifyUrl","http://mock-api.com/0ZzRmXKe.mock/qqq");
        //获取订单详情
        String acqAddnData=LaiyifenOrderDetail.OrderDetail();
        js.put("acqAddnData",acqAddnData);
        JSONObject res = ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res( res.getString("body")));
    }
    /**
     * 测试撤销
     */
    @Test
    public void Test03() {
        JSONObject ob = Model_Refund.Refund_Var();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", appId);//应用ID
        ob.put("appKey", appKey);//应用Key
        ob.put("mhtOrderNo", "20191023195104Test");
        ob.put("amount", "1");
        ob.put("funcode", "R002");
        ob.put("reason", "撤销");
        //获取订单详情
        String acqAddnData=LaiyifenOrderDetail.OrderDetail();
        ob.put("acqAddnData",acqAddnData);
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res( res.getString("body")));
    }
}

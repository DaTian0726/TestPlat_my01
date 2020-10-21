package com.juhe.my01.testng.juhe.case01.Refund_Case;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Model_Refund;
import com.juhe.my01.toapi.ToRefund;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 测试环境退款地址：  http://192.168.99.54:8790/refund_access/refundOrder
 * 退款 预发布环境       https://pay.ipaynow.cn/api_release/refund/refundOrder
 * 生产环境地址：        https://pay.ipaynow.cn/refund/refundOrder
 *
 */
public class Refund_Test01 {
    private final String Test_URL="https://pay.ipaynow.cn/refund/refundOrder";
    /**
     * 退款，不带版本号
     */
    @Test
    public void Refund_Test(){
        JSONObject js= Model_Refund.Refund_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", "157535194884943");//应用ID
        js.put("appKey", ".");//应用Key
        js.put("mhtOrderNo", "20200706192538Test");
        js.put("amount", "1");
        JSONObject res = ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
    /**
     * 退款，带版本号  带通知地址
     */
    @Test(invocationCount = 1)
    public void Refund_Test_VN(){
        JSONObject js= Model_Refund.Refund_Var();
        js.put("url", Test_URL);//请求地址
        js.put("appId", "159713611544491");//应用ID
        js.put("appKey", "zzwrsvVuuMA1L2U4Nm0YTCNiYzNYz6wP");//应用Key
        js.put("mhtOrderNo", "c200231202008261844241478986");
        js.put("amount", "1");
        js.put("notifyUrl","http://mock-api.com/dno4ooKX.mock/qqq");
        JSONObject res = ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res( res.getString("body")));
    }

    /**
     * 测试撤销
     */
    @Test(invocationCount = 1)
    public void Test03() {
        JSONObject ob = Model_Refund.Refund_Var();
        ob.put("url", Test_URL);//请求地址   api_release/
        ob.put("appId", "155011680219391");//应用ID 156134538804645
        ob.put("appKey", "NrR3GtknOXKFBb6oOxXYeH6uwjLJ4drl");//应用Key rXuFW3RjJ4ppUSE0ItFcGXuo0tB8wM1D
//        ob.put("oriTransId", "c200216202009171943081568670");//支付原单进行退款  - 针对
        ob.put("mhtOrderNo", "20200922153906Test"); //20200720162730Test
//        ob.put("mhtRefundNo", "20200709"+"B001");//仅仅撤销接口支持，支持相同撤销单号进行撤销
        ob.put("amount", "1");
        ob.put("funcode", "R001");
        ob.put("reason", "退款");
        JSONObject res = ToRefund.RequestApi(ob);
        System.out.println("请求结果：" + JSON.toJSONString(Undecode_util.res( res.getString("body")),true));
    }


    @Test
    public void Test0001(){
        JSONObject js=Model_Refund.Refund_Q001();
        js.put("funcode", "Q001");//Q001退款查询
        js.put("url", Test_URL);//请求地址   api_release/
        js.put("appId", "159713611544491");//应用ID
        js.put("appKey", "zzwrsvVuuMA1L2U4Nm0YTCNiYzNYz6wP");//应用Key
        js.put("mhtRefundNo", "20200827154503Refund");
        js.put("version", "1.0.0");
        JSONObject ob=ToRefund.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(ob.getString("body")));
    }


}

package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

/**
 * 退款请求参数
 */
public class Model_Refund {

    public static JSONObject Refund_Var() {
        JSONObject js = new JSONObject();
        js.put("funcode", "R001");
        js.put("version", "1.0.0");
        js.put("oriTransId", "");//支付原单号、退款系统支持原单号进行退款；原因：聚合码支付时同时使用支付宝微信出现相同订单号，使用相同订单号进行退款时会出现异常
                                 //原单号及订单号优先级：原单号和订单号共存的时候以原单号为主进行退款   原单号>原商户订单号
        js.put("appId", "");
        js.put("mhtOrderNo", "");
        js.put("mhtRefundNo", GetNowTime.NowTime() + "Refund");//撤销支持，支持相同撤销单号
        js.put("amount", "1");
        js.put("reason", "refund-test");
        js.put("mhtCharset", "UTF-8");
        js.put("notifyUrl", "http://mock-api.com/dno4ooKX.mock/qqq");
        js.put("signType", "MD5");
        js.put("mhtSignature", "");
        return js;
    }

    public static JSONObject Refund_Q001() {
        JSONObject js = new JSONObject();
        js.put("funcode", "Q001");
        js.put("version", "1.0.0");
        js.put("appId", "");
        js.put("mhtRefundNo", "");
        js.put("mhtCharset", "UTF-8");
        js.put("signType", "MD5");
        js.put("mhtSignature", "");
        return js;
    }
}

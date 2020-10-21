package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class TradeWap {
    /**
     * H5系统
     * WP001接口
     *
     * @return
     */
    public static JSONObject Wap_WP001() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("canal", "支付宝-ISV");//渠道
        jsonObject.put("url", "https://pay.ipaynow.cn/");//请求地址
        jsonObject.put("appId", "147868777472129");
        jsonObject.put("appKey", "1FZMAlAplOTamX6OARDVV8hrswhbGEVg");
        jsonObject.put("payChannelType", "");
        jsonObject.put("funcode", "WP001");
        jsonObject.put("version", "1.0.0");
        jsonObject.put("mhtOrderNo", GetNowTime.NowTime()+"Test");
        jsonObject.put("mhtSubMchId", "");
        jsonObject.put("mhtOrderName", "订单名称");
        jsonObject.put("mhtOrderType", "01");
        jsonObject.put("mhtCurrencyType", "156");
        jsonObject.put("mhtOrderAmt", "1");
        jsonObject.put("mhtOrderDetail", "订单详情");
        jsonObject.put("mhtOrderTimeOut", "3600");
        jsonObject.put("mhtOrderStartTime", GetNowTime.NowTime());
        jsonObject.put("notifyUrl", "http://mock-api.com/0ZzRmXKe.mock/qqq");
        jsonObject.put("frontNotifyUrl", "http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");
        jsonObject.put("mhtCharset", "UTF-8");
        jsonObject.put("deviceType", "0601");
        jsonObject.put("mhtReserved", "mhtReserved");
        jsonObject.put("outputType", "1");
        jsonObject.put("mhtLimitPay", "1");//0：禁用信用卡1：允许使用信用卡  默认禁用信用卡
        jsonObject.put("payAccNo", "");
        jsonObject.put("mhtGoodsTag", "");
        jsonObject.put("consumerCreateIp", "");
        jsonObject.put("consumerId", "");
        jsonObject.put("mhtSignType", "MD5");
        jsonObject.put("mhtSignature", "");
        return jsonObject;
    }

    /**
     * H5系统
     * MQ002接口
     *
     * @return
     */
    public static JSONObject Wap_MQ002() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("canal", "支付宝-ISV");//渠道
        jsonObject.put("url", "https://pay.ipaynow.cn/");//请求地址
        jsonObject.put("appId", "147868777472129");
        jsonObject.put("appKey", "1FZMAlAplOTamX6OARDVV8hrswhbGEVg");
        jsonObject.put("mhtOrderNo", "");
        jsonObject.put("funcode", "MQ002");
        jsonObject.put("version", "1.0.0");
        jsonObject.put("deviceType", "0601");
        jsonObject.put("mhtCharset", "UTF-8");
        jsonObject.put("mhtSignType", "MD5");
        jsonObject.put("mhtSignature", "");
        return jsonObject;
    }
}

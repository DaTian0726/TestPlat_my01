package com.juhe.my01.models.juhe;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;

public class Barcode {
    /**
     * WP001 接口
     *
     * @return
     */
    public static JSONObject WP001Vars() {
        JSONObject object = new JSONObject();

        object.put("canal", "");//渠道
        object.put("url", "https://dby.ipaynow.cn/api/payment/");//请求地址
        object.put("appId", "156134538804645");
        object.put("appKey", "rXuFW3RjJ4ppUSE0ItFcGXuo0tB8wM1D");
        object.put("channelAuthCode", "285726266062553328");//支付码
        object.put("funcode", "WP001");
        object.put("version", "");
        object.put("mhtSubMchId", "");
        object.put("mhtOrderNo", "2009"+GetNowTime.NowTime() + "BarTest");
        object.put("mhtOrderName", "mhtOrderName");
        object.put("mhtOrderType", "01");
        object.put("mhtCurrencyType", "156");
        object.put("mhtOrderAmt", "1");
        object.put("mhtOrderDetail", "mhtOrderDetail");
        object.put("mhtOrderTimeOut", "3600");
        object.put("mhtOrderStartTime", GetNowTime.NowTime());
        object.put("notifyUrl", "");//需要后台通知的必填   如填写,则在验密等异步情况下会发起后台通知
        object.put("mhtCharset", "UTF-8");
        object.put("deviceType", "05");
        object.put("payChannelType", "12");
        object.put("mhtGoodsTag", "");
        object.put("mhtReserved", "mhtReserved");
        object.put("mhtStoreId", "");
        object.put("mhtTermId", "");
        //新增字段
//       object.put("mhtTermId","123");//商户终端号：
//       object.put("mhtStoreId","45678");//商户门店号：
        object.put("mhtSignType", "MD5");
        object.put("mhtSignature", "");
        return object;
    }

    /**
     * MQ002接口
     *
     * @return
     */
    public static JSONObject MQ002Vars() {
        JSONObject object = new JSONObject();
        object.put("canal", "汇付天下");//渠道
        object.put("appId", "");
        object.put("appKey", "");
        object.put("mhtOrderNo", "");
        object.put("url", "https://pay.ipaynow.cn/");//请求地址
        object.put("funcode", "MQ002");
        object.put("version", "1.0.0");
        object.put("deviceType", "05");
        object.put("mhtCharset", "UTF-8");
        object.put("mhtSignType", "MD5");
        object.put("mhtSignature", "");
        return object;
    }
}

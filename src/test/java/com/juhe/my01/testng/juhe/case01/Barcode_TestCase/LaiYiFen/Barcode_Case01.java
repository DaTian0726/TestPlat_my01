package com.juhe.my01.testng.juhe.case01.Barcode_TestCase.LaiYiFen;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Barcode;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

/**
 * 被扫
 * 对接大单优惠接口，新增订单详情字段，为来伊份定制新增订单详情字段
 * 备注：  来伊份 只支持新版本（1.0.0）
 * 2019-10-23
 */
public class Barcode_Case01 {

    private final String Test_URL = "https://dby.ipaynow.cn/api/payment/";
    private final String canal = "银联大单优惠-测试";
    private final String appId = "157121716806210";
    private final String appKey = "Uhkc3OreEWmHtoqR84UCguVZbQElufGy";

    //=====================带版本号====================================
    /**
     * 下单
     * 带版本号
     */
    @Test
    public void Test01() {
        JSONObject ob = Barcode.WP001Vars();
        ob.put("canal", canal);//渠道
        ob.put("url", Test_URL);//请求地址
        ob.put("appId", appId);//应用ID
        ob.put("appKey", appKey);//应用Key
        ob.put("channelAuthCode", "6222885964809968874");//支付码 此处退款金额为原金额 不算优惠
        ob.put("payChannelType", "27");
        ob.put("version", "1.0.0");
        ob.put("mhtOrderAmt", "16000");
        //获取订单详情
        String acqAddnData = LaiyifenOrderDetail.OrderDetail();
        ob.put("acqAddnData", acqAddnData);
        JSONObject res = API_Version.RequestApi(ob);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }

    /**
     * 查询
     * 带版本号
     */
    @Test
    public void Test001() {
        JSONObject js = Barcode.MQ002Vars();
        js.put("canal", canal);//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);
        js.put("appKey", appKey);
        js.put("mhtOrderNo", "20191030140348Test");
        js.put("version", "1.0.0");
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }

//=====================不带版本号====================================
    /**
     * 查询
     * 不带版本号
     */
    @Test
    public void Test002() {
        JSONObject js = Barcode.MQ002Vars();
        js.put("canal", canal);//渠道
        js.put("url", Test_URL);//请求地址
        js.put("appId", appId);
        js.put("appKey", appKey);
        js.put("mhtOrderNo", "20191023183134Test");
        js.put("version", "");
        JSONObject res = API_NoVer.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.toString()));
    }
}

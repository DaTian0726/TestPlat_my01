package com.juhe.my01.testng.juhe.case01.TradeWap_Case;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.TradeWap;
import com.juhe.my01.models.juhe.Trade_SDK;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class TradeWap_MQ002 {
    /**
     *  * 测试环境地址：
     *  * 预发布环境地址：  https://pay.ipaynow.cn/api_release/
     *  * 生产环境地址：    https://pay.ipaynow.cn/
     */
    private final  String Test_URL="https://pay.ipaynow.cn/";

    @Test
    public void Test01(){
        JSONObject js= TradeWap.Wap_MQ002();
        js.put("canal", "支付宝-ISV");//渠道
        js.put("url", "https://pay.ipaynow.cn/");//请求地址
        js.put("appId", "147868777472129");
        js.put("appKey", "1FZMAlAplOTamX6OARDVV8hrswhbGEVg");
        js.put("mhtOrderNo", "20191022142130Test");
        js.put("version", "1.0.0");
        JSONObject ob= API_Version.RequestApi(js);
        System.out.println("查询结果：——\n"+ Undecode_util.res(ob.toString()));
    }
}

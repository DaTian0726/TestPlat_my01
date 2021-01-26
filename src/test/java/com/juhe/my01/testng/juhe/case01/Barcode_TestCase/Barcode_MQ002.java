package com.juhe.my01.testng.juhe.case01.Barcode_TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Barcode;
import com.juhe.my01.toapi.API_Version;

import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class Barcode_MQ002 {

    @Test
    public void Test01() {
        JSONObject js = Barcode.MQ002Vars();
        js.put("canal", "汇付天下");//渠道
        js.put("url", "https://dby.ipaynow.cn/api/payment/");//请求地址   api_release/
        js.put("appId", "156134538804645");
        js.put("appKey", "rXuFW3RjJ4ppUSE0ItFcGXuo0tB8wM1D");
        js.put("mhtOrderNo", "20200714103011Test" +
                "");
        JSONObject res = API_Version.RequestApi(js);
        System.out.println("请求结果：" + Undecode_util.res(res.getString("body")));
//        //进行断言
//        String duanyan= ResAssert.Duan(res);
//        System.out.println("断言结果："+duanyan);
//        //进行验签
//        String appKey=js.getString("appKey");
//        String yan= TestSign.CheckSignMD5(res,appKey);
//        System.out.println("验签结果："+yan);
    }
}

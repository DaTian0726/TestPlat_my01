package com.juhe.my01.testng.juhe.case01.Wechat_case;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.WeChatModel;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

import java.util.Scanner;

public class WeChat_WP001 {

/**
 *
 *  测试环境测试地址：https://dby.ipaynow.cn/api/payment/
 *  生产环境测试地址：https://pay.ipaynow.cn/
 *  预发布环境测试地址：https://pay.ipaynow.cn/api_release/
 */

    private final String Test_Url = "https://dby.ipaynow.cn/api/payment/";
//    private final String Test_Url = "https://pay.ipaynow.cn/api_release/";
//    private final String Test_Url = "https://ipaynow.acquire.cmbchina.com/";
    private final String appId_test = "155013581464329";  //156264485083050测试
    private final String appKey_test = "g3iKpS8gMTZ8pqD9dPQxQg2iGjKkdkDl"; //7X5j0wkKbmFhBCmC8kjAbY1LmxmecvEg测试

    /**
     * 带版本号
     */
    @Test(invocationCount = 1)//开启多次测试
    public void WeChat_Test(){
        JSONObject js = WeChatModel.WcChat_applet();
        //覆盖之前的js参数
        js.put("canal","招商银行-微信小程序");
        js.put("url","https://dby.ipaynow.cn/api/payment/");
        js.put("appId","155013581464329");//157888527897789预发布
        js.put("appKey","g3iKpS8gMTZ8pqD9dPQxQg2iGjKkdkDl");//UYdJdFwHzBuyoRUFf6is4ffjYFe7l9It预发布
        js.put("payChannelType","13"); //小程序只支持微信13 和微众小钱包101
        js.put("mhtLimitPay","1");//是否限制信用卡
        js.put("version","1.0.0");//版本
        js.put("mhtOrderAmt","1");//金额 单位：1/分
        //测试监控使用
//        js.put("consumerId","1");
        js.put("notifyUrl","http://mock-api.com/dno4ooKX.mock/qqq"); //http://mock-api.com/dno4ooKX.mock/qqq
//        js.put("frontNotifyUrl","http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");
        js.put("mhtOrderTimeOut","3600");

        //发起请求
        JSONObject resp = API_Version.RequestApi(js);
        System.out.println("---------------------------  返回结果为  ---------------------------");
        String result = Undecode_util.res(resp.getString("body"));
//        System.out.println(result);
//        System.out.println("---------------------------  JSON视图  ---------------------------");
        System.out.println(result);
    }
    @Test
    public void testa(){



    }

}

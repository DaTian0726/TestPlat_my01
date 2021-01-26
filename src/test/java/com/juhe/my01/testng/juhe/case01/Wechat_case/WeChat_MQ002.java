package com.juhe.my01.testng.juhe.case01.Wechat_case;


import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.WeChatModel;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

public class WeChat_MQ002 {

    /**
     * 主扫测试
     *  测试环境测试地址：https://dby.ipaynow.cn/api/payment/
     *  生产环境测试地址：https://pay.ipaynow.cn/
     *  预发布环境测试地址：https://pay.ipaynow.cn/api_release/
     */

    private static final String Test_Url = "https://pay.ipaynow.cn/";
    private static final String appId_test = "154650426265515";
        private static final String appKey_test = "GfZygAsBn3hxdbK7RBFXK9X4syYBiMwv";

    /**
     *  金融云小程序下单MQ002查询接口
     */
    @Test(invocationCount = 1)
    public void Query_WxChat(){
        JSONObject js = WeChatModel.QueryWx_Model();
        js.put("canal", "广发银行-微信小程序");//渠道
        js.put("url", Test_Url);//请求地址
        js.put("version", "1.0.0");
        js.put("appId", "157888527897789");
        js.put("appKey", "UYdJdFwHzBuyoRUFf6is4ffjYFe7l9It");//应用Key
        js.put("mhtOrderNo", "Wx20200903133343");

        //请求
        JSONObject resp = API_Version.RequestApi(js);
        System.out.println("---------------------------  返回结果为  ---------------------------");
        String result = Undecode_util.res(resp.getString("body"));
        System.out.println(result);
//        System.out.println("---------------------------  JSON视图  ---------------------------");
//        SpiltSpringUtil.JsonSys_resp(result);
    }


}

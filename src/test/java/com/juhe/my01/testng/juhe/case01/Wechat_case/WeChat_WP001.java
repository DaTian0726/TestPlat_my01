package com.juhe.my01.testng.juhe.case01.Wechat_case;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
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
        js.put("url","https://pay.ipaynow.cn/payment/test_release/testApplet");
        js.put("appId","160431203142577");//157888527897789预发布
        js.put("appKey","igj9wGYKCBonUzNUMwe4djW0lsO7hgWW");//UYdJdFwHzBuyoRUFf6is4ffjYFe7l9It预发布
        js.put("payChannelType","12"); //小程序只支持微信13 和微众小钱包101
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

    JSONObject j = JSONObject.parseObject("{\"head\":{\"rd\":\"0\",\"rm\":\"成功\"},\"body\":{\"page\":{\"current\":1,\"size\":20,\"total\":36},\"result\":[{\"mchId\":\"000000000512874\",\"mchName\":\"王伟\",\"entEmail\":\"wangwei@ipaynow.cn\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":1,\"jiaxinSwitchApi\":1,\"createdTime\":\"2020-10-22 16:34:23\",\"faenable\":0},{\"mchId\":\"000000100540324\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws123@qq.com\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":3,\"jiaxinSwitchApi\":1,\"createdTime\":\"2020-09-23 16:58:37\",\"faenable\":0},{\"mchId\":\"000000100540325\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws2123@qq.com\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":1,\"jiaxinSwitchApi\":1,\"createdTime\":\"2020-09-23 17:43:50\",\"faenable\":0},{\"mchId\":\"000000100540326\",\"mchName\":\"北京开发前景\",\"entEmail\":\"1212q3@qq.com\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":3,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 17:47:47\",\"faenable\":0},{\"mchId\":\"000000100540327\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"1212q32@qq.com\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":2,\"jiaxinSwitchApi\":1,\"createdTime\":\"2020-09-23 18:05:12\",\"faenable\":0},{\"mchId\":\"000000100540328\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws23123@qq.com\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 18:06:06\",\"faenable\":0},{\"mchId\":\"000000100540329\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws231123@qq.com\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 18:07:39\",\"faenable\":0},{\"mchId\":\"000000100540330\",\"mchName\":\"王秀娟xg\",\"entEmail\":\"ws123@qq.com23\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 18:43:31\",\"faenable\":0},{\"mchId\":\"000000100540331\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"1212q3@qq.com1\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 18:44:19\",\"faenable\":0},{\"mchId\":\"000000100540332\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws123@qq.com12\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 18:49:48\",\"faenable\":0},{\"mchId\":\"000000100540333\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws123@qq.com125\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 18:58:25\",\"faenable\":0},{\"mchId\":\"000000100540334\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws123@qq.com1251\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 19:06:46\",\"faenable\":0},{\"mchId\":\"000000100540335\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"werwetryt\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 19:07:52\",\"faenable\":0},{\"mchId\":\"000000100540336\",\"mchName\":\"个体户名称测试060802\",\"entEmail\":\"12123@qq.com\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 19:16:37\",\"faenable\":0},{\"mchId\":\"000000100540337\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws123@qq.com1231\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 19:25:39\",\"faenable\":0},{\"mchId\":\"000000100540338\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws123@qq.com12311\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 19:26:34\",\"faenable\":0},{\"mchId\":\"000000100540339\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws123@qq.com1231121\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 19:27:05\",\"faenable\":0},{\"mchId\":\"000000100540340\",\"mchName\":\"北京开张吉祥科技有限公司\",\"entEmail\":\"ws123@qq.co\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-23 19:27:18\",\"faenable\":0},{\"mchId\":\"000000100540341\",\"mchName\":\"个体户名称测试060802\",\"entEmail\":\"12123@qq.com12\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-24 10:16:08\",\"faenable\":0},{\"mchId\":\"000000100540342\",\"mchName\":\"个体户名称测试060802\",\"entEmail\":\"12123@qq.com121\",\"merchantManagerName\":\"\",\"managerDeptName\":\"\",\"balance\":0,\"userCount\":0,\"signCount\":0,\"unSignCount\":0,\"auditStatus\":0,\"jiaxinSwitchApi\":0,\"createdTime\":\"2020-09-24 10:17:55\",\"faenable\":0}]}}");
        System.out.println(JSON.toJSONString(j,true));

    }

}

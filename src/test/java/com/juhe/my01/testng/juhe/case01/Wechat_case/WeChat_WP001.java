package com.juhe.my01.testng.juhe.case01.Wechat_case;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.WeChatModel;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

public class WeChat_WP001 {

    /**
     * 测试环境测试地址：https://dby.ipaynow.cn/api/payment/
     * 生产环境测试地址：https://pay.ipaynow.cn/
     * 预发布环境测试地址：https://pay.ipaynow.cn/api_release/
     */

//    private final String Test_Url = "https://dby.ipaynow.cn/api/payment/";
//    private final String Test_Url = "https://pay.ipaynow.cn/api_release/";
    private final String Test_Url = "https://pay.ipaynow.cn/";
    private final String appId_test = "155013581464329";  //156264485083050测试
    private final String appKey_test = "g3iKpS8gMTZ8pqD9dPQxQg2iGjKkdkDl"; //7X5j0wkKbmFhBCmC8kjAbY1LmxmecvEg测试

    /**
     * 带版本号
     */
    @Test(invocationCount = 5)//开启多次测试
    public void WeChat_Test() {
        JSONObject js = WeChatModel.WcChat_applet();
        //覆盖之前的js参数
        js.put("canal", "招商银行-微信小程序");
        js.put("url", Test_Url);
        js.put("appId", "160489251323255");//157888527897789预发布
        js.put("appKey", "mwmNh4ScImFhbiJmBR6FZbZEznIRhApg");//UYdJdFwHzBuyoRUFf6is4ffjYFe7l9It预发布
//        js.put("payChannelType","13"); //微信13和支付宝12
        js.put("payChannelType", "12"); //微信13和支付宝12
        js.put("mhtLimitPay", "1");//是否限制信用卡
        js.put("version", "1.0.0");//版本
        js.put("mhtOrderAmt", "1");//金额 单位：1/分
        //支付宝配置
        js.put("mhtSubAppId", "");
        js.put("consumerId", "2088912927599908");//支付宝
        //微信配置
//        js.put("mhtSubAppId","wx694abcd10bf94a26");
//        js.put("consumerId","o0wwA0RsmX9AM_SZ8NBmdF9fNMl4");//微信

        js.put("notifyUrl", "http://mock-api.com/dno4ooKX.mock/qqq"); //http://mock-api.com/dno4ooKX.mock/qqq
//        js.put("frontNotifyUrl","http://posp.ipaynow.cn:10808/mobilewapH/frontnotify");
        js.put("mhtOrderTimeOut", "3600");

        //发起请求
        JSONObject resp = API_Version.RequestApi(js);
//        System.out.println(JSON.toJSONString(js,true));
        System.out.println("---------------------------  返回结果为  ---------------------------");
        String result = Undecode_util.res(resp.getString("body"));
//        System.out.println(result);
//        System.out.println("---------------------------  JSON视图  ---------------------------");
        System.out.println(JSON.toJSONString(SpiltSpringUtil.StringToJson(result)));
    }

    @Test(invocationCount = 10)
    public void test() {
        double money = 5;  //单位（元）
        int num = 10;
        System.out.println("总金额：" + money + "元\t 拆分红包总个数:" + num);
        int[] array = divived(money, num);

        System.out.println("拆分后的各个红包金额数如下:");
        for (int i : array) {
            System.out.print((double) i / 100 + "元\t");
        }
    }

    public static int[] divived(double money, int n) {

        int fen = (int) (money * 100);
        if (fen < n || fen < 1) {
            throw new IllegalArgumentException("被拆分的总金额不能小于1分");
        }
        // 创建一个长度等于n的红包数组
        int[] array = new int[n];
        //第一步 每个红包先塞1分
        Arrays.fill(array, 1);
        //总金额减去已分配的n 分钱
        fen -= n;
        //第二步，循环遍历如果剩余金额>0 则一直分配
        int i = 0;  //从第一个红包进行分配
        //创建一个随机分配对象
        Random random = new Random();
        while (fen > 0 && i != n) {
            int f = random.nextInt(fen);  //创建范围[0,fen)
            array[random.nextInt(n)] += f;
            i++;
            fen -= f;
        }
        //不判断。直接加
        array[random.nextInt(n)] += fen;
        return array;
    }

//    @Test
//    public void testAA() {
//        JSONObject req = new JSONObject();
//        req.put("mchId", "000000001572907");//测试环境商户号
//        req.put("signType", "RSA");
//        req.put("reqTime", DateUtils.getDateStr14(new Date()));
//        req.put("version", "1.0");
//        req.put("reqId", DateUtils.getDateStr14(new Date()));
//        req.put("sign", null);
//        req.put("reqData", null);
//        req.put("aes", "YbufHyLhiTY97j87nV06PQ==");
//
//        JSONObject reqData = new JSONObject();
//
//        JSONObject userWorkloadLevel1 = new JSONObject();
//        userWorkloadLevel1.put("proj", "项目A：基础服务费");
//        userWorkloadLevel1.put("std", "0.01元/笔");
//        userWorkloadLevel1.put("val", "99.99");
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add(0, userWorkloadLevel1);
//
//
//        reqData.put("mchBatchNo", "TOB" + DateUtils.getDateStr14(new Date()));
//        reqData.put("mchOrderNo", "TOD" + DateUtils.getDateStr14(new Date()));//random.nextInt(Integer.MAX_VALUE) + GetNowTime.NowTime()
//        reqData.put("userName", CreateIDCardNo.getRandomName());
//        reqData.put("userMobile", CreateIDCardNo.mobile());
//        reqData.put("userIdCardNo", CreateIDCardNo.getIdNo(true));
//        reqData.put("userBankCardNo", "6214831027394185");
//        reqData.put("userWorkload", "1184029361935343618");
//        reqData.put("userWorkloadLevel", jsonArray);
//        reqData.put("amount", "99.99");
//        reqData.put("remark", "测试");
//        reqData.put("notifyUrl", "");
//
//        req.put("reqData", reqData.toJSONString());
//        System.out.println("请求报文明文：\n" + req);
//
//        utils util = new utils();
//        String RE = null;
//        try {
//            RE = util.jiaxintang(req);
//            System.out.println(
//                    utils.Post("https://tang-beta.ipaynow.cn/jiaxin-api/orderadd.do",RE));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
}

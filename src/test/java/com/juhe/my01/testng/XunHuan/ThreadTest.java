package com.juhe.my01.testng.XunHuan;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.WeChatModel;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.Undecode_util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName: ThreadTest
 * Description:
 * date: 2020/10/15 16:10
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class ThreadTest {



    @Test
    void testCountDownLatch(){
        //等待100个线程同时执行
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i=0;i<10;i++){
            Thread thread = new MyThread(countDownLatch);
            thread.start();
            countDownLatch.countDown();
        }
    }



    static class  MyThread extends Thread{

        private CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();
            try {
                countDownLatch.await();
                WeChat_Test();
                System.out.println("count:{"+countDownLatch.getCount()+"}"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void WeChat_Test(){
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

}

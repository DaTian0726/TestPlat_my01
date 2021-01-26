package com.juhe.my01.testng.juhe.case01.Deduct_case;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;
import com.juhe.my01.utils.RSAUtils;
import com.juhe.my01.utils.StandardHttpClientUtil;
import com.juhe.my01.utils.Undecode_util;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * 测试 微信代扣接口demo
 * <p>
 * 涉及数据库：192.168.103.98 deduct
 *
 * @Author: qiaomeng
 * @Date: 2020/2/10
 */
public class Deduct_Case01 {

    /**
     * 公共参数
     */
//    测试环境参数------------------------------
//        000000100518916    zhaoyufei@ipaynow.cn  6Oc2H6zT
    private static String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDZbPdvg/Aew802OTfxt44cTq/enh8uBqECyjU3TGX5mzybCfuPe0QOTjBA1BWLsPSE1VXhBOzoPkybVLMF09R8HjFcRESZ7Qm6XoMyu1NI+O3PAuQjET+wgmbV6yMEczGn/ywsu7/ZqhuxCxitnx/dk5dX802Ldn4DFS3oBr5ocxdp0LZri1/aIS9Axvq2GL71BnJznUynCqnikYQw5cJ0KEfsGLY0Dx6MpVtAGLyoCSLfHzBSC6UYy1ywblpHvlqEyb+ngvo6RwqbXkTqaaUgcY3YGoTKy/qhIgUvx/jrpN8zha0VjdaaWxd9EkIb5ZnxDhgwOEoWm2r1qW/wmBKdAgMBAAECggEAQf2LoAIIeB3vg9yb+TY/4KGVSVjul7aVWdZrjmwWq0qNe3TtMCA2iKz8gkCchXhgzow9c31eNiLqd16es08Wt9EmJB3oQFusTy9uXJB0d7pt2x3Chk4u6XC6q4ShbTFVSertymn1kafKndKDW/bm4gZwsdX7nC+LkX31H+4kDmkI5J8/NDpwo7xgbSUWMhPUMnk9sAj1seryN41KCaqhbQ9E8aOBppjc0i5YlZungU/C0j/5eHvh+8YykW48e3GM3OA+h4ng5Ett7rWU4zpmHCpGo0vQ3QIWEx3mlnwt7VgwG6RtZ+svCbkqXJNt7Dz8Wn5GnDCJXf3GvwsdNISZ4QKBgQDsTQdtyFQFoFSXpfsD+x74zZf7AbOiy8maZKEC+pUfs3NyYF+AINaBgdCV+//uQUAbbBc99YwGc6Zp/7PXrm6tjP5j1ZJ/QX3wFKP43dzp/VpGFLyzJjGpcwlqYM9JCpLSloNBxQBLZJlehtNb9daXC8r+wpzPOziYOg9oZZMjSQKBgQDrjR106uhRj9lHszsED81u0DfA53khZVr6r/jZkPaysKKv7XQbkvn4FctaRvApMBwG5VIOfVNhBvsXA8Gg4u2TUzxAFnRrZY9Tnc9le52I+ZEf3wgM3FteQOZTKxYGkNLdKc1KZrh3XYxwY/di1sEGBE9F7Vd0PCRUQp/Heu8gtQKBgHwC6PUqfz38qKh1iUjLj7OPYkVu3TGAtar7SKzhiUV7zgimnzgFA84vrKIqAGSvhc9eaMwxg20XYKycb2uvtZILPq5yNVHnswo+Kte+x+Nc/PVuiKGUV9fP8Y8Mg3yXufoe13+6va7TetHq/B105Uub+sq8o8L2F3t8bP2i4RdRAoGADxlfnwQD2l6XNgJmMQ92Qrk0Kbhsylg96b3n/MJPHgs2koJtI+ta/K0g+Ot9L5a25TZD+UvNUXXqGIKUIeUKB5yZSx5lXhEHi/uctMukwIgG5n0cff6OGM+eNAyZ/9e+vJCWaUOGZZhojTfLPtm3S9Rw5HGfXoMQbRpMNbRKqdUCgYB85O6LayLHNqq3Vh0mGh0bEfSyRq9g87huk1WXG58Tg+LxD9v1oCpvVTQDcnegL/qnTk/I3axVItFTlWRpQKuScTn+T2N9BBrS8KqS85+XptHUIFzChnTPNjKKKw431NcveD5WHyhLhk1AlGmfNZjFTy3rflFIX9jBpFI6yrL7aA==";
    private static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAudtyg8SDCvVcD2sJClzwpZZ/MwcLANAMZuuHsyC4afEocnuviKYn/9uKHDzQ/Gj5oUfGy3SlXqwXaSHgjoPZsweS1tduY3ccyyThHeNvSR1RsLF8I8PjIURiQyYlUozwvMj78FZCsuUu0PqABLGiZKJ1I6IiB1q+36AjVEKBhypFn1Ib9Qp2vCRzo3mWb7Xf/+IDc8WSTb4Urbxq0Xoo/oha25GRniLmJ8grTsd72HY8MrpPbEvUbocPr5xEaxPBGpZlfeqUtND3pyDFugojkWMFlih3TvofNc5/OdGtzR3pX1MVIz5dQNTwef0SA0LX86gblzh8BTjdkqhewFjAfwIDAQAB";
//    private static String url = "http://192.168.99.54:18003/deduct/deductapi";
    private static String url = "https://dby.ipaynow.cn/deduct/deductapi";
    private static String appId = "158106788169583";
//    //生产环境参数：----------------------------
////          000000001556164 zhangyaoxian14@163.com  pWJOREo6
//            //商户私钥
//    private static String privateKey="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCN4iiCthH7fbYdbiBRiElI9sDKHYnlO7iCbIhBgoQAOvbrJWzLNuijsPS0gfiKg4JiSK7zxKOpJcDwuuUe4mxgFyZKcNOdfXKWWYO+6LuEQ57F798sJ5T0jVAws4pYSfqD1uYuFB1XbBqrvtEsPVQ8YIKZAE1x1DKfCrvYSboHJsDH8kJsfcJVMxkXGPc22pllVu6jPRP/ZGGCOpc6xyEqls24FJbTyKLpF4IS/kiLVOaaxCc6GrFM/Qn5ZHHednxZGu20dUCNfdOKKqgL0jf8T3yJ9fU508IIm1O9Qx1NftnnCsDj5G+VnYIQ/ead6J4oI0iqDGtuZc9Qtt1GV4E5AgMBAAECggEAGmUYZDi6365jUtZJ7OENwSUmeHNGU/7oNFs8ffNp2yEdDmHH+4YbgVhKLcqAEkSk3OPoqDDMwYrkeeRK+5Pj1Xx5AyA6PfI4fv/oInvpZpGt1+Tn/67dZyFi6ax88C/TCvPPnoLfcoQJ8iltgG1oXlMV+KC1x5dSU4QLrhEJKoskHqA6c9u3jaIAxluurSARGozod9jrohFNoWwSoA0r9JTaCAoa7p6PBXDS9jwKV5NUFOgMCeUqNXdJEt9R9SHz6PfUFN16Dmp8CfRXEAbGyWRzwDrcGkYFBcnVK82lv+2Nu4J6QjBFKY2zzuxDlZCvmh1PvZsCHwdJl0l1ZzLKgQKBgQDFH1uyHFiVTW0YB+Vusp1zm1eDbN4JPSmadj6ZtOn0VLT0I82kSNjgPhamjThslgKSSeZ9TX+twdu5PfZVYL1QNAzXAeGlrmKtydEDZFLXu3xg6mHWcpAS8RS4d4ZN3EC//WaIACFgiqAipH7O4lmtozyfZD7NAeK4c4lGNZL/+wKBgQC4QwmbUFoEhOKYEJ6ZISha+8LiCqrlPJUoFNn5PKEfXD+cgAhll9by9kLdY9yxNzfhPs4wmkVCJPev7lHKFoCKp9UJqiUY8ScFvf2Rv7tekeP3PdgPjW9fjtCfhYKoL6lSKc4Yii0RMDiOh18fwdoV627abeR4P/fSW8UtOZUZWwKBgQDCqwoyJh4xK+ptzfZ9ULV/osxVBSFtPFKmsNl3kBtvaGvforAF6s8K/SX/Sv2K9sYJVCPkYLGTlhv4n0Fy5XtwBkcb2kbOCR54hBL+54eMdyIIz87ZKgAwRJby6U7f+4CSWZx0+LP9lEk6jPqSMyTe/pLy0dvXN2KAR9EsXeITGwKBgGGXqAPp9/OCyl0OGGI0bKJby+lbCw6lGr8C5Dwcv53ThyGFsmzUkhVXFy0ZEi+OdntHf3/AhcQ1vjYhPJKTfntxzuTyh/mA6FEjQqUqbrv0+0/dIo2CNKXhB2AmH4Ci1cRdvfnDXYFID/x1eI1iZ/bKHol0QNjr0H9K+dEtOWoXAoGBAMBnwmLyH25m09GUGpmGSAJY17JP9lRAeCaSnQs7HfkjLOSRRgLbRBXRWbMygRpJi7B8ktNP9ZmtHsbuqOyFF3e+5bAOHXWB0LlgLMav5UlZcREmEgYoTUyVIkOCDDPOfn2bcW0IwUgVZhYlrHeAHoiggFrkWlkHRiQYFUAB9e/I";
//            //我司公钥
//    private static String publicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApyUwWTGCPQmX8q6OPvd+mCGn74hZ2NLtQFdwe5GVHlhCKblIBc7yrnI+CJlaLsL6hb27IMFiK8QN3MekGUda+MU9NZ2RNjhTo2V9vAkbb8GNIdwYaRi/AdIQBs8FADDHX43tNpN4O45X8aWRPQGSdkSCSN6TJRyw22omr3/1/7omOgs2BGA2fRwR4/sasf/44V8U+xa+Aj4KL8Nlejk7SOHg53/qsTMewzkEVxlPl1zfpFC2SED8UCRmxcUrBkkl4B6ZaqgHY00Gg7mMg3txld9F7fEv3nA5yTALs4KD4lavNx9ZvEYnruMDwIMyKXelL0I7ZkaW7FA1SutRxUoUXQIDAQAB";
//    private static String url="https://pay.ipaynow.cn/deduct/deductapi";
//    //预发布环境
////    private static String url="https://pay.ipaynow.cn/api_release/deduct/deductapi";
//    private static String appId="158158414466552";


    private static String charset = "UTF-8";
    private static String signType = "RSA2";


    /**
     * 5.1签约接口
     * trade.deduct.contract
     * <p>
     * 说明： 目前可测试的签约方式 只有01 ，测试使用的商户未在微信开通H5签约权限
     *        退款时 需要登录商户后台退款
     */
    @Test
    public void Test_QianYue() throws Exception {
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.contract");
        mainJson.put("version", "1.0.0");
        mainJson.put("appId", appId);
        mainJson.put("charset", charset);
        mainJson.put("signType", signType);
        mainJson.put("timestamp", GetNowTime.NowTime());//DateUtil.getStringFromDate(new Date(), "yyyyMMddHHmmss")
        mainJson.put("notifyUrl", "http://mock-api.com/dno4ooKX.mock/qqq");
        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("mhtSubAppId", "");//商户appId  非必填
        requestData.put("planId", "132263");//签约模板id 132263
        // 商户模板 131858 可测试H5签约 勿做交易
        requestData.put("payChannelType", "13");//渠道类型 13
        requestData.put("contractType", "03");//签约方式  01微信公众号签约 02微信H5签约 03小程序签约
          //H5签约： 将返回url进行URLEncode 拼接上以下地址
            //生产环境： https://pay.ipaynow.cn/deduct/h5contracttest?contracturl=
            //测试环境： https://dby.ipaynow.cn/deduct/h5contracttest?contracturl=

        requestData.put("mhtContractCode", GetNowTime.NowTime());//商户签约协议号 需要保证唯一性(这里使用当前时间值)，调用签约时需要记录该参数
        requestData.put("mhtContractDisplayName", "Ipaynow");//签约显示名称,这里建议使用英文，中文链接会导致链接不全
        requestData.put("mhtContractUserId", "");//商户签约用户标识 非必填
        requestData.put("returnWeb", "");//公众号签约回调标识
        // 1表示返回签约页面的referrer url,
        //0或不填或获取不到referrer则不返回
        requestData.put("callbackAppId", "");//H5签约回到appid 当指定该字段时，
        // 且商户模版标注商户具有指定返回app的权限时，
        //签约成功将返回return_appid指定的app应用，
        //如果不填且签约发起时的浏览器UA可被微信识别，
        //则跳转到浏览器，否则留在微信
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        System.out.println("请求结果：\n"+request);
        String signature = RSAUtils.sign(request.getBytes(), privateKey);
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(url, request, charset, signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = RSAUtils.verify(responseData.getBytes(), publicKey, backSignature);
        System.out.println("验证签名结果：" + flag);
        String res = JSON.toJSONString(Undecode_util.res(responseData));

        System.out.println("返回结果：" + res);
    }

    /**
     * 5.3 签约查询接口
     * trade.deduct.contract.query
     */
    @Test
    public void Test_Query_QianYue() throws Exception {
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.contract.query");
        mainJson.put("version", "1.0.0");
        mainJson.put("appId", appId);
        mainJson.put("charset", charset);
        mainJson.put("signType", signType);
        mainJson.put("timestamp", GetNowTime.NowTime());
        //mainJson.put("notifyUrl", "");
        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("contractId", "");//现在支付签约号 通过该字段或者下面字段进行查询
        requestData.put("planId", "132263");
        requestData.put("mhtContractCode", "20200707151629"); //调用签约生成的商户签约协议号，调用签约时需要记录该参数
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        String signature = RSAUtils.sign(request.getBytes(), privateKey);
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(url, request, charset, signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = RSAUtils.verify(responseData.getBytes(), publicKey, backSignature);
        System.out.println("验证签名结果：" + flag);
        System.out.println("返回结果：" + responseData);
    }

    /**
     * 5.4 解约接口
     * trade.deduct.contract.del
     */
    @Test
    public void Test_JieYue() throws Exception {
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.contract.del");
        mainJson.put("version", "1.0.0");
        mainJson.put("appId", appId);
        mainJson.put("charset", charset);
        mainJson.put("signType", signType);
        mainJson.put("timestamp", GetNowTime.NowTime());
        mainJson.put("notifyUrl", "http://mock-api.com/dno4ooKX.mock/qqq");//此通知地址需要兼容签约及解约

        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("mhtSubAppId", "");//商户appId 非必填
        requestData.put("planId", "132263");
        requestData.put("mhtContractCode", "20200707151629");
//        requestData.put("remark", "我要解约了"); //非必填
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        String signature = RSAUtils.sign(request.getBytes(), privateKey);
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(url, request, charset, signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = RSAUtils.verify(responseData.getBytes(), publicKey, backSignature);
        System.out.println("验证签名结果：" + flag);
        System.out.println("返回结果：" + responseData);
    }

    /**
     * 5.5 扣款申请接口
     * trade.deduct.order.payapply
     */
    @Test
    public void Test_KouKuan() throws Exception {
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.order.payapply");
        mainJson.put("version", "1.0.0");
        mainJson.put("appId", appId);
        mainJson.put("charset", charset);
        mainJson.put("signType", signType);
        mainJson.put("timestamp", GetNowTime.NowTime());
        mainJson.put("notifyUrl", "http://mock-api.com/0ZzRmXKe.mock/qqq");
        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("mhtSubAppId", "");//商户appId 非必填
        requestData.put("contractId", "200909144073"); //余额不足签约 200212000069 200401053936
        requestData.put("mhtOrderNo", "Trade_"+GetNowTime.NowTime());
        requestData.put("mhtOrderName", "商品名称001");
        requestData.put("mhtOrderDetail", "商品详情001");
        requestData.put("mhtOrderAmt", "3");
        requestData.put("feeType", "CNY");//货币类型  CNY 非必填
        requestData.put("payChannelType", "13");
        requestData.put("mhtReserved", "商户保留域");//商户保留域 非必填
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        String signature = RSAUtils.sign(request.getBytes(), privateKey);
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(url, request, charset, signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = RSAUtils.verify(responseData.getBytes(), publicKey, backSignature);
        System.out.println("验证签名结果：" + flag);
        System.out.println("返回结果：" + responseData);
    }

    /**
     * 5.7 扣款查询接口
     * trade.deduct.order.query
     */
    @Test
    public void Test_Query_KouKuan() throws Exception {
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.order.query");
        mainJson.put("version", "1.0.0");
        mainJson.put("appId", appId);
        mainJson.put("charset", charset);
        mainJson.put("signType", signType);
        mainJson.put("timestamp", GetNowTime.NowTime());
        mainJson.put("notifyUrl", "http://mock-api.com/0ZzRmXKe.mock/qqq");
        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("transId", "203501202007071511163038795");//transId 通过该字段或者下面字段查询扣款状态
        requestData.put("mhtOrderNo", "Trade_20200707151115");//唯一区分商户扣款交易
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        String signature = RSAUtils.sign(request.getBytes(), privateKey);
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(url, request, charset, signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = RSAUtils.verify(responseData.getBytes(), publicKey, backSignature);
        System.out.println("验证签名结果：" + flag);
        System.out.println("返回结果：" + responseData);
    }


    /*
        h5签约编码 - 将返回的URL进行Undecode编码之后进行拼接
     */
    @Test
    public void TestSign() throws Exception {
        String URL = Undecode_util.encode("https://payapp.weixin.qq.com/papay/readentrustwebtemplate?type=index&session_id=677569fe9d6fa323017930a0da0d015dc5a8dbf7793409faad2f3579eac28011&session_sign=861f94e06e95c2eeacff5c5997fb2552#/redirect");
//        System.out.println("https://dby.ipaynow.cn/deduct/h5contracttest?contracturl="+URL);//测试环境
        System.out.println("https://pay.ipaynow.cn/deduct/h5contracttest?contracturl="+URL);//生产环境

        //生产环境： https://pay.ipaynow.cn/deduct/h5contracttest?contracturl=
        //测试环境： https://dby.ipaynow.cn/deduct/h5contracttest?contracturl=
    }

}

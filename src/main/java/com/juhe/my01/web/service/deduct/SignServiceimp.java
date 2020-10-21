package com.juhe.my01.web.service.deduct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.juhe.my01.utils.GetNowTime;
import com.juhe.my01.utils.RSAUtils;
import com.juhe.my01.utils.StandardHttpClientUtil;
import com.juhe.my01.utils.Undecode_util;
import com.juhe.my01.web.model.dudect.SignModel;
import com.juhe.my01.web.model.dudect.SignModelQuery;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: SignServiceimp
 * Description:
 * date: 2020/9/8 15:20
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */

public class SignServiceimp {

    /**
     * 签约逻辑
     * @param signModel
     * @return
     */

    //测试及生产，无预发布
    public Map Sign(SignModel signModel) {
        JSONObject mainJson = new JSONObject();

        mainJson.put("funcode", "trade.deduct.contract");
        mainJson.put("version", signModel.getVersion());
        mainJson.put("appId", signModel.getAppId());
        mainJson.put("charset", "UTF-8");
        mainJson.put("signType", "RSA2");
        mainJson.put("timestamp", GetNowTime.NowTime());//DateUtil.getStringFromDate(new Date(), "yyyyMMddHHmmss")
        mainJson.put("notifyUrl", signModel.getNotifyUrl());
        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("mhtSubAppId", signModel.getMhtSubAppId());//商户appId  非必填
        requestData.put("planId", signModel.getPlanId());//签约模板id 132263
        // 商户模板 131858 可测试H5签约 勿做交易
        requestData.put("payChannelType", signModel.getPayChannelType());//渠道类型 13
        requestData.put("contractType", signModel.getContractType());//签约方式  01微信公众号签约 02微信H5签约 03小程序签约
        //H5签约： 将返回url进行URLEncode 拼接上以下地址
        //生产环境： https://pay.ipaynow.cn/deduct/h5contracttest?contracturl=
        //测试环境： https://dby.ipaynow.cn/deduct/h5contracttest?contracturl=

        requestData.put("mhtContractCode", GetNowTime.NowTime());//商户签约协议号 需要保证唯一性(这里使用当前时间值)，调用签约时需要记录该参数
        requestData.put("mhtContractDisplayName", signModel.getMhtContractDisplayName());//签约显示名称,这里建议使用英文，中文链接会导致链接不全
        requestData.put("mhtContractUserId", signModel.getMhtContractUserId());//商户签约用户标识 非必填
        requestData.put("returnWeb", signModel.getReturnWeb());//公众号签约回调标识
        // 1表示返回签约页面的referrer url,
        //0或不填或获取不到referrer则不返回
        requestData.put("callbackAppId", signModel.getCallbackAppId());//H5签约回到appid 当指定该字段时，
        // 且商户模版标注商户具有指定返回app的权限时，
        //签约成功将返回return_appid指定的app应用，
        //如果不填且签约发起时的浏览器UA可被微信识别，
        //则跳转到浏览器，否则留在微信
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        System.out.println("请求结果：\n" + request);
        String signature = null;
        try {
            signature = RSAUtils.sign(request.getBytes(), signModel.getPrivateKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(signModel.getUrl(), request, "UTF-8", signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = false;
        try {
            flag = RSAUtils.verify(responseData.getBytes(), signModel.getPublicKey(), backSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = Undecode_util.res(responseData);
        Map map = new HashMap();
        map.put("request", JSON.toJSONString(mainJson,true));
        map.put("response",result);

        //提取H5和公众号支付链接
        JsonParser jp = new JsonParser();
        JsonObject jo = jp.parse(result).getAsJsonObject();
        if(signModel.getContractType().equals("01")){
            String redirectUrl = jo.get("responseData").getAsJsonObject().get("redirectUrl").getAsString();
            map.put("img",redirectUrl);
        }else if(signModel.getContractType().equals("02")){
            String redirectUrl = jo.get("responseData").getAsJsonObject().get("redirectUrl").getAsString();
            if(signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")){
                map.put("img","https://dby.ipaynow.cn/deduct/h5contracttest?contracturl="+redirectUrl);
            }else {
                map.put("img","https://pay.ipaynow.cn/deduct/h5contracttest?contracturl="+redirectUrl);
            }
        }else {
            map.put("img","");
        }
        return map;
    }

    /**
     * 签约查询接口
     * @param signModelQuery
     * @return
     */
    public Map SignQuery(SignModelQuery signModelQuery){
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.contract.query");
        mainJson.put("version", signModelQuery.getVersion());
        mainJson.put("appId", signModelQuery.getAppId());
        mainJson.put("charset", "UTF-8");
        mainJson.put("signType", "RSA2");
        mainJson.put("timestamp", GetNowTime.NowTime());
        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("contractId", signModelQuery.getContractId());//现在支付签约号 通过该字段或者下面字段进行查询
        requestData.put("planId", signModelQuery.getPlanId());
        requestData.put("mhtContractCode", signModelQuery.getMhtContractCode()); //调用签约生成的商户签约协议号，调用签约时需要记录该参数
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        String signature = null;
        try {
            signature = RSAUtils.sign(request.getBytes(), signModelQuery.getPrivateKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(signModelQuery.getUrl(), request, "UTF-8", signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = false;
        try {
            flag = RSAUtils.verify(responseData.getBytes(), signModelQuery.getPublicKey(), backSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("验证签名结果：" + flag);
        System.out.println("返回结果：" + responseData);
        Map map = new HashMap();
        map.put("request", JSON.toJSONString(mainJson,true));
        map.put("response",responseData);
        map.put("img","");
        return map;
    }


    public Map Unbundle(SignModelQuery signModelQuery){
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.contract.del");
        mainJson.put("version", signModelQuery.getVersion());
        mainJson.put("appId", signModelQuery.getAppId());
        mainJson.put("charset", "UTF-8");
        mainJson.put("signType", "RSA2");
        mainJson.put("timestamp", GetNowTime.NowTime());
        mainJson.put("notifyUrl", signModelQuery.getNotifyUrl());//此通知地址需要兼容签约及解约

        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("mhtSubAppId", signModelQuery.getMhtSubAppId());//商户appId 非必填
        requestData.put("planId", signModelQuery.getPlanId());
        requestData.put("mhtContractCode", signModelQuery.getMhtContractCode());
//        requestData.put("remark", "我要解约了"); //非必填
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        String signature = null;
        try {
            signature = RSAUtils.sign(request.getBytes(), signModelQuery.getPrivateKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(signModelQuery.getUrl(), request, "UTF-8", signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = false;
        try {
            flag = RSAUtils.verify(responseData.getBytes(), signModelQuery.getPublicKey(), backSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("request", JSON.toJSONString(mainJson,true));
        map.put("response",responseData);
        map.put("img","");
        return map;
    }

}

package com.juhe.my01.web.service.juhe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.ActiveScan;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import com.juhe.my01.web.model.juhe.ActiveModel;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ActiveService
 * Description:
 * date: 2020/9/2 10:38
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class ActiveService {

    public Map<String, String> Active(ActiveModel activeModel) {

        //拼接请求参数Wp001
        JSONObject wp001 = ActiveScan.ActiveScanModel();
        wp001.put("canal", "WP001");//渠道
        wp001.put("url", activeModel.getUrl());//请求地址
        wp001.put("appId", activeModel.getAppId());//应用ID
        wp001.put("appKey", activeModel.getAppKey());//应用Key
        wp001.put("payChannelType", activeModel.getPayChannelType());
        wp001.put("mhtLimitPay", activeModel.getMhtLimitPay());
        wp001.put("version", activeModel.getVersion());
        wp001.put("mhtOrderAmt", activeModel.getMhtOrderAmt());
        wp001.put("outputType", activeModel.getOutputType());// 0 返回二维码  1 返回支付链接
        wp001.put("mhtOrderName", activeModel.getMhtOrderName());
        wp001.put("mhtOrderDetail", activeModel.getMhtOrderDetail());
        wp001.put("mhtOrderTimeOut", activeModel.getMhtOrderTimeOut());
        wp001.put("notifyUrl", activeModel.getNotifyUrl());
        JSONObject ob = new JSONObject();
        JSONObject res = new JSONObject();

        JSONObject mq002 = ActiveScan.QueryActive();
        mq002.put("canal", "MQ002");//渠道
        mq002.put("url", activeModel.getUrl());//请求地址
        mq002.put("version", activeModel.getVersion());
        mq002.put("appId", activeModel.getAppId());
        mq002.put("appKey", activeModel.getAppKey());//应用Key
        mq002.put("mhtOrderNo", wp001.get("mhtOrderNo"));

        //判断新老版本号，进行MD验签操作
        if (activeModel.getVersion().equals("1.0.0")) {
            ob = API_Version.RequestApi(wp001);
            res = API_Version.RequestApi(mq002);
        } else {
            ob = API_NoVer.RequestApi(wp001);
            res = API_NoVer.RequestApi(mq002);
        }
        //使用undecode解密返回报文
        String img = Undecode_util.res(ob.getString("body"));
        System.out.println(img);
        String response = Undecode_util.res(res.getString("body"));
        //封装数据报文
        Map<String, String> result = new HashMap<>();
        result.put("request", JSON.toJSONString(wp001, true));
        result.put("response", JSON.toJSONString(SpiltSpringUtil.StringToJson(response),true));
        result.put("img", SpiltSpringUtil.JsonSys_resp(img));
        result.put("state", activeModel.getOutputType());

        return result;
    }


}

package com.juhe.my01.web.service.juhe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.WeChatModel;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import com.juhe.my01.web.model.juhe.WeChatPayModel;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: WeChatService
 * Description:
 * date: 2020/9/2 10:38
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class WeChatService {

    public Map<String, String> WeChatPay(WeChatPayModel weChatPayModel) {

        //拼接请求参数Wp001
        JSONObject wp001 = WeChatModel.WcChat_applet();
        wp001.put("canal", "WP001");//渠道
        wp001.put("url", weChatPayModel.getUrl());//请求地址
        wp001.put("appId", weChatPayModel.getAppId());//应用ID
        wp001.put("appKey", weChatPayModel.getAppKey());//应用Key
        wp001.put("payChannelType", weChatPayModel.getPayChannelType());
        wp001.put("mhtLimitPay", weChatPayModel.getMhtLimitPay());
        wp001.put("version", weChatPayModel.getVersion());
        wp001.put("mhtOrderAmt", weChatPayModel.getMhtOrderAmt());
        wp001.put("mhtOrderName", weChatPayModel.getMhtOrderName());
        wp001.put("mhtOrderDetail", weChatPayModel.getMhtOrderDetail());
        wp001.put("mhtOrderTimeOut", weChatPayModel.getMhtOrderTimeOut());
        wp001.put("notifyUrl", weChatPayModel.getNotifyUrl());
        wp001.put("consumerId", weChatPayModel.getConsumerId());
        wp001.put("mhtSubAppId", weChatPayModel.getMhtSubAppId());
        JSONObject ob = new JSONObject();
        JSONObject res = new JSONObject();

        JSONObject mq002 = WeChatModel.QueryWx_Model();
        mq002.put("canal", "MQ002");//渠道
        mq002.put("url", weChatPayModel.getUrl());//请求地址
        mq002.put("version", weChatPayModel.getVersion());
        mq002.put("appId", weChatPayModel.getAppId());
        mq002.put("appKey", weChatPayModel.getAppKey());//应用Key
        mq002.put("mhtOrderNo", wp001.get("mhtOrderNo"));

        //判断新老版本号，进行MD验签操作
        if (weChatPayModel.getVersion().equals("1.0.0")) {
            ob = API_Version.RequestApi(wp001);
            res = API_Version.RequestApi(mq002);
        } else {
            ob = API_NoVer.RequestApi(wp001);
            res = API_NoVer.RequestApi(mq002);
        }
        //使用undecode解密返回报文
        String img = Undecode_util.res(ob.getString("body"));
        String response = Undecode_util.res(res.getString("body"));
        //封装数据报文
        Map<String, String> result = new HashMap<>();
        result.put("request", JSON.toJSONString(wp001, true));
        System.out.println(response);
        result.put("response", response);
        result.put("state", response);
        result.put("img", SpiltSpringUtil.JsonSys_resp(img));
        return result;
    }


}

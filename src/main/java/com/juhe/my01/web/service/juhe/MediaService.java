package com.juhe.my01.web.service.juhe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Model_JuHeMa;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import com.juhe.my01.web.model.juhe.MediaModel;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MediaService
 * Description:
 * date: 2020/9/2 10:38
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class MediaService {

    public Map<String,String> Media(MediaModel mediaModel){

        //拼接请求参数WP001
        JSONObject wp001 = Model_JuHeMa.JuHeMa_WP001();
        wp001.put("canal", "WP001");//渠道
        wp001.put("url", mediaModel.getUrl());//请求地址
        wp001.put("appId", mediaModel.getAppId());//应用ID
        wp001.put("appKey", mediaModel.getAppKey());//应用Key
        wp001.put("mhtLimitPay", mediaModel.getMhtLimitPay());
        wp001.put("version", mediaModel.getVersion());
        wp001.put("mhtOrderAmt",mediaModel.getMhtOrderAmt());
        wp001.put("outputType", mediaModel.getOutputType());// 0 返回二维码  1 返回支付链接
        wp001.put("mhtOrderName",mediaModel.getMhtOrderName());
        wp001.put("mhtOrderDetail",mediaModel.getMhtOrderDetail());
        wp001.put("mhtOrderTimeOut",mediaModel.getMhtOrderTimeOut());
        wp001.put("notifyUrl",mediaModel.getNotifyUrl());
        JSONObject ob = new JSONObject();
        JSONObject res = new JSONObject();
        //拼接MQ002
        JSONObject mq002 = Model_JuHeMa.JuHeMa_MQ002();
        mq002.put("canal", "联动");//渠道
        mq002.put("url", mediaModel.getUrl());//请求地址
        mq002.put("appId", mediaModel.getAppId());//应用ID
        mq002.put("appKey", mediaModel.getAppKey());//应用Key
        mq002.put("version",mediaModel.getVersion());
        mq002.put("mhtOrderNo",wp001.get("mhtOrderNo"));

        //判断新老版本号，进行MD验签操作
        if(mediaModel.getVersion().equals("1.0.0")){
             ob = API_Version.RequestApi(wp001);
            res = API_Version.RequestApi(mq002);
        }else {
            ob = API_NoVer.RequestApi(wp001);
            res = API_NoVer.RequestApi(mq002);
        }
        //使用undecode解密返回报文
        String img = Undecode_util.res(ob.getString("body"));
        String response = Undecode_util.res(res.getString("body"));
        //封装数据报文
        Map<String,String> result = new HashMap<>();
        result.put("request", JSON.toJSONString(wp001,true));
        result.put("response",response);
        result.put("img", SpiltSpringUtil.JsonSys_resp(img));
        result.put("state", mediaModel.getOutputType());
        return result;
    }


}

package com.juhe.my01.web.service.juhe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Model_JuHeMa;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import com.juhe.my01.web.model.juhe.MediaJuHeMaModel;

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
public class MediaJuHeMaService {

    public Map<String,String> Media(MediaJuHeMaModel mediaJuHeMaModel){

        //拼接请求参数WP001
        JSONObject wp001 = Model_JuHeMa.JuHeMa_WP001();
        wp001.put("canal", "WP001");//渠道
        wp001.put("url", mediaJuHeMaModel.getUrl());//请求地址
        wp001.put("appId", mediaJuHeMaModel.getAppId());//应用ID
        wp001.put("appKey", mediaJuHeMaModel.getAppKey());//应用Key
        wp001.put("mhtLimitPay", mediaJuHeMaModel.getMhtLimitPay());
        wp001.put("version", mediaJuHeMaModel.getVersion());
        wp001.put("mhtOrderAmt",mediaJuHeMaModel.getMhtOrderAmt());
        wp001.put("outputType", mediaJuHeMaModel.getOutputType());// 0 返回二维码  1 返回支付链接
        wp001.put("mhtOrderName",mediaJuHeMaModel.getMhtOrderName());
        wp001.put("mhtOrderDetail",mediaJuHeMaModel.getMhtOrderDetail());
        wp001.put("mhtOrderTimeOut",mediaJuHeMaModel.getMhtOrderTimeOut());
        wp001.put("notifyUrl",mediaJuHeMaModel.getNotifyUrl());
        wp001.put("payChannelType",mediaJuHeMaModel.getPayChannelType());
        JSONObject ob = new JSONObject();
        JSONObject res = new JSONObject();
        //拼接MQ002
        JSONObject mq002 = Model_JuHeMa.JuHeMa_MQ002();
        mq002.put("canal", "联动");//渠道
        mq002.put("url", mediaJuHeMaModel.getUrl());//请求地址
        mq002.put("appId", mediaJuHeMaModel.getAppId());//应用ID
        mq002.put("appKey", mediaJuHeMaModel.getAppKey());//应用Key
        mq002.put("version",mediaJuHeMaModel.getVersion());
        mq002.put("mhtOrderNo",wp001.get("mhtOrderNo"));

        //判断新老版本号，进行MD验签操作
        if(mediaJuHeMaModel.getVersion().equals("1.0.0")){
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
        result.put("response", JSON.toJSONString(SpiltSpringUtil.StringToJson(response),true));
        result.put("img", SpiltSpringUtil.JsonSys_resp(img));
        result.put("state", mediaJuHeMaModel.getOutputType());
        return result;
    }


}

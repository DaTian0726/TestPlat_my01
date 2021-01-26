package com.juhe.my01.web.service.juhe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Barcode;
import com.juhe.my01.toapi.API_NoVer;
import com.juhe.my01.toapi.API_Version;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import com.juhe.my01.web.model.juhe.BarcodeModel;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BarcodeService
 * Description:
 * date: 2020/9/2 10:38
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class BarcodeService {

    public Map<String,String> Barcode(BarcodeModel barcodeModel){

        //拼接请求参数
        JSONObject js = Barcode.WP001Vars();
        js.put("canal", "测试");
        js.put("url", barcodeModel.getUrl());
        js.put("appId", barcodeModel.getAppId());
        js.put("appKey", barcodeModel.getAppKey());
        js.put("payChannelType", barcodeModel.getPayChannelType());
        js.put("mhtLimitPay", barcodeModel.getMhtLimitPay());
        js.put("version", barcodeModel.getVersion());
        js.put("mhtOrderAmt",barcodeModel.getMhtOrderAmt());
        js.put("mhtOrderName",barcodeModel.getMhtOrderName());
        js.put("mhtOrderDetail",barcodeModel.getMhtOrderDetail());
        js.put("mhtOrderTimeOut",barcodeModel.getMhtOrderTimeOut());
        js.put("notifyUrl",barcodeModel.getNotifyUrl());
        js.put("channelAuthCode",barcodeModel.getChannelAuthCode());
        js.put("mhtStoreId",barcodeModel.getMhtStoreId());
        js.put("mhtTermId",barcodeModel.getMhtTermId());
        JSONObject ob = new JSONObject();
        //判断新老版本号，进行MD验签操作
        if(barcodeModel.getVersion().equals("1.0.0")){
             ob = API_Version.RequestApi(js);
        }else {
            ob = API_NoVer.RequestApi(js);
        }
        //使用undecode解密返回报文
        String response = Undecode_util.res(ob.getString("body"));
        //封装数据报文
        Map<String,String> result = new HashMap<>();
        result.put("request", JSON.toJSONString(js,true));
        result.put("response", JSON.toJSONString(SpiltSpringUtil.StringToJson(response),true));
        result.put("img", SpiltSpringUtil.JsonSys_resp(response));
        result.put("state","");
        return result;
    }


}

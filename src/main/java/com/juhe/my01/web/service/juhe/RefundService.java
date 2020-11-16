package com.juhe.my01.web.service.juhe;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Model_Refund;
import com.juhe.my01.toapi.ToRefund;
import com.juhe.my01.utils.SpiltSpringUtil;
import com.juhe.my01.utils.Undecode_util;
import com.juhe.my01.web.model.juhe.RefundModel;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: RefundService
 * Description:
 * date: 2020/9/2 10:38
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class RefundService {

    public Map<String,String> Refund(RefundModel refundModel){

        //拼接请求参数
        JSONObject js = Model_Refund.Refund_Var();
        js.put("canal", "退款测试");//渠道
        js.put("url", refundModel.getUrl());
        js.put("appId", refundModel.getAppId());//应用ID
        js.put("appKey", refundModel.getAppKey());//应用Key
        js.put("mhtOrderNo", refundModel.getMhtOrderNo());
        if (!refundModel.getOriTransId().equals("")){
            js.put("oriTransId", refundModel.getOriTransId());
        }else {
            js.remove("oriTransId");
        }
        js.put("version", refundModel.getVersion());
        js.put("mhtRefundNo",refundModel.getMhtRefundNo());
        js.put("amount", refundModel.getAmount());
        js.put("funcode",refundModel.getFuncode());
        js.put("notifyUrl",refundModel.getNotifyUrl());
        JSONObject ob = ToRefund.RequestApi(js);
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

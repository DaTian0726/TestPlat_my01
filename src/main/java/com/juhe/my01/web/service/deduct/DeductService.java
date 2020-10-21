package com.juhe.my01.web.service.deduct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.GetNowTime;
import com.juhe.my01.utils.RSAUtils;
import com.juhe.my01.utils.StandardHttpClientUtil;
import com.juhe.my01.web.model.dudect.DeductModel;
import com.juhe.my01.web.model.dudect.DeductModelQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * ClassName: deductService
 * Description:
 * date: 2020/9/9 15:43
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */

@RestController
@RequestMapping
public class DeductService {

    /**
     * 扣款接口
     * @param deductModel
     * @return
     */

    public Map Deduct(DeductModel deductModel){
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.order.payapply");
        mainJson.put("version", "1.0.0");
        mainJson.put("appId", deductModel.getAppId());
        mainJson.put("charset", "UTF-8");
        mainJson.put("signType", "RSA2");
        mainJson.put("timestamp", GetNowTime.NowTime());
        mainJson.put("notifyUrl", deductModel.getNotifyUrl());
        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("mhtSubAppId", deductModel.getMhtSubAppId());//商户appId 非必填
        requestData.put("contractId", deductModel.getContractId()); //余额不足签约 200212000069 200401053936
        requestData.put("mhtOrderNo", deductModel.getMhtOrderNo());
        requestData.put("mhtOrderName", deductModel.getMhtOrderName());
        requestData.put("mhtOrderDetail", deductModel.getMhtOrderDetail());
        requestData.put("mhtOrderAmt", deductModel.getMhtOrderAmt());
        requestData.put("feeType", "CNY");//货币类型  CNY 非必填
        requestData.put("payChannelType", deductModel.getPayChannelType());
        requestData.put("mhtReserved", deductModel.getMhtReserved());//商户保留域 非必填
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        String signature = null;
        try {
            signature = RSAUtils.sign(request.getBytes(), deductModel.getPrivateKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(deductModel.getUrl(), request,"UTF-8", signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = false;
        try {
            flag = RSAUtils.verify(responseData.getBytes(), deductModel.getPublicKey(), backSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("request", JSON.toJSONString(mainJson,true));
        map.put("response",responseData);
        map.put("img","");
        return map;
    }

    public Map DeductQuery(DeductModelQuery deductModelQuery){
        JSONObject mainJson = new JSONObject();
        mainJson.put("funcode", "trade.deduct.order.query");
        mainJson.put("version", deductModelQuery.getVersion());
        mainJson.put("appId", deductModelQuery.getAppId());
        mainJson.put("charset", "UTF-8");
        mainJson.put("signType", "RES2");
        mainJson.put("timestamp", GetNowTime.NowTime());
        mainJson.put("notifyUrl", deductModelQuery.getNotifyUrl());
        //构建业务参数：
        JSONObject requestData = new JSONObject();
        requestData.put("transId", deductModelQuery.getTransId());//transId 通过该字段或者下面字段查询扣款状态
        requestData.put("mhtOrderNo", deductModelQuery.getMhtOrderNo());//唯一区分商户扣款交易
        mainJson.put("requestData", requestData);
        String request = mainJson.toJSONString();
        String signature = null;
        try {
            signature = RSAUtils.sign(request.getBytes(), deductModelQuery.getPrivateKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //带验签的请求
        Map<String, String> resultMap = StandardHttpClientUtil.sendHttpsPostBackMap(deductModelQuery.getUrl(), request, "UTF-8", signature);
        String responseData = resultMap.get("responseData");
        String backSignature = resultMap.get("signature");
        boolean flag = false;
        try {
            flag = RSAUtils.verify(responseData.getBytes(), deductModelQuery.getPublicKey(), backSignature);
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

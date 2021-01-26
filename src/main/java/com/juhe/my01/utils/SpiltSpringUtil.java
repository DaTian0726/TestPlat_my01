package com.juhe.my01.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

public class SpiltSpringUtil {

    /**
     * 打印json格式的数据
     * 前提：字符串格式要为键值对的方式   ’key‘ = ’value‘  使用 ‘&’ 进行拼接
     * @param
     * @return
     */

    public static String JsonSys_resp(String res) {
        String[] resp =  res.split("&");
        for (int i = 0;i<resp.length;i++){
            if(resp[i].indexOf("tn=")!=-1){
                return resp[i].substring(3);
            }
        }
        return "";
    }

    public static JSON StringToJson(String a){
        JSONObject jsonObject = new JSONObject();
        String[] resp = a.split("&");
        for (int i = 0;i<resp.length;i++){
            String[] res = resp[i].split("=");
            if(res.length == 1){
                jsonObject.put(res[0],"");
            }else{
                jsonObject.put(res[0],res[1]);
            }

        }
        return jsonObject;
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(StringToJson("amount=1&appId=154831563347656&funcode=R001&mhtCharset=UTF-8&mhtOrderNo=20200922165617Test&mhtRefundNo=20201117140547Refund&nowPayOrderNo=&reason=refund-test&responseCode=R026&responseMsg=商户应用ID不正确&responseTime=20201117140630&signType=MD5&signature=&tradeStatus=A002&version=1.0.0"),true));

    }
}

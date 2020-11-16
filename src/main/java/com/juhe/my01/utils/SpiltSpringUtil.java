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
            jsonObject.put(res[0],res[1]);
        }
        return jsonObject;
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(StringToJson("funcode=WP001&signature=1ba50c549ad2a909821721a4249b33c0&responseTime=20200903161647&mhtOrderNo=20200903161646Test&appId=148972242878838&signType=MD5&nowPayOrderNo=c200601202009031616453785785&tn=https://qr.alipay.com/bax083828y8cptsvcqzg002b&version=1.0.0&responseCode=A001&responseMsg=E000#成功[成功]"),true));

    }
}

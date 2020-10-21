package com.juhe.my01.toapi;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.AddMd5Version;
import com.juhe.my01.utils.ToPostUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class API_Version {

    public static JSONObject RequestApi(JSONObject jsonObject) {
        JSONObject object=jsonObject;
        //进行MD5加签，获取请求串
        String url=object.getString("url");
        //使用带版本号加签方式
        String pars = AddMd5Version.AddMd5(object);
        //请求api：
        JSONObject res = ToPostUtil.doPostOkHttp(url, pars);

//        if(!object.containsKey("outputType") || object.getString("outputType").equals("") || object.getString("outputType").trim().length()==0){
//            try {
//                res = URLDecoder.decode(res, "UTF-8");
//                return res;
//            } catch (UnsupportedEncodingException e) {
//                logger.info("(转码错误",e);
//            }
//        }else{
//            if (object.get("outputType").equals("1")) {
//                //decode转码
//                try {
//                     res = URLDecoder.decode(res, "UTF-8");
//                    return res;
//                } catch (UnsupportedEncodingException e) {
//                    logger.info("(转码错误",e);
//                }
//            }
//            if (object.get("outputType").equals("0")) {
//                return res;
//            }
//            if (object.get("outputType").equals("2")) {
//                //进行base64解码-----聚合码使用
//                return res;
//            }
//        }
        return res;
    }
}

package com.juhe.my01.monitor;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.utils.AddMd5Version;
import com.juhe.my01.utils.ToPostUtil;

public class MonitorTest {
    public static JSONObject ResMon(JSONObject js){
        String url= (String) js.remove("url");
        String req= AddMd5Version.PaiXu(js);
        //根据请求参数生成报警日志
        JSONObject res=ToPostUtil.ToGet(url+"?"+req);
        System.out.println("请求内容：\n"+req);
        return res;
    }
}

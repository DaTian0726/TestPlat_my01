package com.juhe.my01.utils;

import com.alibaba.fastjson.JSONObject;
public class TestSign {

    public static String CheckSignMD5(String res, String Key) {
        String sign = "";
        JSONObject jsonObject = StringToJson(res); //appKey
        //提取并移除返回报文中的 签名
        String signature = (String) jsonObject.remove("signature");
        //将原下单的应用Kay赋值到返回的报文中
        jsonObject.put("appKey", Key);
        //进行加签  ----判断是否有版本号
        if (jsonObject.containsKey("version")) {
            System.out.println("带版本号");
            String pars = Sign_V.AddSign_V(jsonObject);
            System.out.println("-------"+pars);
            sign = StringToJson(pars).getString("signature");
        } else {
            System.out.println("不带版本号");
            String pars  =Sign_noV.SignAddMd5_noV(jsonObject);
            System.out.println("-------"+pars);
            sign = StringToJson(pars).getString("signature");
        }
        if (sign.equals(signature)) {
            return "验签成功";
        } else {
            System.out.println("原始签名：" + signature);
            System.out.println("\n新签名：" + sign);
            return "验签失败";
        }
    }

    /**
     * 将String串（key+value&...格式）转换为Json对象
     *
     * @param res
     * @return
     */
    public static JSONObject StringToJson(String res) {
        JSONObject jsonObject = new JSONObject();
        String[] str = res.split("&");
        for (String strTmp : str) {
            jsonObject.put(strTmp.substring(0, strTmp.indexOf("=")), Undecode_util.res(strTmp.substring(strTmp.indexOf("=") + 1)));
        }
        return jsonObject;
    }
}
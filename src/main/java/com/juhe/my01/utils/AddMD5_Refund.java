package com.juhe.my01.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AddMD5_Refund {
    public static String AddMd5(JSONObject js) {
        //提取出Map中的AppKey
        String appKey = (String) js.get("appKey");
        //删除Map中的多余参数
        js.remove("appKey");
        js.remove("signType");
        js.remove("mhtSignature");
        js.remove("canal");
        js.remove("url");
        if(js.getString("funcode").equals("R001") || js.getString("funcode").equals("R002") )
        if (js.getString("notifyUrl").equals("")) {
            js.remove("version");//去除版本号
        }
        //进行排序
        String toMd5Str = PaiXu(js);
        //进行MD5加密,获得签名
        String sign = ToMd5(toMd5Str + "&" + ToMd5(appKey));
        //在map中加入签名
        js.put("mhtSignature", sign);
        //加入其它参数：
        js.put("signType", "MD5");
        //再次排序
        String pars = PaiXu(js);
//        System.out.println(toMd5Str + "&" + ToMd5(appKey));
        return pars;
    }

    /**
     * 将Map，转换为String字符串，并进行排序
     */
    public static String PaiXu(Map map) {
        //将Map转为List进行排序
        Set<String> keySet = map.keySet();
        List<String> keyList = new ArrayList<String>(keySet);
        Collections.sort(keyList);
        StringBuilder strB = new StringBuilder();
        for (String key : keyList) {
            String value = (String) map.get(key);
            if (StringUtils.isNotBlank(value)) {
                strB.append(key + "=" + value + "&");
            }
        }
        String toMd5Str = strB.deleteCharAt(strB.length() - 1).toString();
        return toMd5Str;
    }

    /**
     * MD5加签的方法
     */
    public static String ToMd5(String toMd5Str) {
        //进行MD5加密
        if (toMd5Str == null || toMd5Str.length() == 0) {
            throw new IllegalArgumentException("加密串为空，长度为0");
        }
        StringBuilder hexStr = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(toMd5Str.getBytes());
            byte[] hash = md.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexStr.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexStr.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexStr.toString();
    }
}

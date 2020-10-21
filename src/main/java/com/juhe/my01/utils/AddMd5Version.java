package com.juhe.my01.utils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AddMd5Version {
    /**
     * 获取加签后的请求串
     */
    public static String AddMd5(JSONObject object) {
        JSONObject js=new JSONObject(object);
        //提取出Map中的AppKey
        String appKey = (String) js.get("appKey");
        //删除Map中的多余参数
        js.remove("appKey");
        js.remove("mhtSignature");
        js.remove("canal");
        js.remove("url");
        //进行排序
        String toMd5Str = PaiXu(js);
        //进行MD5加密,获得签名
        String sign = ToMd5(toMd5Str + "&" + ToMd5(appKey));
        //在map中加入签名
        object.put("mhtSignature",sign);
        //再次排序
        String pars=PaiXu(js);
//        System.out.println(toMd5Str + "&" + ToMd5(appKey));
        return pars;
    }

    /**
     * 转换为String字符串，并进行排序
     */
    public static String PaiXu(JSONObject object) {
        //将Map转为List进行排序
        Set<String> keySet = object.keySet();
        List<String> keyList = new ArrayList<String>(keySet);
        Collections.sort(keyList);
        StringBuilder strB = new StringBuilder();
        for (String key : keyList) {
            String value = (String) object.get(key);
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
            System.out.println("错误"+e);
        }
        return hexStr.toString();
    }
}

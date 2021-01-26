package com.juhe.my01.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AddMd5NoV {
    /**
     * 获取加签后的请求串---不带版本号
     * 需要先去掉  signType
     */
    public static String AddMd5(JSONObject js) {
        //删除Map中的多余参数
        String appKey = (String) js.remove("appKey");
        js.remove("mhtSignType");
        js.remove("mhtSignature");
        js.remove("canal");
        js.remove("url");
        js.remove("version");//去除版本号
        String funcode = (String) js.remove("funcode");
        String deviceType = (String) js.remove("deviceType");
        //进行排序
        String toMd5Str = PaiXu(js);
        //进行MD5加密,获得签名
        String sign = ToMd5(toMd5Str + "&" + ToMd5(appKey));
        //将签名类型放入json对象中
        js.put("mhtSignType", "MD5");
        js.put("funcode", funcode);
        //在map中加入签名
        js.put("mhtSignature", sign);
        js.put("deviceType", deviceType);
        //再次排序
        String pars = PaiXu(js);
//        System.out.println(object.toString());
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
            System.out.println("错误" + e);
        }
        return hexStr.toString();
    }
}

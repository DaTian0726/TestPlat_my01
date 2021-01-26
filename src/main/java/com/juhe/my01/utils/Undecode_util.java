package com.juhe.my01.utils;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Undecode_util {


    public static String res(String res){
        try {
            res = URLDecoder.decode(res, "UTF-8");
            return res;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public static String encode(String res){
        try {
            res = URLEncoder.encode(res, "UTF-8");
            return res;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  null;
    }

}

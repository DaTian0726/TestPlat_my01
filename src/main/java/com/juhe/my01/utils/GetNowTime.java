package com.juhe.my01.utils;

import org.testng.annotations.Test;

import java.text.MessageFormat;

public class GetNowTime {
    /**
     * @return 当前时间值
     */
    public static String NowTime(){
        String data = MessageFormat.format("{0,date,yyyyMMddHHmmss}", new java.sql.Date(System.currentTimeMillis()));
        return data;
    }

    /**
     * 时间格式装换
     * @return
     */
    public static String ToNowTime(String time){
        return time.substring(0,4) + "-" + time.substring(4,6) + "-" + time.substring(6,8) + " " + time.substring(8,10) + ":" + time.substring(10,12) + ":" + time.substring(12,14);
    }

}

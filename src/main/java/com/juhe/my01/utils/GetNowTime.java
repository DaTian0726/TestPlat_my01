package com.juhe.my01.utils;

import java.text.MessageFormat;

public class GetNowTime {
    /**
     * @return 当前时间值
     */
    public static String NowTime(){
        String data = MessageFormat.format("{0,date,yyyyMMddHHmmss}", new java.sql.Date(System.currentTimeMillis()));
        return data;
    }
}

package com.juhe.my01.web.controller;

/**
 * ClassName: URLEnum
 * Description:
 * date: 2020/9/11 21:00
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */

public enum URLEnum {

    JUHE_TEST("https://dby.ipaynow.cn/api/payment/","公有云测试环境"),
    JUHE_PRE("https://pay.ipaynow.cn/api_release/","公有云预发布环境"),
    JUHE_LINE("https://pay.ipaynow.cn/","公有云生产环境"),
    CMB_TEST("https://cmb-test-payapi.ipaynow.cn/api/payment/","招商云测试环境"),
    CMB_PRE("https://ipaynow.acquire.cmbchina.com/api_release/","招商云预发布环境"),
    CMB_LINE("https://ipaynow.acquire.cmbchina.com/","招商云生产环境"),
    ;

    URLEnum(String URl, String describe) {
        this.URl = URl;
        this.describe = describe;
    }

    public String getURl() {
        return URl;
    }

    public void setURl(String URl) {
        this.URl = URl;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    private String URl;
    private String describe;



}

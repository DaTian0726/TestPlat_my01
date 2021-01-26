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
    ZG_TEST("http://pay.houyuwei.com/api/payment/","紫光云测试环境"),
    ZG_LINE("https://payapi.iqc-app.com","紫光云生产环境"),
    JUHE_REFUND_LINE("https://pay.ipaynow.cn/refund/refundOrder","公有云退款生产环境"),
    JUHE_REFUND_PRE("https://pay.ipaynow.cn/api_release/refund/refundOrder","公有云退款预发布环境"),
    JUHE_REFUND_TEST("http://192.168.99.54:8790/refund_access/refundOrder","公有云退款测试环境"),
    CMB_REFUND_LINE("https://ipaynow.acquire.cmbchina.com/refund/refundOrder","招商云退款生产环境"),
    CMB_REFUND_PRE("https://ipaynow.acquire.cmbchina.com/api_release/refund/refundOrder","招商云退款预发布环境"),
    CMB_REFUND_TEST("http://192.168.105.5:8780/cmb_refund_access/refundOrder","招商云退款测试环境"),
    ZG_REFUND_TEST("http://pay.houyuwei.com/refund/refundOrder","紫光云退款测试环境"),
    zg_refund_line("https://payapi.iqc-app.com/refund/refundOrder","紫光云退款生产环境")
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

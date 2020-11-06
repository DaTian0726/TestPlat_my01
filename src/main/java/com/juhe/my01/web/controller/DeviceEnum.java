package com.juhe.my01.web.controller;

/**
 * ClassName: DeviceEnum
 * Description:
 * date: 2020/11/6 16:28
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public enum DeviceEnum {
    SDKPay("01","手机SDK"),
    BarCodePay("05","被扫系统"),
    ActivePay("08","主扫系统"),
    JuheMaPay("20","聚合码系统"),
    WeChatPay("14","小程序系统"),
    CardPay("0603","公众号系统"),
    H5Pay("0601","H5系统");

    private String deviceType;
    private String des;

    DeviceEnum(String deviceType, String des) {
        this.deviceType = deviceType;
        this.des = des;
    }

    public String getDeviceType() {
        return deviceType;
    }


    public String getDes() {
        return des;
    }

}

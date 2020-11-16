package com.juhe.my01.web.controller;

public enum ChannelTypeEnum {
    AliPay("12", "支付宝"),
    WeChat("13", "微信"),
    UnionScanPay("27", "银联扫码"),
    UnionAllChannel("20", "银联全渠道");

    private String value;
    private String desc;

    ChannelTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

        
    public String getValue() {
        return value;
    }
}

package com.juhe.my01.web.model.juhe;

import lombok.Data;

/**
 * ClassName: WeChatModel
 * Description:
 * date: 2020/9/1 15:26
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class WeChatPayModel {

    public WeChatPayModel(){

    }

    private String url;
    private String version = "1.0.0";
    private String appId = "157888527897789";
    private String appKey = "UYdJdFwHzBuyoRUFf6is4ffjYFe7l9It";
    private String mhtOrderName = "mhtOrderName";
    private String mhtOrderAmt = "1";
    private String mhtOrderDetail = "mhtOrderDetail";
    private String mhtOrderTimeOut = "3600";
    private String notifyUrl = "http://ipaynow.natapp1.cc/asyn";
    private String payChannelType = "13";
    private String mhtLimitPay = "";
    private String consumerId = "o0wwA0RsmX9AM_SZ8NBmdF9fNMl4";
    private String mhtSubAppId = "wx694abcd10bf94a26";

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getMhtSubAppId() {
        return mhtSubAppId;
    }

    public void setMhtSubAppId(String mhtSubAppId) {
        this.mhtSubAppId = mhtSubAppId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getMhtOrderName() {
        return mhtOrderName;
    }

    public void setMhtOrderName(String mhtOrderName) {
        this.mhtOrderName = mhtOrderName;
    }

    public String getMhtOrderAmt() {
        return mhtOrderAmt;
    }

    public void setMhtOrderAmt(String mhtOrderAmt) {
        this.mhtOrderAmt = mhtOrderAmt;
    }

    public String getMhtOrderDetail() {
        return mhtOrderDetail;
    }

    public void setMhtOrderDetail(String mhtOrderDetail) {
        this.mhtOrderDetail = mhtOrderDetail;
    }

    public String getMhtOrderTimeOut() {
        return mhtOrderTimeOut;
    }

    public void setMhtOrderTimeOut(String mhtOrderTimeOut) {
        this.mhtOrderTimeOut = mhtOrderTimeOut;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getMhtLimitPay() {
        return mhtLimitPay;
    }

    public void setMhtLimitPay(String mhtLimitPay) {
        this.mhtLimitPay = mhtLimitPay;
    }
}

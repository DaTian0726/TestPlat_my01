package com.juhe.my01.web.model.juhe;

import lombok.Data;

/**
 * ClassName: BarcodeModel
 * Description:
 * date: 2020/9/1 15:26
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class BarcodeModel {

    public BarcodeModel(){

    }
    private String url;
    private String channelAuthCode;
    private String mhtStoreId = "";
    private String mhtTermId = "";
    private String version = "1.0.0";
    private String appId = "156704968682029";
    private String appKey = "KkKJCnd6AtjgCArp2HycxAvNstEmUSWo";
    private String mhtOrderName = "mhtOrderName";
    private String mhtOrderAmt = "1";
    private String mhtOrderDetail = "mhtOrderDetail";
    private String mhtOrderTimeOut = "3600";
    private String notifyUrl = "http://ipaynow.natapp1.cc/asyn";
    private String payChannelType = "12";
    private String mhtLimitPay = "";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChannelAuthCode() {
        return channelAuthCode;
    }

    public void setChannelAuthCode(String channelAuthCode) {
        this.channelAuthCode = channelAuthCode;
    }

    public String getMhtStoreId() {
        return mhtStoreId;
    }

    public void setMhtStoreId(String mhtStoreId) {
        this.mhtStoreId = mhtStoreId;
    }

    public String getMhtTermId() {
        return mhtTermId;
    }

    public void setMhtTermId(String mhtTermId) {
        this.mhtTermId = mhtTermId;
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

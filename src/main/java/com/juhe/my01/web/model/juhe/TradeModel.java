package com.juhe.my01.web.model.juhe;

import lombok.Data;

/**
 * ClassName: TradeModel
 * Description:
 * date: 2020/9/1 15:26
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class TradeModel {

    public TradeModel(){

    }

    private String outputType = "1";
    private String url;
    private String version = "1.0.0";
    private String appId = "161059515751715";
    private String appKey = "7yd2Y5qqhRKvjE36HxuFTU8bS1hr3Nxm";
    private String consumerCreateIp = "60.253.242.122";
    private String mhtOrderName = "mhtOrderName";
    private String mhtOrderAmt = "1";
    private String mhtOrderDetail = "mhtOrderDetail";
    private String mhtOrderTimeOut = "3600";
    private String notifyUrl = "http://mock-api.com/VnZ894zw.mock/payNotify";
    private String payChannelType = "12";
    private String mhtLimitPay = "0";

    public String getConsumerCreateIp() {
        return consumerCreateIp;
    }

    public void setConsumerCreateIp(String consumerCreateIp) {
        this.consumerCreateIp = consumerCreateIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
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

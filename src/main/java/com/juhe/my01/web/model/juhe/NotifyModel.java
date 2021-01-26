package com.juhe.my01.web.model.juhe;

import lombok.Data;

/**
 * ClassName: NotifyModel
 * Description:
 * date: 2020/11/6 17:26
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class NotifyModel {
    public String appId;
    public String channelOrderNo;
    public String deviceType;
    public String discountAmt;
    public String funcode;
    public String mhtCharset;
    public String mhtCurrencyType;
    public String mhtOrderAmt;
    public String mhtOrderName;
    public String mhtOrderStartTime;
    public String mhtOrderTimeOut;
    public String mhtOrderType;
    public String mhtReserved;
    public String nowPayOrderNo;
    public String oriMhtOrderAmt;
    public String payChannelType;
    public String payConsumerId;
    public String payTime;
    public String signType;
    public String signature;
    public String transStatus;
    public String version;

    public NotifyModel(String appId, String channelOrderNo, String deviceType, String discountAmt, String funcode, String mhtCharset, String mhtCurrencyType, String mhtOrderAmt, String mhtOrderName, String mhtOrderStartTime, String mhtOrderTimeOut, String mhtOrderType, String mhtReserved, String nowPayOrderNo, String oriMhtOrderAmt, String payChannelType, String payConsumerId, String payTime, String signType, String signature, String transStatus, String version) {
        this.appId = appId;
        this.channelOrderNo = channelOrderNo;
        this.deviceType = deviceType;
        this.discountAmt = discountAmt;
        this.funcode = funcode;
        this.mhtCharset = mhtCharset;
        this.mhtCurrencyType = mhtCurrencyType;
        this.mhtOrderAmt = mhtOrderAmt;
        this.mhtOrderName = mhtOrderName;
        this.mhtOrderStartTime = mhtOrderStartTime;
        this.mhtOrderTimeOut = mhtOrderTimeOut;
        this.mhtOrderType = mhtOrderType;
        this.mhtReserved = mhtReserved;
        this.nowPayOrderNo = nowPayOrderNo;
        this.oriMhtOrderAmt = oriMhtOrderAmt;
        this.payChannelType = payChannelType;
        this.payConsumerId = payConsumerId;
        this.payTime = payTime;
        this.signType = signType;
        this.signature = signature;
        this.transStatus = transStatus;
        this.version = version;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(String discountAmt) {
        this.discountAmt = discountAmt;
    }

    public String getFuncode() {
        return funcode;
    }

    public void setFuncode(String funcode) {
        this.funcode = funcode;
    }

    public String getMhtCharset() {
        return mhtCharset;
    }

    public void setMhtCharset(String mhtCharset) {
        this.mhtCharset = mhtCharset;
    }

    public String getMhtCurrencyType() {
        return mhtCurrencyType;
    }

    public void setMhtCurrencyType(String mhtCurrencyType) {
        this.mhtCurrencyType = mhtCurrencyType;
    }

    public String getMhtOrderAmt() {
        return mhtOrderAmt;
    }

    public void setMhtOrderAmt(String mhtOrderAmt) {
        this.mhtOrderAmt = mhtOrderAmt;
    }

    public String getMhtOrderName() {
        return mhtOrderName;
    }

    public void setMhtOrderName(String mhtOrderName) {
        this.mhtOrderName = mhtOrderName;
    }

    public String getMhtOrderStartTime() {
        return mhtOrderStartTime;
    }

    public void setMhtOrderStartTime(String mhtOrderStartTime) {
        this.mhtOrderStartTime = mhtOrderStartTime;
    }

    public String getMhtOrderTimeOut() {
        return mhtOrderTimeOut;
    }

    public void setMhtOrderTimeOut(String mhtOrderTimeOut) {
        this.mhtOrderTimeOut = mhtOrderTimeOut;
    }

    public String getMhtOrderType() {
        return mhtOrderType;
    }

    public void setMhtOrderType(String mhtOrderType) {
        this.mhtOrderType = mhtOrderType;
    }

    public String getMhtReserved() {
        return mhtReserved;
    }

    public void setMhtReserved(String mhtReserved) {
        this.mhtReserved = mhtReserved;
    }

    public String getNowPayOrderNo() {
        return nowPayOrderNo;
    }

    public void setNowPayOrderNo(String nowPayOrderNo) {
        this.nowPayOrderNo = nowPayOrderNo;
    }

    public String getOriMhtOrderAmt() {
        return oriMhtOrderAmt;
    }

    public void setOriMhtOrderAmt(String oriMhtOrderAmt) {
        this.oriMhtOrderAmt = oriMhtOrderAmt;
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getPayConsumerId() {
        return payConsumerId;
    }

    public void setPayConsumerId(String payConsumerId) {
        this.payConsumerId = payConsumerId;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

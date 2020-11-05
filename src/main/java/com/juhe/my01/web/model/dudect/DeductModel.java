package com.juhe.my01.web.model.dudect;

import com.juhe.my01.utils.GetNowTime;
import lombok.Data;

/**
 * ClassName: deductModel
 * Description:
 * date: 2020/9/9 15:39
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class DeductModel {

    private String appId = "";
    private String version = "1.0.0";
    private String privateKey = "";
    private String publicKey = "";
    private String notifyUrl = "http://ipaynow.natapp1.cc/asyn";
    private String url = "";
    private String mhtSubAppId = "";//非必填
    private String contractId = "";
    private String mhtOrderNo = "Trade_"+ GetNowTime.NowTime();
    private String mhtOrderName = "商品名称001";
    private String mhtOrderDetail = "商品详情001";
    private String mhtOrderAmt = "1";
    private String payChannelType = "13";
    private String mhtReserved = "商户保留域";//非必填

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMhtSubAppId() {
        return mhtSubAppId;
    }

    public void setMhtSubAppId(String mhtSubAppId) {
        this.mhtSubAppId = mhtSubAppId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getMhtOrderNo() {
        return mhtOrderNo;
    }

    public void setMhtOrderNo(String mhtOrderNo) {
        this.mhtOrderNo = mhtOrderNo;
    }

    public String getMhtOrderName() {
        return mhtOrderName;
    }

    public void setMhtOrderName(String mhtOrderName) {
        this.mhtOrderName = mhtOrderName;
    }

    public String getMhtOrderDetail() {
        return mhtOrderDetail;
    }

    public void setMhtOrderDetail(String mhtOrderDetail) {
        this.mhtOrderDetail = mhtOrderDetail;
    }

    public String getMhtOrderAmt() {
        return mhtOrderAmt;
    }

    public void setMhtOrderAmt(String mhtOrderAmt) {
        this.mhtOrderAmt = mhtOrderAmt;
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getMhtReserved() {
        return mhtReserved;
    }

    public void setMhtReserved(String mhtReserved) {
        this.mhtReserved = mhtReserved;
    }
}

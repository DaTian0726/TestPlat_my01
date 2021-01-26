package com.juhe.my01.web.model.dudect;

import lombok.Data;

/**
 * ClassName: SignMode
 * Description:
 * date: 2020/9/8 15:17
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class SignModel {

    public SignModel(){

    }

    private String privateKey = "";
    private String publicKey = "";
    private String url = "";
    private String appId = "";
    private String version = "1.0.0";
    private String notifyUrl = "http://ipaynow.natapp1.cc/asyn";
    private String mhtSubAppId = "";//非必填
    private String planId = "132263";
    private String payChannelType = "13";
    private String contractType = "03";
    private String mhtContractDisplayName = "Ipaynow";
    private String mhtContractUserId = "";//非必填
    private String returnWeb = "";//公众号回调标识
    private String callbackAppId = "";//H5签约回到appid 当指定该字段时

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getMhtSubAppId() {
        return mhtSubAppId;
    }

    public void setMhtSubAppId(String mhtSubAppId) {
        this.mhtSubAppId = mhtSubAppId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getMhtContractDisplayName() {
        return mhtContractDisplayName;
    }

    public void setMhtContractDisplayName(String mhtContractDisplayName) {
        this.mhtContractDisplayName = mhtContractDisplayName;
    }

    public String getMhtContractUserId() {
        return mhtContractUserId;
    }

    public void setMhtContractUserId(String mhtContractUserId) {
        this.mhtContractUserId = mhtContractUserId;
    }

    public String getReturnWeb() {
        return returnWeb;
    }

    public void setReturnWeb(String returnWeb) {
        this.returnWeb = returnWeb;
    }

    public String getCallbackAppId() {
        return callbackAppId;
    }

    public void setCallbackAppId(String callbackAppId) {
        this.callbackAppId = callbackAppId;
    }
}

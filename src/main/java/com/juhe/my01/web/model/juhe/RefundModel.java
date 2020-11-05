package com.juhe.my01.web.model.juhe;

import com.juhe.my01.utils.GetNowTime;
import lombok.Data;

/**
 * ClassName: RefundModel
 * Description:
 * date: 2020/9/1 15:26
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class RefundModel {

    public RefundModel(){

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
    private String version = "1.0.0";
    private String appId = "";
    private String oriTransId = "";
    private String mhtOrderNo;
    private String mhtRefundNo = GetNowTime.NowTime() + "Refund";
    private String appKey = "";
    private String funcode = "R001";
    private String amount = "1";
    private String notifyUrl = "http://ipaynow.natapp1.cc/asyn";

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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getOriTransId() {
        return oriTransId;
    }

    public void setOriTransId(String oriTransId) {
        this.oriTransId = oriTransId;
    }

    public String getMhtOrderNo() {
        return mhtOrderNo;
    }

    public void setMhtOrderNo(String mhtOrderNo) {
        this.mhtOrderNo = mhtOrderNo;
    }

    public String getMhtRefundNo() {
        return mhtRefundNo;
    }

    public void setMhtRefundNo(String mhtRefundNo) {
        this.mhtRefundNo = mhtRefundNo;
    }

    public String getFuncode() {
        return funcode;
    }

    public void setFuncode(String funcode) {
        this.funcode = funcode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

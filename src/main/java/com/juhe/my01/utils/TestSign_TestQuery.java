package com.juhe.my01.utils;

import com.alibaba.fastjson.JSONObject;

public class TestSign_TestQuery {
    public static String CheckSignMD5(String res, String Key, String deviceType) {
        String sign = "";
        JSONObject jsonObject = StringToJson(res, deviceType); //appKey
        //提取并移除返回报文中的 签名
        String signature = (String) jsonObject.remove("signature");
        //将原下单的应用Kay赋值到返回的报文中
        jsonObject.put("appKey", Key);
        //进行加签  ----判断是否有版本号
        if (jsonObject.containsKey("version")) {
            System.out.println("带版本号验签(测试)：----");
            String pars = Sign_V.AddSign_V(jsonObject);
//            System.out.println("-------"+pars);
            sign = StringToJson(pars, deviceType).getString("signature");
        } else {
            System.out.println("不带版本号验签（返回参数测试）：----");
            String pars = Sign_noV.SignAddMd5_noV(jsonObject);
            System.out.println("-------" + pars);
            sign = StringToJson(pars, deviceType).getString("signature");
        }
        if (sign.equals(signature)) {
            return "验签成功";
        } else {
            System.out.println("原始签名：" + signature);
            System.out.println("\n新签名：" + sign);
            return "验签失败";
        }
    }

    /**
     * 将String串（key+value&...格式）转换为Json对象
     * 按照接口文档进行提取参数
     *
     * @param res
     * @return
     */
    public static JSONObject StringToJson(String res, String deviceType) {
        JSONObject ob = new JSONObject();
        String[] str = res.split("&");
        for (String strTmp : str) {
            ob.put(strTmp.substring(0, strTmp.indexOf("=")), Undecode_util.res(strTmp.substring(strTmp.indexOf("=") + 1)));
        }
        JSONObject js = new JSONObject();
        if (deviceType.equals("0600")) {
            js = test_Media(ob);
        }
        if (deviceType.equals("0601")) {
            js = test_Wap(ob);
        }
        if (deviceType.equals("01")) {
            js = test_SDK(ob);
        }
        if (deviceType.equals("14")) {
            js = test_WeChat(ob);
        }
        if (deviceType.equals("05")) {
            js = test_Barcode(ob);
        }
        if (deviceType.equals("08")) {
            js = test_Active(ob);
        }
        if (deviceType.equals("20")) {
            js = test_Juhema(ob);
        }

        return js;
    }

    /**
     * 公众号接口文档 返回参数
     *
     * @param ob
     * @return
     */
    public static JSONObject test_Media(JSONObject ob) {
        JSONObject js = new JSONObject();
        js.put("funcode", ob.getString("funcode"));
        js.put("version", ob.getString("version"));
        js.put("appId", ob.getString("appId"));
        js.put("mhtOrderNo", ob.getString("mhtOrderNo"));
        js.put("mhtOrderName", ob.getString("mhtOrderName"));
        js.put("mhtSubMchId", ob.getString("mhtSubMchId"));
        js.put("mhtOrderType", ob.getString("mhtOrderType"));
        js.put("mhtCurrencyType", ob.getString("mhtCurrencyType"));
        js.put("mhtOrderAmt", ob.getString("mhtOrderAmt"));
        js.put("oriMhtOrderAmt", ob.getString("oriMhtOrderAmt"));
        js.put("discountAmt", ob.getString("discountAmt"));
        js.put("mhtOrderTimeOut", ob.getString("mhtOrderTimeOut"));
        js.put("mhtOrderStartTime", ob.getString("mhtOrderStartTime"));
        js.put("mhtCharset", ob.getString("mhtCharset"));
        js.put("deviceType", ob.getString("deviceType"));
        js.put("payChannelType", ob.getString("payChannelType"));
        js.put("nowPayOrderNo", ob.getString("nowPayOrderNo"));
        js.put("channelOrderNo", ob.getString("channelOrderNo"));
        js.put("payTime", ob.getString("payTime"));
        js.put("payConsumerId", ob.getString("payConsumerId"));
        js.put("transStatus", ob.getString("transStatus"));
        js.put("mhtReserved", ob.getString("mhtReserved"));
        js.put("bankType", ob.getString("bankType"));
        js.put("cardType", ob.getString("cardType"));
        js.put("responseTime", ob.getString("responseTime"));
        js.put("responseCode", ob.getString("responseCode"));
        js.put("responseMsg", ob.getString("responseMsg"));
        js.put("signType", ob.getString("signType"));
        js.put("signature", ob.getString("signature"));
        return js;
    }

    public static JSONObject test_Wap(JSONObject ob) {
        JSONObject js = new JSONObject();
        js.put("funcode", ob.getString("funcode"));
        js.put("version", ob.getString("version"));
        js.put("appId", ob.getString("appId"));
        js.put("mhtOrderNo", ob.getString("mhtOrderNo"));
        js.put("mhtOrderName", ob.getString("mhtOrderName"));
        js.put("mhtSubMchId", ob.getString("mhtSubMchId"));
        js.put("mhtOrderType", ob.getString("mhtOrderType"));
        js.put("mhtCurrencyType", ob.getString("mhtCurrencyType"));
        js.put("mhtOrderAmt", ob.getString("mhtOrderAmt"));
        js.put("discountAmt", ob.getString("discountAmt"));
        js.put("oriMhtOrderAmt", ob.getString("oriMhtOrderAmt"));
        js.put("mhtOrderTimeOut", ob.getString("mhtOrderTimeOut"));
        js.put("mhtOrderStartTime", ob.getString("mhtOrderStartTime"));
        js.put("mhtCharset", ob.getString("mhtCharset"));
        js.put("deviceType", ob.getString("deviceType"));
        js.put("payChannelType", ob.getString("payChannelType"));
        js.put("nowPayOrderNo", ob.getString("nowPayOrderNo"));
        js.put("channelOrderNo", ob.getString("channelOrderNo"));
        js.put("payConsumerId", ob.getString("payConsumerId"));
        js.put("payTime", ob.getString("payTime"));
        js.put("transStatus", ob.getString("transStatus"));
        js.put("mhtReserved", ob.getString("mhtReserved"));
        js.put("responseTime", ob.getString("responseTime"));
        js.put("responseCode", ob.getString("responseCode"));
        js.put("responseMsg", ob.getString("responseMsg"));
        js.put("signType", ob.getString("signType"));
        js.put("signature", ob.getString("signature"));
        return js;
    }

    public static JSONObject test_SDK(JSONObject ob) {
        JSONObject js = new JSONObject();
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        js.put("", ob.getString(""));
        return js;
    }

    public static JSONObject test_WeChat(JSONObject ob) {
        JSONObject js = new JSONObject();
        js.put("funcode", ob.getString("funcode"));
        js.put("version", ob.getString("version"));
        js.put("appId", ob.getString("appId"));
        js.put("mhtOrderNo", ob.getString("mhtOrderNo"));
        js.put("mhtOrderName", ob.getString("mhtOrderName"));
        js.put("mhtSubMchId", ob.getString("mhtSubMchId"));
        js.put("mhtOrderType", ob.getString("mhtOrderType"));
        js.put("mhtCurrencyType", ob.getString("mhtCurrencyType"));
        js.put("mhtOrderAmt", ob.getString("mhtOrderAmt"));
        js.put("oriMhtOrderAmt", ob.getString("oriMhtOrderAmt"));
        js.put("discountAmt", ob.getString("discountAmt"));
        js.put("mhtOrderTimeOut", ob.getString("mhtOrderTimeOut"));
        js.put("mhtOrderStartTime", ob.getString("mhtOrderStartTime"));
        js.put("mhtCharset", ob.getString("mhtCharset"));
        js.put("deviceType", ob.getString("deviceType"));
        js.put("payChannelType", ob.getString("payChannelType"));
        js.put("nowPayOrderNo", ob.getString("nowPayOrderNo"));
        js.put("channelOrderNo", ob.getString("channelOrderNo"));
        js.put("payTime", ob.getString("payTime"));
        js.put("payConsumerId", ob.getString("payConsumerId"));
        js.put("transStatus", ob.getString("transStatus"));
        js.put("mhtReserved", ob.getString("mhtReserved"));
        js.put("bankType", ob.getString("bankType"));
        js.put("cardType", ob.getString("cardType"));
        js.put("responseTime", ob.getString("responseTime"));
        js.put("responseCode", ob.getString("responseCode"));
        js.put("responseMsg", ob.getString("responseMsg"));
        js.put("signType", ob.getString("signType"));
        js.put("signature", ob.getString("signature"));
        return js;
    }
    public static JSONObject test_Barcode(JSONObject ob) {
        JSONObject js = new JSONObject();
        js.put("funcode", ob.getString("funcode"));
        js.put("version", ob.getString("version"));
        js.put("appId", ob.getString("appId"));
        js.put("mhtOrderNo", ob.getString("mhtOrderNo"));
        js.put("mhtOrderName", ob.getString("mhtOrderName"));
        js.put("mhtOrderType", ob.getString("mhtOrderType"));
        js.put("mhtCurrencyType", ob.getString("mhtCurrencyType"));
        js.put("oriMhtOrderAmt", ob.getString("oriMhtOrderAmt"));
        js.put("mhtOrderAmt", ob.getString("mhtOrderAmt"));
        js.put("discountAmt", ob.getString("discountAmt"));
        js.put("discountDetail", ob.getString("discountDetail"));
        js.put("mhtOrderTimeOut", ob.getString("mhtOrderTimeOut"));
        js.put("mhtOrderStartTime", ob.getString("mhtOrderStartTime"));
        js.put("mhtCharset", ob.getString("mhtCharset"));
        js.put("deviceType", ob.getString("deviceType"));
        js.put("payChannelType", ob.getString("payChannelType"));
        js.put("nowPayOrderNo", ob.getString("nowPayOrderNo"));
        js.put("channelOrderNo", ob.getString("channelOrderNo"));
        js.put("payConsumerId", ob.getString("payConsumerId"));
        js.put("mhtSubMchId", ob.getString("mhtSubMchId"));
        js.put("payTime", ob.getString("payTime"));
        js.put("transStatus", ob.getString("transStatus"));
        js.put("mhtReserved", ob.getString("mhtReserved"));
        js.put("responseTime", ob.getString("responseTime"));
        js.put("responseCode", ob.getString("responseCode"));
        js.put("responseMsg", ob.getString("responseMsg"));
        js.put("signType", ob.getString("signType"));
        js.put("signature", ob.getString("signature"));
        js.put("bankType", ob.getString("bankType"));
        js.put("cardType", ob.getString("cardType"));
        return js;
    }

    public static JSONObject test_Active(JSONObject ob) {
        JSONObject js = new JSONObject();
        js.put("funcode", ob.getString("funcode"));
        js.put("version", ob.getString("version"));
        js.put("appId", ob.getString("appId"));
        js.put("mhtOrderNo", ob.getString("mhtOrderNo"));
        js.put("mhtOrderName", ob.getString("mhtOrderName"));
        js.put("mhtSubMchId", ob.getString("mhtSubMchId"));
        js.put("mhtOrderType", ob.getString("mhtOrderType"));
        js.put("mhtCurrencyType", ob.getString("mhtCurrencyType"));
        js.put("oriMhtOrderAmt", ob.getString("oriMhtOrderAmt"));
        js.put("mhtOrderAmt", ob.getString("mhtOrderAmt"));
        js.put("discountAmt", ob.getString("discountAmt"));
        js.put("mhtOrderTimeOut", ob.getString("mhtOrderTimeOut"));
        js.put("mhtOrderStartTime", ob.getString("mhtOrderStartTime"));
        js.put("mhtCharset", ob.getString("mhtCharset"));
        js.put("deviceType", ob.getString("deviceType"));
        js.put("payChannelType", ob.getString("payChannelType"));
        js.put("nowPayOrderNo", ob.getString("nowPayOrderNo"));
        js.put("channelOrderNo", ob.getString("channelOrderNo"));
        js.put("payConsumerId", ob.getString("payConsumerId"));
        js.put("payTime", ob.getString("payTime"));
        js.put("transStatus", ob.getString("transStatus"));
        js.put("mhtReserved", ob.getString("mhtReserved"));
        js.put("responseTime", ob.getString("responseTime"));
        js.put("responseCode", ob.getString("responseCode"));
        js.put("responseMsg", ob.getString("responseMsg"));
        js.put("signType", ob.getString("signType"));
        js.put("signature", ob.getString("signature"));
        return js;
    }

    public static JSONObject test_Juhema(JSONObject ob) {
        JSONObject js = new JSONObject();
        js.put("funcode", ob.getString("funcode"));
        js.put("version", ob.getString("version"));
        js.put("appId", ob.getString("appId"));
        js.put("mhtOrderNo", ob.getString("mhtOrderNo"));
        js.put("mhtOrderName", ob.getString("mhtOrderName"));
        js.put("mhtSubMchId", ob.getString("mhtSubMchId"));
        js.put("mhtOrderType", ob.getString("mhtOrderType"));
        js.put("mhtCurrencyType", ob.getString("mhtCurrencyType"));
        js.put("mhtOrderAmt", ob.getString("mhtOrderAmt"));
        js.put("oriMhtOrderAmt", ob.getString("oriMhtOrderAmt"));
        js.put("discountAmt", ob.getString("discountAmt"));
        js.put("mhtOrderTimeOut", ob.getString("mhtOrderTimeOut"));
        js.put("mhtOrderStartTime", ob.getString("mhtOrderStartTime"));
        js.put("mhtCharset", ob.getString("mhtCharset"));
        js.put("deviceType", ob.getString("deviceType"));
        js.put("payChannelType", ob.getString("payChannelType"));
        js.put("nowPayOrderNo", ob.getString("nowPayOrderNo"));
        js.put("channelOrderNo", ob.getString("channelOrderNo"));
        js.put("payTime", ob.getString("payTime"));
        js.put("payConsumerId", ob.getString("payConsumerId"));
        js.put("transStatus", ob.getString("transStatus"));
        js.put("mhtReserved", ob.getString("mhtReserved"));
        js.put("bankType", ob.getString("bankType"));
        js.put("cardType", ob.getString("cardType"));
        js.put("responseTime", ob.getString("responseTime"));
        js.put("responseCode", ob.getString("responseCode"));
        js.put("responseMsg", ob.getString("responseMsg"));
        js.put("signType", ob.getString("signType"));
        return js;
    }
}

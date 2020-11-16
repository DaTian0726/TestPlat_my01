package com.juhe.my01.utils;

import com.juhe.my01.web.controller.URLEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * ClassName: EnumTransUtil
 * Description:
 * date: 2020/11/13 14:55
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class EnumTransUtil {

    /**
     * 处理商户异步通知枚举类型
     * @param map
     * @return
     */

    public static String ResultShow(Map map){

        switch ((String) map.get("deviceType")){
            case "01" :
                map.put("deviceType","手机SDK系统");
                break;
            case "05" :
                map.put("deviceType","被扫系统");
                break;
            case "08" :
                map.put("deviceType","主扫系统");
                break;
            case "20" :
                map.put("deviceType","聚合码系统");
                break;
            case "14" :
                map.put("deviceType","小程序系统");
                break;
            case "0603" :
                map.put("deviceType","新立码卡牌");
                break;
            case "0600" :
                map.put("deviceType","微信公众号");
                break;
            case "0601" :
                map.put("deviceType","H5系统");
                break;
            case "11" :
                map.put("deviceType","POS系统");
                break;
        }

        switch ((String) map.get("payChannelType")){
            case "12" :
                map.put("payChannelType","支付宝");
                break;
            case "13" :
                map.put("payChannelType","微信");
                break;
            case "27" :
                map.put("payChannelType","银联");
                break;
        }

        //模板：2020-11-06 17:56:55 【XXX系统】-【交易号为XXX】-【订单号为XXX】使用XXX支付XXX元 -- 商户异步通知接受正常
        return GetNowTime.ToNowTime((String)map.get("mhtOrderStartTime"))
                + " "
                + "【" + map.get("deviceType") + "】"
                + "-"
                + "【交易号为" + map.get("nowPayOrderNo") + "】"
                + "-"
                + "【订单号为" + map.get("mhtOrderNo") + "】"
                + ""
                + "使用" + map.get("payChannelType") + "支付"
                + ""
                + map.get("oriMhtOrderAmt") + "元"
                + " -- 商户异步通知接受正常";
    }

    public static String TransEnum(String URL,String Service){

        if(StringUtils.isNotBlank(URL) || StringUtils.isNotBlank(Service)){
            if(URL.equals("test")&&Service.equals("juhe")){
                return URLEnum.JUHE_TEST.getURl();
            }else if(URL.equals("pre")&&Service.equals("juhe")){
                return URLEnum.JUHE_PRE.getURl();
            }else if(URL.equals("line")&&Service.equals("juhe")){
                return URLEnum.JUHE_LINE.getURl();
            }else if (URL.equals("test")&&Service.equals("cmb")){
                return URLEnum.CMB_TEST.getURl();
            }else if(URL.equals("pre")&&Service.equals("cmb")){
                return URLEnum.CMB_PRE.getURl();
            }else {
                return URLEnum.CMB_LINE.getURl();
            }
        }else {
            return "";
        }


    }



}

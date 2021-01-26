package com.juhe.my01.utils;

import com.juhe.my01.web.controller.URLEnum;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
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
            case "R001" :
                map.put("deviceType","退款系统");
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
        if(!map.containsKey("mhtOrderStartTime")){
            map.put("mhtOrderStartTime",map.get("refundTime"));
        }
        if(!map.containsKey("oriMhtOrderAmt")){
            map.put("oriMhtOrderAmt",map.get("amount"));
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
                + map.get("oriMhtOrderAmt") + "分"
                + " -- 商户异步通知接受正常";
    }

    public static String TransEnum(String URL,String Service){
        HashMap<String,String> Urlmap = new HashMap();
        //API地址
        Urlmap.put("juhe_test",URLEnum.JUHE_TEST.getURl());
        Urlmap.put("juhe_pre",URLEnum.JUHE_PRE.getURl());
        Urlmap.put("juhe_line",URLEnum.JUHE_LINE.getURl());
        Urlmap.put("cmb_test",URLEnum.CMB_TEST.getURl());
        Urlmap.put("cmb_pre",URLEnum.CMB_PRE.getURl());
        Urlmap.put("cmb_line",URLEnum.CMB_LINE.getURl());
        Urlmap.put("zg_test",URLEnum.ZG_TEST.getURl());
        Urlmap.put("zg_line",URLEnum.ZG_LINE.getURl());
        //退款地址
        Urlmap.put("juhe_refund-test",URLEnum.JUHE_REFUND_TEST.getURl());
        Urlmap.put("juhe_refund-pre",URLEnum.JUHE_REFUND_PRE.getURl());
        Urlmap.put("juhe_refund-line",URLEnum.JUHE_REFUND_LINE.getURl());
        Urlmap.put("cmb_refund-test",URLEnum.CMB_REFUND_TEST.getURl());
        Urlmap.put("cmb_refund-pre",URLEnum.CMB_REFUND_PRE.getURl());
        Urlmap.put("cmb_refund-line",URLEnum.CMB_REFUND_LINE.getURl());
        Urlmap.put("zg_refund-test",URLEnum.ZG_REFUND_TEST.getURl());
        Urlmap.put("zg_refund-line",URLEnum.zg_refund_line.getURl());
        //拼接地址并装换
        String Urlmsg = Service + "_" + URL;
        if(Urlmap.get(Urlmsg) == null){
            return "error";
        }
        System.out.println(" -- -- -- -- -- 请求地址为：  " + Urlmap.get(Urlmsg));
        return Urlmap.get(Urlmsg);
    }


}

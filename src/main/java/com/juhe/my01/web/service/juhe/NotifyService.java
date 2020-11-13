package com.juhe.my01.web.service.juhe;

import com.juhe.my01.utils.GetNowTime;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: NotifyService
 * Description:
 * date: 2020/11/6 16:58
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class NotifyService {

    /**
     * 接受异步通知流数据
     * @param request
     * @return
     * @throws Exception
     */
    public  String getResUtil(HttpServletRequest request) throws  Exception{
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String temp = "";
        while ((temp = reader.readLine()) != null){
            sb.append(temp);
        }
        return sb.toString();
    }


    /**
     * 解析异步通知返回报文并展示为对应格式模板
     * @param transId
     * @param mhtOrderNo
     * @param list
     * @return
     */

    public List<String> ResultTransShow(String transId, String mhtOrderNo, List<String> list){
        Map<String,String> resultMap = new HashMap<String ,String>();
        List<String> resList = new ArrayList<>();
        //拆封list元素  A(1=1&2=2&3=3)  B
        for (String keyValue : list){
            //拆分每一个元素A(1=1 2=2 3=3)
            String[] keys = keyValue.split("&");
            //拆分元素A(1 1 + 判断)
            for (String key : keys){
                String[] res =  key.split("=");
                //将获取的参数保存
                resultMap.put(res[0],res[1]);
            }
            //拼接结果字符
            if(StringUtils.isNotBlank(transId) || StringUtils.isNotBlank(mhtOrderNo)){
                if(resultMap.get("nowPayOrderNo").equals(transId) || resultMap.get("mhtOrderNo").equals(mhtOrderNo)){
                    resList.add(ResultShow(resultMap));
                }
            }else {
                resList.add(ResultShow(resultMap));
            }
        }
        //返回显示
        return resList;
    }

    public String ResultShow(Map map){

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


    @Test
    public void TestA(){
        List<String> list =  new ArrayList();
        list.add("appId=151142878420675&channelOrderNo=2020110622001499901452641387&deviceType=08&discountAmt=0&funcode=N001&mhtCharset=UTF-8&mhtCurrencyType=156&mhtOrderAmt=1&mhtOrderName=mhtOrderName&mhtOrderNo=20201106172037ActiveTest&mhtOrderStartTime=20201106172037&mhtOrderTimeOut=3600&mhtOrderType=01&mhtReserved=mhtReserved&nowPayOrderNo=200301202011061720378635069&oriMhtOrderAmt=1&payChannelType=12&payConsumerId=2088912927599908&payTime=20201106172049&signType=MD5&signature=a0892df50fdd17e267798ff5b0014fae&transStatus=A001&version=1.0.0");
        list.add("appId=157318451507018&channelOrderNo=2020110622001499901452351942&deviceType=14&discountAmt=0&funcode=N001&mhtCharset=UTF-8&mhtCurrencyType=156&mhtOrderAmt=1&mhtOrderName=mhtOrderName&mhtOrderNo=AliPay_202011061281&mhtOrderStartTime=20201106135212&mhtOrderTimeOut=3600&mhtOrderType=05&mhtReserved=%E4%BF%9D%E7%95%99%E5%9F%9F666&nowPayOrderNo=c202506202011061352130568315&oriMhtOrderAmt=1&payChannelType=12&payTime=20201106135227&signType=MD5&signature=f7d2c43a944557b679875cc9c725cf27&transStatus=A001&version=1.0.0");

        List<String> list1 = ResultTransShow("","",list);

        for (String s :list1){
            System.out.println(s);
        }
    }
}

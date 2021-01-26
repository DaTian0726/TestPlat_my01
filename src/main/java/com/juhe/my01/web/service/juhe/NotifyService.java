package com.juhe.my01.web.service.juhe;

import com.juhe.my01.utils.EnumTransUtil;
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
                if(res.length == 1){
                    resultMap.put(res[0],"");
                }else {
                    resultMap.put(res[0],res[1]);
                }
            }
            if(!resultMap.containsKey("deviceType")){
                resultMap.put("deviceType","R001");
                resultMap.put("payChannelType","12");
            }
            //拼接结果字符
            if(StringUtils.isNotBlank(transId) || StringUtils.isNotBlank(mhtOrderNo)){
                if(resultMap.get("nowPayOrderNo").equals(transId) || resultMap.get("mhtOrderNo").equals(mhtOrderNo)){
                    resList.add(EnumTransUtil.ResultShow(resultMap));
                }
            }else {
                resList.add(EnumTransUtil.ResultShow(resultMap));
            }
        }
        //返回显示
        return resList;
    }

}

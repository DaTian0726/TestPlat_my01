package com.juhe.my01.testng.monitor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 使用业务系统模拟报警系统
 */
public class Demo {

    @Test
    public void test(){

        String res = "appId=155011680219391&funcode=WP001&mhtOrderNo=20201013171734ActiveTest&nowPayOrderNo=c200301202010131717351636528&responseCode=A001&responseMsg=E000#成功[成功]&responseTime=20201013171736&signType=MD5&signature=79054f456e29dbb02a69559a8f9751dd&tn=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAAEsCAIAAAD2HxkiAAAFrklEQVR42u3aQXaEMAxEQe5/aXKIjFG3XH/NY4JRsVGeV9JojyOQIJQglAShBKEkCCUIJUEoQSgJQglCSRBKEEqCUIJQEoQShJIglCCUBKEEoSQIJQglQShBKAlCCUJJEEoQSoJQglAShBKEkioQPiWdft726391nrfNA4QQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQTD5k/9C0Y0s5nx3xCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCOD187R+FtGW6eYAQQgghdOgQmgcIIYQQQocOoXmAEEIIIXToEJoHCCGEEEJDMHf/0+fgowwhhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgjhTYc+9fLSPjrmAUIIIYQQQgjNA4QQQgghhBBCCCGEEEIIIYQQQgghhBDmPWTOUKbdJw15yzxACCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBC+L+HTKtlKLde3zIPEEIIIYQQuh5CCCGEEEIIXQ8hhBBCCCGErocQQgghhPDupl62ZfeqKXIEEEIIIYQQQigIIYQQQgghFIQQQgghhBAKQgjXImxZvrcs/dPus/V6CCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCLOX2luH9fRyP+3jdfocMnFCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBC+NWQpS3lt/5TwdRHuSsIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEML7ELZgTjuf9o/a1HvPxAwhhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgjhZ49dMhxTS/mWpfmO5T6EEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCOFehGlIpq6fOp+WJf4Uqlm0EEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEexFOHXrLy05bsrcs/S3rIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIdyFseRlpw9fyvtKeC0IIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEMIMhC1L/Kml9tTf84ZlWQ8hhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQtiJcOr6lr8/bbl/Gv/W+YEQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYSwcwhu+3vS3nvL70IIIYQQQgghhBBCCCGEhh5CCCGEEEIIDT2EEEIIIYQQZgxZGoa03007//bzgRBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhPDMUE7dZwrbo0/e+yxOCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBDCvQjbaxm+lo9Ry/lDCCGEEApCCCGEEEIIBSGEEEIIIYSCEEIIIYQQwl1DfHrJnnaeU+/rV+fZhQpCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBDCtiFuuU/a8n1qWZ/28YIQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYTw2yFrXxZP3afld6feL4QQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQTvxu2pCdHtaWjw6EEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEdyM8fT7tyFt6R4MQQgghhBBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYTws8cuQZiGeerjmPaRghBCCCGEEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhPDMcKQtbaeWvy1L85b5eSODEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBCCCHci1AShBKEkiCUIJQEoQShJAglCCVBKEEoCUIJQkkQShBKEEqCUIJQEoQShJIglCCUBKEEoSQIJQglQShBKAlCCUJJEEoQSoJQglDSof4A9nvNWOz2i6gAAAAASUVORK5CYII=&version=1.0.0";
        System.out.println(JSON.toJSONString(PaiXu(JSONUtil(res)),true));
        String rest = "{ \"mhtOrderTimeOut\":\"3600\", \"mhtOrderType\":\"01\", \"outputType\":\"0\", \"mhtOrderDetail\":\"mhtOrderDetail\", \"mhtSignType\":\"MD5\", \"mhtOrderNo\":\"20201013170201ActiveTest\", \"appId\":\"155011680219391\", \"mhtOrderAmt\":\"1\", \"mhtOrderStartTime\":\"20201013170201\", \"mhtGoodsTag\":\"\", \"mhtCurrencyType\":\"156\", \"mhtSubMchId\":\"\", \"deviceType\":\"08\", \"mhtSubAppId\":\"\", \"frontNotifyUrl\":\"http://mock-api.com/dno4ooKX.mock/qqq\", \"mhtOrderName\":\"mhtOrderName\", \"version\":\"1.0.0\", \"payChannelType\":\"12\", \"mhtReserved\":\"mhtReserved\", \"funcode\":\"WP001\", \"mhtCharset\":\"UTF-8\", \"notifyUrl\":\"http://mock-api.com/dno4ooKX.mock/qqq\", \"mhtLimitPay\":\"0\", \"mhtSignature\":\"da94f283cf9348411bb0ba833372b29e\" }\n" +
                "\n";
        JSONObject js = JSONObject.parseObject(rest);
        System.out.println(JSON.toJSONString(PaiXu(js),true));

    }

    public JSONObject JSONUtil(String json){
        String[] result = json.split("&");
        JSONObject jsonObject = new JSONObject();
        for(int i=0;i<result.length-1;i++){
            String[] keys = result[i].split("=");

            jsonObject.put(keys[0],keys[1]);
        }
        return jsonObject;
    }

    public static String PaiXu(JSONObject object) {
        //将Map转为List进行排序
        Set<String> keySet = object.keySet();
        List<String> keyList = new ArrayList<String>(keySet);
        Collections.sort(keyList);
        StringBuilder strB = new StringBuilder();
        for (String key : keyList) {
            String value = (String) object.get(key);
            if (StringUtils.isNotBlank(value)) {
                strB.append(key + "=" + value + "&");
            }
        }
        String toMd5Str = strB.deleteCharAt(strB.length() - 1).toString();
        return toMd5Str;
    }


}

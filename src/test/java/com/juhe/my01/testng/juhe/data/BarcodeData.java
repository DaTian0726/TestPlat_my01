package com.juhe.my01.testng.juhe.data;
import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.models.juhe.Barcode;
import org.testng.annotations.DataProvider;

public class BarcodeData {

    @DataProvider(name = "BarcodeAll_P")
    public static  Object[][] BarcodeData01(){
        //添加测试参数
        JSONObject ob01=Barcode.WP001Vars();
        ob01.put("canal","汇付天下=01");//渠道
        ob01.put("url","https://pay.ipaynow.cn/");//请求地址
        ob01.put("appId","156817450336917");//应用ID
        ob01.put("appKey","PG8PvI8He8rlmz8ACyvBi17ekjtRPIyQ");//应用Key
        ob01.put("channelAuthCode","285726266062553328");//支付码
        //添加测试参数
        JSONObject ob02=Barcode.WP001Vars();
        ob02.put("canal","汇付天下-02");//渠道
        ob02.put("url","https://pay.ipaynow.cn/");//请求地址
        ob02.put("appId","156817450336917");//应用ID
        ob02.put("appKey","PG8PvI8He8rlmz8ACyvBi17ekjtRPIyQ");//应用Key
        ob02.put("channelAuthCode","285726266062553328");//支付码

//        //加入Object[]
//        List<Object> vars=new ArrayList<Object>();
//        for (Object u : var) {
//            //做一个形式转换
//            vars.add(new Object{ u });
//        }
        return new Object[][]{
                {ob01},
                {ob02}
        };
    }

}

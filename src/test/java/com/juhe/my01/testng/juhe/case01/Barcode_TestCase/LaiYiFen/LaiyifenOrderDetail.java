package com.juhe.my01.testng.juhe.case01.Barcode_TestCase.LaiYiFen;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class LaiyifenOrderDetail {

    public static String OrderDetail(){
        JSONObject oo=new JSONObject();
        //构建订单基本信息
        JSONObject orderInfo = new JSONObject();
        orderInfo.put("title","日用品");
        orderInfo.put("dctAmount","2000");//一共可优惠金额
        orderInfo.put("addnInfo","屈臣氏(人民广场)店");
        //构建商品信息表
          //商品信息 01
        JSONObject goodInfo_01 = new JSONObject();
        goodInfo_01.put("id","testsp000051");
        goodInfo_01.put("name","商品01");
        goodInfo_01.put("price","1000");//单价 单位：分
        goodInfo_01.put("quantity","8");
        //商品信息 02
        JSONObject goodInfo_02 = new JSONObject();
        goodInfo_02.put("id","testsp000052");
        goodInfo_02.put("name","商品02");
        goodInfo_02.put("price","1000");//单价 单位：分
        goodInfo_02.put("quantity","8");
        //--
        JSONArray goodsInfo=new JSONArray();
        goodsInfo.add(0,goodInfo_01);
        goodsInfo.add(0,goodInfo_02);
        //---
        oo.put("orderInfo",orderInfo);
        oo.put("goodsInfo",goodsInfo);
//        System.out.println(oo.toString());
        return oo.toString();
    }
}

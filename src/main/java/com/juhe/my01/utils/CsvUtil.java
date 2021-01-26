package com.juhe.my01.utils;


import com.juhe.my01.web.model.juhe.ActiveModel;
import com.juhe.my01.web.service.juhe.ActiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvUtil {

    public Logger logger = LoggerFactory.getLogger(CsvUtil.class);

    /**
     *
     * @param filedir
     * @return
     * @throws IOException
     */
    public   List<String> getCsvData(String filedir) throws IOException {
        List lines = new ArrayList();
        BufferedReader br = null;
        InputStreamReader isr = null;
        try {
            File file = new File(filedir);
            if (file.isFile() && file.exists()) {
                isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    lines.add(lineTxt);
                }
            } else {
                logger.error("文件不存在");
            }
        } catch (Exception e) {
            logger.error("文件处理失败");
        } finally {
            logger.info("文件处理完成");
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
        }
        return lines;
    }

    public  List<String> ActiveAuto(String filedir){
        List<String> list = new ArrayList<>();
        ActiveModel activeModel = new ActiveModel();
        ActiveService activeService = new ActiveService();
        Map<String,String> map = new HashMap();
        List<String> reslist = new ArrayList<>();
        try {
            list = getCsvData(filedir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s:list){
            String[] A = s.split(",");
            activeModel.setVersion(A[0]);
            activeModel.setPayChannelType(A[2]);
            activeModel.setMhtLimitPay(A[3]);
            activeModel.setAppId(A[4]);
            activeModel.setAppKey(A[5]);
            activeModel.setUrl(A[7]);
            map = activeService.Active(activeModel);
            logger.info(map.get("response"));
            if(map.get("response").contains("responseMsg=E000")){
                reslist.add("WP001下单接口-"+A[6]+"   √");
            }else {
                reslist.add("WP001下单接口-"+A[6]+"   ×");
            }
        }
        return reslist;
    }
}
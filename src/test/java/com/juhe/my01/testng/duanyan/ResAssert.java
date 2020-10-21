package com.juhe.my01.testng.duanyan;


public class ResAssert {

    public static String Duan(String res) {
        String[] strArray = res.split("&");
        String recode = "";
        String remsg = "";
        for (String strTmp : strArray) {
            if (strTmp.contains("responseCode")) {
                recode = strTmp;
//                System.out.println("实际结果：" + recode);
                assert recode.equals("responseCode=A001") : "responseCode与期望结果[responseCode=A001]不符";
            }
            if (strTmp.contains("responseMsg")) {
                remsg = strTmp;
                assert remsg.equals("responseMsg=E000#成功[成功]") : "responseMsg与期望结果[responseMsg=E000]不符";
            }
            if (strTmp.contains("transStatus")) {
                remsg = strTmp;
                assert remsg.equals("transStatus=A001") : "transStatus与期望结果[transStatus=A001]不符";
            }
        }
        return "断言结束";
    }

}

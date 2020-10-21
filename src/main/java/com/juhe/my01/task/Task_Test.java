//package com.juhe.my01.task;
//
//import com.alibaba.fastjson.JSONObject;
//import com.juhe.my01.controller.HtmlController;
//import com.juhe.my01.models.juhe.Model_Refund;
//import com.juhe.my01.toapi.ToRefund;
//import com.juhe.my01.utils.SendMail_Util;
//import com.juhe.my01.utils.Undecode_util;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//
//import java.util.Date;
//
//public class Task_Test extends QuartzJobBean  {
//    @Autowired
//    private SendMail_Util sendMail_util;
//    protected static Logger logger = LoggerFactory.getLogger(HtmlController.class);
//    /**
//     * 执行定时任务
//     * @param jobExecutionContext
//     * @throws JobExecutionException
//     */
//
//    @Override
//    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("定时任务--"+new Date());
//        //调用测试用例
//        JSONObject js= Model_Refund.Refund_Var();
//        js.put("url", "http://192.168.99.54:8790/refund_access/refundOrder");//请求地址
//        js.put("appId", "153068756001128");//应用ID
//        js.put("appKey", "GCTYm0H0C2vwtrGcXo6SOi6XctYtty3C");//应用Key
//        js.put("mhtOrderNo", "20191012170253Test");
//        js.put("amount", "1");
//        js.put("notifyUrl","http://mock-api.com/0ZzRmXKe.mock/qqq");
//        JSONObject res = ToRefund.RequestApi(js);
//        System.out.println("请求结果：" + Undecode_util.res( res.getString("body")));
//        //发送邮件：
//        JSONObject aa=new JSONObject();
//        aa.put("res",res.getString("body"));
//        sendMail_util.sendMail(res,"当前为定时任务："+"退款系统"+"——测试结果");
//        logger.info("发送邮件");
//    }
//
//}

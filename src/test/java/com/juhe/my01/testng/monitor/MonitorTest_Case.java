package com.juhe.my01.testng.monitor;

import com.alibaba.fastjson.JSONObject;
import com.juhe.my01.monitor.MonitorTest;
import org.testng.annotations.Test;

public class MonitorTest_Case {

    /**
     * 测试所有业务系统
     * 自动化回测
     * 修改时间 2019-10-28
     */
    @Test(dataProvider = "sysNo", dataProviderClass = DataMonitor.class)
    public void Test01(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", ob[0]);//系统号
        js.put("typeKey", ob[1]);//报警类型
        js.put("content", "测试报警监控");//报警邮件内容
        js.put("num", ob[2]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }
    /**
     *测试单个业务系统
     * 单个报警
     */
    @Test
    public void Test03() {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2008");//智能路由系统
        js.put("typeKey","YopPay");//报警类型
        js.put("content", "测试报警监控-智能路由");//报警邮件内容
        js.put("num", "20");//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

//#######################测试单个报警系统################
    /**
     * 打印参数中的日志内容
     */
    @Test
    public void Test0() {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/printlog");
        js.put("emailContent", "2001");//默认：测试
        js.put("num", "30");//默认：30
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }
//######################个系统报警类型全回测########################################
    /**
     * 测试所有报警类型
     * 通用报警---2000-代付系统
     *
     */
    @Test(dataProvider = "typeKey_daifu", dataProviderClass = DataMonitor.class)
    public void TestDaifu(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2000");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2001-代付渠道系统
     *
     */
    @Test(dataProvider = "typeKey_daifuQ", dataProviderClass = DataMonitor.class)
    public void TestDaifuQ(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2001");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2002-卡牌系统
     *
     */
    @Test(dataProvider = "typeKey_kapai", dataProviderClass = DataMonitor.class)
    public void TestKapai(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2002");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2003- 主扫系统
     *
     */
    @Test(dataProvider = "typeKey_zhusao", dataProviderClass = DataMonitor.class)
    public void TestZhusao(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2003");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }
    /**
     * 测试所有报警类型
     * 通用报警---2004- 公众号系统
     *
     */
    @Test(dataProvider = "typeKey_gongzhonghao", dataProviderClass = DataMonitor.class)
    public void TestMedia(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2004");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2006- WAP系统
     *
     */
    @Test(dataProvider = "typeKey_wap", dataProviderClass = DataMonitor.class)
    public void TestWap(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2006");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }
    /**
     * 测试所有报警类型
     * 通用报警---2007- 被扫系统
     *
     */
    @Test(dataProvider = "typeKey_barcode", dataProviderClass = DataMonitor.class)
    public void TestBarcode(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2007");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }
    /**
     * 测试所有报警类型
     * 通用报警---2008- 退款系统
     *
     */
    @Test(dataProvider = "typeKey_refund", dataProviderClass = DataMonitor.class)
    public void TestRefund(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2008");//系统号
        js.put("typeKey", ob[0]);//报警类型
         js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }
    /**
     * 测试所有报警类型
     * 通用报警---2009- POSP系统
     *
     */
    @Test(dataProvider = "typeKey_posp", dataProviderClass = DataMonitor.class)
    public void TestPOSP(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2009");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }
    /**
     * 测试所有报警类型
     * 通用报警---2010- SDK 系统
     *
     */
    @Test(dataProvider = "typeKey_SDK", dataProviderClass = DataMonitor.class)
    public void TestSDK(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2010");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2011- API系统
     */
    @Test(dataProvider = "typeKey_API", dataProviderClass = DataMonitor.class)
    public void TestAPI(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2011");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2021- webpay系统
     *
     */
    @Test(dataProvider = "typeKey_webpay", dataProviderClass = DataMonitor.class)
    public void TestWapPay(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2021");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2025- 小程序系统
     *
     */
    @Test(dataProvider = "typeKey_xiaochengxu", dataProviderClass = DataMonitor.class)
    public void TestXiaoChengxu(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2025");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2027- 通知系统
     *
     */
    @Test(dataProvider = "typeKey_tongzhi", dataProviderClass = DataMonitor.class)
    public void TestTongZhi(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2027");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }

    /**
     * 测试所有报警类型
     * 通用报警---2034- 智能路由
     *
     */
    @Test(dataProvider = "typeKey_luyou", dataProviderClass = DataMonitor.class)
    public void TestLuYOU(Object[] ob) {
        JSONObject js = new JSONObject();
        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
        js.put("sysNo", "2034");//系统号
        js.put("typeKey", ob[0]);//报警类型
        js.put("content", "测试报警监控-");//报警邮件内容
        js.put("num", ob[1]);//触发次数
        JSONObject re = MonitorTest.ResMon(js);
        System.out.println("返回结果：\n" + re.toString());
    }
//######################2019.10.24############################
//    /**
//     * 测试所有报警类型
//     * 通用报警---5003- ETL数据报送系统
//     *
//     * @param
//     */
//    @Test(dataProvider = "typeKey_ETL", dataProviderClass = DataMonitor.class)
//    public void TestETL(Object[] ob) {
//        JSONObject js = new JSONObject();
//        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
//        js.put("sysNo", "5003");//系统号
//        js.put("typeKey", ob[0]);//报警类型
//        js.put("content", "测试报警监控-");//报警邮件内容
//        js.put("num", "30");//触发次数
//        JSONObject re = MonitorTest.ResMon(js);
//        System.out.println("返回结果：\n" + re.toString());
//    }
//    /**
//     * 测试所有报警类型
//     * 通用报警---5004- 微分账系统
//     *
//     * @param
//     */
//    @Test(dataProvider = "typeKey_Profit", dataProviderClass = DataMonitor.class)
//    public void TestProfit(Object[] ob) {
//        JSONObject js = new JSONObject();
//        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
//        js.put("sysNo", "5004");//系统号
//        js.put("typeKey", ob[0]);//报警类型
//        js.put("content", "测试报警监控-");//报警邮件内容
//        js.put("num", "30");//触发次数
//        JSONObject re = MonitorTest.ResMon(js);
//        System.out.println("返回结果：\n" + re.toString());
//    }
//    /**
//     * 测试所有报警类型
//     * 通用报警---5005- 代理商系统
//     *
//     * @param
//     */
//    @Test(dataProvider = "typeKey_Agent", dataProviderClass = DataMonitor.class)
//    public void TestAgent(Object[] ob) {
//        JSONObject js = new JSONObject();
//        js.put("url", "https://test-monitor.ipaynow.cn/monitorTest");
//        js.put("sysNo", "5005");//系统号
//        js.put("typeKey", ob[0]);//报警类型
//        js.put("content", "测试报警监控-");//报警邮件内容
//        js.put("num", "30");//触发次数
//        JSONObject re = MonitorTest.ResMon(js);
//        System.out.println("返回结果：\n" + re.toString());
//    }
}

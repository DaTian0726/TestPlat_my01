package com.juhe.my01.testng.monitor;

import org.testng.annotations.DataProvider;

public class DataMonitor {
    /**
     * 所有系统号
     *
     * @return
     */
    @DataProvider(name = "sysNo")
    public Object[][] sysNo() {
        return new Object[][]{
                //{"系统号","报警类型","触发次数"}
//                {"2000","AppCenter","30"},//代付平台
//                {"2001","BackNotify","10"},//代付-渠道系统
                {"2002","AliPay","10"},//卡牌系统
                {"2003","AliPay","20"},//主扫系统
                {"2004","AliPay","20"},//公众号系统
                {"2006","AliPay","20"},//WAP系统
                {"2007","AliPay","20"},//被扫系统
                {"2008","WeBankConnectError","10"},//退款系统
                {"2009","AppCenter","20"},//posp系统
                {"2010","Alipay","20"},//手机APP（SDK）
                {"2011","AliPay","20"},//聚合API系统
                {"2025","AliPay","10"},//小程序系统
//                {"2027","NotifySystemConsumer","20"},//通知系统
                //2019年10月24日新增 @涛哥 测试
                //目前不支持测试 日志格式不一样
//                {"5003"},//ETL数据报送系统
//                {"5004"},//微分帐系统
//                {"5005"},//代理商系统
        };
    }

    /**
     * 代付专有
     *
     * @return
     */
    @DataProvider(name = "typeKey_daifu")
    public Object[][] typeKey_daifu() {
        return new Object[][]{
                {"AppCenter","30"},//代付平台-应用中心异常
                {"BackNotify","10"},//代付平台-商户后台通知异常
                {"BusinessRisk","20"},//代付平台-触发业务风控
                {"DataCenter","10"},//代付平台-同步数据中心异常
                {"DBError","10"},//代付平台-数据库异常
                {"Risk","10"},//代付平台-风控异常
                {"System","10"},//代付平台-系统异常
                {"AccountCoreSystem","10"},//代付平台-账户核心系统
                {"ChannelSystem","10"},//代付平台-渠道系统
                {"CalcFeeSystem","10"},//代付平台-计费系统
                {"PayRefund","10"},//代付平台-代付退票
        };
    }

    @DataProvider(name = "typeKey_daifuQ")
    public Object[][] typeKey_daifuQ() {
        return new Object[][]{
                {"AppCenter","10"},//代付平台-应用中心异常
                {"BackNotify","20"},//代付平台-商户后台通知异常
                {"BusinessRisk","10"},//代付平台-触发业务风控
                {"DataCenter","10"},//代付平台-同步数据中心异常
                {"DBError","10"},//代付平台-数据库异常
                {"Risk","10"},//代付平台-风控异常
                {"System","10"},//代付平台-系统异常
                {"JiuPaiPay","10"},//代付平台-九派渠道
                {"SuNingPay","10"},//代付平台-苏宁渠道
                {"SuNingRecharge","10"},//代付平台-苏宁代付充值
                {"AccAgentPay","20"},//代付渠道系统-账户代付异常
                {"AgentStatusError","1"},//代付渠道系统-交易状态异常
        };
    }

    @DataProvider(name = "typeKey_kapai")
    public Object[][] typeKey_KaiPai() {
        return new Object[][]{
                {"AliPay","10"},//卡牌-支付宝渠道异常
                {"AppCenter","20"},//卡牌-应用中心异常
                {"BackNotify","20"},//卡牌-后台通知异常
                {"BusinessRisk","50"},//卡牌-触发业务风控
                {"DataCenter","20"},//卡牌-同步数据中心异常
                {"DBError","20"},//卡牌-数据库异常
                {"JuHe","20"},//卡牌-同步老聚合异常
                {"MsAliPay","20"},//卡牌-民生支付宝渠道异常
                {"MsPay","20"},//卡牌-民生支付渠道异常
                {"MsWxPay","20"},//卡牌-民生微信渠道异常
                {"Risk","20"},//卡牌-风控系统异常
                {"SYSTEM","20"},//卡牌-系统异常
                {"WeBankPay","20"},//卡牌-微众渠道异常
                {"WxPay","20"},//卡牌-微信渠道异常
                {"WeBankConnectError","10"},//卡牌-连接异常异常
                {"WxConnectError","10"},//卡牌-微信连接异常
                {"YopPay","20"},//卡牌-易宝渠道异常
                {"YillionPay","20"},//卡牌-亿联渠道异常
                {"SxfPay","20"},//卡牌-随行付渠道异常
                {"UmfintechPay","20"},//卡牌-联动优势渠道异常
                {"HuiFuPay","10"},//卡牌-汇付渠道支付异常

        };
    }

    @DataProvider(name = "typeKey_zhusao")
    public Object[][] typeKey_zhusao() {
        return new Object[][]{
                {"AliPay","20"},//主扫-支付宝渠道异常
                {"AppCenter","20"},//主扫-应用中心异常
                {"BackNotify","20"},//主扫-后台通知商户异常
                {"BusinessRisk","50"},//主扫-触发业务风控
                {"DataCenter","20"},//主扫-同步数据中心异常
                {"DBError","20"},//主扫-数据库异常
                {"JuHe","20"},//主扫-同步老聚合异常
                {"MsAliPay","20"},//主扫-民生支付宝渠道异常
                {"MsWxPay","20"},//主扫-民生微信渠道异常
                {"MszhAliPay","20"},//主扫-民生总行支付宝
                {"MszhPay","20"},//主扫-民生总行
                {"MszhWxPay","20"},//主扫-民生总行微信
                {"MybankAliPay","20"},//主扫-网商银行支付宝
                {"MyBankPay","20"},//主扫-网商银行
                {"MybankWxPay","20"},//主扫-网商银行微信
                {"Risk","20"},//主扫-风控异常
                {"System","20"},//主扫-系统错误
                {"WeBankPay","20"},//主扫-微众微信渠道异常
                {"WxPay","20"},//主扫-微信渠道异常
                {"WeBankConnectError","10"},//主扫-连接异常异常
                {"RealTimeCharging","1"},//主扫-实时计费异常
                {"WxConnectError","10"},//主扫-微信连接异常
                {"YopPay","10"},//主扫-易宝支付异常
                {"SxfPay","10"},//主扫-随行付支付异常
                {"YillionPay","10"},//主扫-亿联银行支付异常
                {"ScenetecPay","10"},//主扫-信钛支付异常
                {"UmfintechPay","10"},//主扫-联动优势支付异常
                {"HuiFuPay","10"},//主扫-汇付渠道支付异常
        };
    }

    @DataProvider(name = "typeKey_gongzhonghao")
    public Object[][] typeKey_gongzhonghao() {
        return new Object[][]{
                {"AliPay","20"},//公众号-支付宝渠道异常
                {"AppCenter","20"},//公众号-应用中心异常
                {"BackNotify","50"},//公众号-商户后台通知异常
                {"BusinessRisk","50"},//公众号-触发业务风控
                {"DataCenter","20"},//公众号-同步数据中心异常
                {"DBError","20"},//公众号-数据库异常
                {"DBInsertTime","20"},//公众号-数据库Insert耗时
                {"MsAliPay","20"},//公众号-民生支付宝渠道异常
                {"MsPay","20"},//公众号-民生渠道异常
                {"MsWxPay","20"},//公众号-民生微信渠道异常
                {"MszhAliPay","20"},//公众号-民生总行支付宝
                {"MszhPay","20"},//公众号-民生总行
                {"MszhWxPay","20"},//公众号-民生总行微信
                {"MybankAliPay","20"},//公众号-网商银行支付宝
                {"MyBankPay","20"},//公众号-网商银行
                {"MybankWxPay","20"},//公众号-网商银行微信
                {"Risk","20"},//公众号-风控异常
                {"System","20"},//公众号-系统异常
                {"WeBankPay","20"},//公众号-微众微信渠道异常
                {"WxPay","20"},//公众号-微信渠道异常
                {"WeBankConnectError","10"},//公众号-连接异常异常
                {"SxfPay","20"},//公众号-随行付异常
                {"YopPay","20"},//公众号-易宝支付异常
                {"AiBankPay","20"},//公众号-百信银行异常
                {"RealTimeCharging","1"},//公众号-实时计费异常
                {"WxConnectError","10"},//公众号-微信连接异常
                {"ScenetecPay","20"},//公众号-信肽支付异常
                {"YillionPay","20"},//公众号-亿联支付异常
                {"UmfintechPay","20"},//公众号-联动优势异常
                {"HuiFuPay","10"},//公众号-汇付渠道支付异常
                {"UnionAggPay","10"},//公众号-河北银商通道
        };
    }

    @DataProvider(name = "typeKey_wap")
    public Object[][] typeKey_wap() {
        return new Object[][]{
                {"AliPay","20"},//WAP-支付宝渠道异常
                {"AppCenter","20"},//WAP-应用中心异常
                {"BackNotify","20"},//WAP-后台通知异常
                {"BusinessRisk","50"},//WAP-触发业务风控
                {"DBError","20"},//WAP-数据库异常
                {"MsUnionPay","20"},//WAP-民生银联异步通知异常
                {"PingAnZFB","40"},//WAP-平安支付宝异常
                {"Risk","20"},//WAP-风控异常
                {"System","20"},//WAP-系统错误
                {"WeBankPay","30"},//WAP-微众(微信)支付异常
                {"WxPay","20"},//WAP-微信渠道异常
                {"WeBankConnectError","10"},//WAP-连接异常异常
                {"RealTimeCharging","1"},//WAP-手机网页-实时计费异常
                {"WxConnectError","10"},//WAP-微信连接异常
                {"UnionAggPay","4"},//WAP-河北银商通道
                {"TradeModelError","1"},//WAP-应用中心获取交易模式异常
                {"HuiFuPay","10"},//WAP-汇付渠道支付异常
                {"UnionPayAllChannels","10"},//WAP-银联全渠道异常
        };
    }

    @DataProvider(name = "typeKey_barcode")
    public Object[][] typeKey_barcode() {
        return new Object[][]{
                {"AliPay","20"},//被扫-支付宝渠道异常
                {"AppCenter","20"},//被扫-应用中心异常
                {"BackNotify","20"},//被扫-后台通知商户异常
                {"BusinessRisk","20"},//被扫-触发业务风控
                {"DataCenter","20"},//被扫-同步数据中心异常
                {"DBError","20"},//被扫-数据库异常
                {"DelayOrder","1"},//延迟订单
                {"JuHe","20"},//被扫-同步老聚合异常
                {"MsAliPay","20"},//被扫-民生支付宝渠道异常
                {"MsWxPay","20"},//被扫-民生微信渠道异常
                {"MszhAliPay","20"},//被扫民生总行银行支付宝
                {"MszhPay","20"},//被扫民生总行
                {"MszhWxPay","20"},//被扫民生总行微信
                {"MybankAliPay","20"},//被扫网商银行支付宝
                {"MyBankPay","20"},//被扫网商银行
                {"MybankWxPay","20"},//被扫网商银行微信
                {"Risk","20"},//被扫-风控异常
                {"System","20"},//被扫-系统错误
                {"WeBankPay","20"},//被扫-微众微信渠道异常
                {"WxPay","20"},//被扫-微信渠道异常
                {"WeBankConnectError","10"},//连接异常异常
                {"RealTimeCharging","1"},//被扫-实时计费异常
                {"UmfintechPay","10"},//被扫-联动优势异常
                {"YopPay","10"},//被扫-易宝支付异常
                {"YillionPay","10"},//被扫-亿联支付异常
                {"SxfPay","10"},//被扫-随行付支付异常
                {"HuiFuPay","10"},//被扫-汇付渠道支付异常
                {"UnionPay","10"},//被扫-银联支付异常
        };
    }

    @DataProvider(name = "typeKey_refund")
    public Object[][] typeKey_refund() {
        return new Object[][]{
                {"WeBankConnectError","10"},//连接异常异常
                {"YopPay","20"},//退款-易宝支付异常
                {"HuiFuPay","10"},//退款-汇付渠道异常
        };
    }

    @DataProvider(name = "typeKey_posp")
    public Object[][] typeKey_posp() {
        return new Object[][]{
                {"AppCenter","20"},//POSP-应用中心异常
                {"BackNotify","20"},//POSP-后台通知商户异常
                {"BarcodePayError","10"},//POSP-调用被扫系统异常
                {"BusinessRisk","20"},//POSP-触发业务风控
                {"DataCenter","20"},//POSP-同步数据中心异常
                {"DBError","20"},//POSP-数据库异常
                {"FatalError","1"},//POSP-加密机异常
                {"ForeignLinkError","5"},//外卡连接异常
                {"JuHe","20"},//POSP-同步老聚合异常
                {"MsAliPay","20"},//POSP-民生支付宝渠道异常
                {"MsWxPay","20"},//POSP-民生微信渠道异常
                {"POSCardPay","1"},//POSP-POSP卡支付异常
                {"RefundError","10"},//POSP-调用退款系统异常
                {"ReverseFail","20"},//POSP-冲正失败
                {"Risk","20"},//POSP-风控异常
                {"SSMError","10"},//POSP-加密机错误
                {"System","20"},//POSP-系统异常
                {"WeBankPay","20"},//POSP-微众微信渠道异常
                {"WxPay","20"},//POSP-微信渠道异常
        };
    }

    @DataProvider(name = "typeKey_SDK")
    public Object[][] typeKey_SDK() {
        return new Object[][]{
                {"Alipay","20"},//SDK-支付宝渠道异常
                {"AppCenter","20"},//SDK-应用中心异常
                {"DBError","20"},//SDK-数据库异常
                {"PingAnZFB","20"},//SDK-平安支付宝异常
                {"Risk","20"},//SDK-风控异常
                {"System","20"},//SDK-系统错误
                {"WeBankPay","20"},//SDK-微众(微信)支付异常
                {"WxPay","25"},//SDK-微信渠道异常
                {"WeBankConnectError","10"},//SDK-连接异常异常
                {"WeBankWalletPay","20"},//SDK-微众钱包异常
                {"YopPay","20"},//SDK系统-易宝支付异常
                {"AiBankPay","20"},//SDK系统-百信银行异常
                {"RealTimeCharging","1"},//SDK--实时计费异常
                {"ScenetecPay","20"},//SDK-信肽支付异常
                {"YillionPay","20"},//SDK-亿联支付异常
                {"UmfintechPay","20"},//SDK-联动优势支付异常
                {"WxConnectError","10"},//SDK-微信连接异常
                {"UnionAggPay","10"},//SDK-河北银商通道
                {"TradeModelError","1"},//SDK-应用中心获取交易模式异常
                {"HuiFuPay","10"},//SDK-汇付渠道支付异常
                {"BusinessRisk","20"},//SDK-风控异常
                {"UnionPayAllChannels","10"},//SDK-银联全渠道异常
                {"YijiQuickPay","10"},//SDK-易极付快捷支付异常
        };
    }

    @DataProvider(name = "typeKey_API")
    public Object[][] typeKey_API() {
        return new Object[][]{
                {"AliPay","20"},//API-支付宝异步通知异常
                {"AppCenter","20"},//API-应用中心异常
                {"BusinessSystem","20"},//API-调用业务系统异常
                {"DelayOrder","1"},//延迟订单
                {"MsPay","20"},//API-民生总行支付异步通知异常
                {"MsUnionPay","20"},//API-民生银联异步通知异常
                {"System","40"},//API-系统异常
                {"WeBankPay","20"},//API-微众异步通知异常
                {"WxPay","20"},//API-微信异步通知异常
                {"WeBankWalletPay","20"},//API系统-微众钱包异常
                {"YopPay","20"},//API系统-易宝支付异常
                {"SxfPay","20"},//API系统-随行付异常
                {"WalletPay","20"},//API系统-大黄蜂会员钱包异常
                {"AiBankPay","20"},//API系统-百信银行异常
                {"ScenetecPay","20"},//API系统-信肽支付异常
                {"YillionPay","20"},//API系统-亿联银行异常
                {"OrangeBankPay","20"},//API系统-平安银行异常
                {"HuiFuPay","10"},//API-汇付渠道支付异常
                {"AppCenterParam","50"},//API-应用中心异常
        };
    }

    /**
     * 微信分账-手机网页与手机APP
     *
     * @return
     */
    @DataProvider(name = "typeKey_fenzhang")
    public Object[][] typeKey_fenzhang() {
        return new Object[][]{
                {"RealTimeCharging"},//实时计费异常
        };
    }

    @DataProvider(name = "typeKey_webpay")
    public Object[][] typeKey_webpay() {
        return new Object[][]{
                {"AppCenter","20"},//webPay系统-应用中心异常
                {"AppCenterParam","20"},//webPay系统-应用中心参数异常
                {"BusinessRisk","60"},//webPay系统-业务风控异常
                {"BusinessSystem","20"},//webPay系统-业务系统异常
                {"DBError","20"},//webPay系统-数据库异常
                {"PingAnZFB","20"},//webPay系统-平安支付宝异常
                {"Risk","20"},//webPay系统-风控异常
                {"SwitchSystemError","20"},//webPay系统-中转系统异常
                {"System","20"},//webPay系统-系统异常
                {"UnionPay","20"},//webPay系统-银联支付异常
        };
    }

    @DataProvider(name = "typeKey_xiaochengxu")
    public Object[][] typeKey_xiaochengxu() {
        return new Object[][]{
                {"RealTimeCharging","1"},//小程序-实时计费异常
                {"WxConnectError","10"},//微信连接异常
                {"ScenetecPay","20"},//小程序-信肽支付异常
                {"System","1"},//小程序-系统异常
                {"WxPay","10"},//小程序-微信支付异常
                {"AliPay","10"},//小程序-支付宝支付异常
                {"YopPay","10"},//小程序-易宝支付异常
                {"YillionPay","10"},//小程序-亿联支付异常
                {"SxfPay","10"},//小程序-随行付支付异常
                {"MyBankPay","10"},//小程序-网商银行支付异常
                {"UmfintechPay","10"},//小程序-联动优势支付异常
                {"HuiFuPay","10"},//小程序-汇付渠道支付异常
                {"AppCenter","20"},//小程序-应用中心异常
                {"BackNotify","20"},//小程序-后台通知异常
                {"BusinessRisk","50"},//小程序-触发业务风控
                {"DataCenter","20"},//小程序-同步数据中心异常
                {"Risk","20"},//小程序-风控系统异常
                {"SYSTEM","20"},//小程序-系统异常
        };
    }

    @DataProvider(name = "typeKey_tongzhi")
    public Object[][] typeKey_tongzhi() {
        return new Object[][]{
                {"NotifySystemConsumer","20"},//通知系统消费异常
        };
    }

    @DataProvider(name = "typeKey_luyou")
    public Object[][] typeKey_luyou() {
        return new Object[][]{
                {"MqConsume","1"},//智能路由系统-MQ消费异常
                {"RouterExchange","1"},//智能路由系统-路由切换异常
                {"AppCenter","1"},//智能路由系统-调用应用中心异常
                {"RouterSubMchIdDel","1"},//智能路由系统-路由子号删除
        };
    }
//####################//2019年10月24日新增############################
@DataProvider(name = "typeKey_ETL")
public Object[][] typeKey_ETL() {
    return new Object[][]{
            {"EtlBusinessLogicError"},//ETL数据报送业务逻辑错误
            {"EtlSysExeception"},//ETL数据报送系统异常
    };
}
    @DataProvider(name = "typeKey_Profit")
    public Object[][] typeKey_Profit() {
        return new Object[][]{
                {"ProfitBatchSysExeception"},//微分账Batch系统异常
                {"ProfitBatchBusinessLogicError"},//微分账Batch业务逻辑错误
                {"ProfitWebBusinessLogicError"},//微分账Web业务逻辑错误
                {"ProfitWebRequestWeChatError"},//微分账Batch业务逻辑错误
                {"ProfitBatchBusinessLogicError"},//微分账Web请求微信失败
                {"ProfitWebConsumeAndPersistenceError"},//微分账Web消费MQ数据入库发生异常
                {"ProfitWebConsumeAndBusinessLogicError"},//微分账Web消费MQ数据入库查询或业务逻辑异常
                {"ProfitWebSysExeception"},//微分账Web系统异常
        };
    }
    @DataProvider(name = "typeKey_Agent")
    public Object[][] typeKey_Agent() {
        return new Object[][]{
                {"AgentProfitLogicError"},//代理商系统业务逻辑异常
                {"AgentProfitReceiveCleanDataError"},//代理商系统接收清算数据异常
                {"AgentProfitSendDwError"},//代理商系统报送数据仓库异常
                {"AgentProfitSendDcError"},//代理商系统报送数据中心异常
        };
    }
}
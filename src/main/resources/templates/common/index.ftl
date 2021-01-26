<html>
<head>
    <meta charset="utf-8">
    <title>现在支付-测试平台</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="./homepage.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<#include "../common/top.ftl">
<div class="container" id="content">
    <div class="row">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <h3 class="text-info text-center">
                        运营后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://op-test1.ipaynow.cn/businessAccount'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://op.ipaynow.cn/login'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        聚合商户后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mch-test.ipaynow.cn/login'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mch-pre.ipaynow.cn/login'">预发布环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mch.ipaynow.cn/login'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        soso商户后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://soso-test.ipaynow.cn/'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://soso.ipaynow.cn/'">生产环境</button>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <h3 class="text-info text-center">
                        佳薪棠商户后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://tang-api-test.ipaynow.cn/jiaxin_frontend/#/login'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://tang.ipaynow.cn/#/login?redirect=%2Findex'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        佳薪棠供应商后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mch-test.ipaynow.cn/pond_supplier/#/user/login'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://sp.ipaynow.cn/#/user/login'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        应用中心(先登录运营后台)
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://op-test1.ipaynow.cn/app_center/app-center-util.do'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://op.ipaynow.cn/app_center/app-center-util.do'">生产环境</button>
                </div>

<#--                //TODO-->
<#--                <div class="col-md-4 column">-->
<#--                    <h3 class="text-center text-info">-->
<#--                        慧财税商户后台-->
<#--                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mch-test.ipaynow.cn/pond_front/#/login'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mpp.ipaynow.cn/#/login'">生产环境</button>-->
<#--                </div>-->
            </div>
<#--            <div class="row clearfix">-->
<#--                <div class="col-md-4 column">-->
<#--                    <h3 class="text-info text-center">-->
<#--                        慧财税供应商后台-->
<#--                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mch-test.ipaynow.cn/pond_supplier/#/user/login'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://spp.ipaynow.cn/#/user/login'">生产环境</button>-->
<#--                </div>-->
<#--                <div class="col-md-4 column">-->
<#--                    <h3 class="text-center text-info">-->
<#--                        众邦灵工-->
<#--                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mpp-zb.ipaynow.cn/#/login'">生产环境-商户后台</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://spp-zb.ipaynow.cn/#/user/login'">生产环境-供应商后台</button>-->
<#--                </div>-->
<#--                <div class="col-md-4 column">-->
<#--                    <h3 class="text-center text-info">-->
<#--                        工具大全-->
<#--                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'http://tool.chinaz.com/tools/urlencode.aspx'">Undecode工具</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'http://tool.chinaz.com/tools/imgtobase/'">Base64工具</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://devtools.lilbaby.cn/dashboard#/idcard/index'">测试平台</button>-->
<#--                </div>-->
<#--            </div>-->



            <div class="row clearfix">
                <div class="col-md-4 column">
                    <h3 class="text-info text-center">
                        跨境金融后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://globaltransfer-op-test.ipaynow.cn/login'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://inter-op.ipaynow.cn/'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        跨境商户后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://dby.ipaynow.cn/international_platform_mvc/login/index'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://global.ipaynow.cn/nz/login/index'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        跨境官网地址
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://global.ipaynow.cn/'">跨境官网正式</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://globaltransfer.ipaynow.cn//'">跨境金融正式</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://www.ipaynow.cn/'">现在支付正式</button>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <h3 class="text-info text-center">
                        招商云运营后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://cmb-optest.ipaynow.cn/login'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://op.aggreg.cmbchina.com/'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        招商云商户后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://cmb-mch-test.ipaynow.cn/login'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://cmb-mch-release.ipaynow.cn/login'">预发布环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mch.aggreg.cmbchina.com/login'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        应用中心(招商云)
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'http://192.168.101.102:8081/cmb_dubbo_http_adapter/index'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://mch.aggreg.cmbchina.com/cmb_dubbo_http_adapter/'">生产环境</button>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <h3 class="text-info text-center">
                        紫光云运营后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'op.houyuwei.com'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://payop.iqc-app.com'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        紫光云商户后台
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'mch.houyuwei.com'">测试环境</button> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'https://paymch.iqc-app.com'">生产环境</button>
                </div>
                <div class="col-md-4 column">
                    <h3 class="text-center text-info">
                        应用中心(紫光云)
                    </h3> <button type="button" class="btn btn-default btn-block btn-primary" onclick="window.location.href = 'http://scmch.houyuwei.com:4433/dubbo_http_adapter/app_biz_center'">生产环境</button>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>


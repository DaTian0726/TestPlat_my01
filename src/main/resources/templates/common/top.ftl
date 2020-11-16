<#--<nav class="navbar navbar-inverse navbar-fixed-top">-->
<div class="col-md-12 column">
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"  >聚合测试平台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/cardPay?state=huifu" class="dropdown-toggle"  >聚合交易
                        <span class="caret"></span></a>
                </li>
                <li class="dropdown">
                    <a href="/CMBActivePay" class="dropdown-toggle" data-toggle="dropdown">招商银行
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
<#--                        <li class="dropdown-header">招商云交易</li>-->
<#--                        <li><a href="/CMBActivePay" >主扫系统</a></li>-->
<#--                        <li><a href="/CMBBarcodePay" >被扫系统</a></li>-->
<#--                        <li><a href="/CMBTradePay" >H5系统</a></li>-->
<#--                        <li><a href="/CMBRefund" >退款系统</a></li>-->
<#--                        <li><a href="/CMBWeChatPay" >小程序系统</a></li>-->
<#--                        <li><a href="/CMBJuHeMaPay" >聚合动态码</a></li>-->
<#--                        <li class="divider"></li>-->
                        <li class="dropdown-header">招商系统</li>
                        <li><a href="http://192.168.101.102:8081/cmb_dubbo_http_adapter/app_biz_center" target="_blank">应用中心测试</a></li>
                        <li><a href="https://mch.aggreg.cmbchina.com/cmb_dubbo_http_adapter/" target="_blank">应用中心生产</a></li>
                        <li><a href="https://mch.aggreg.cmbchina.com/login" target="_blank">招商商户后台生产</a></li>
                        <li><a href="https://op.aggreg.cmbchina.com/login" target="_blank">招商运营后台生产</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">工具包
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/des" >清结算DES解密</a></li>
                        <li><a href="/url"  >Undecode工具</a></li>
                        <li><a href="#" >验签工具</a></li>
<#--                        <li><a href="https://cli.im/"  target="_blank">草料二维码</a></li>-->
<#--                        <li><a href="http://mock-api.com/app.html#!/mocker-dashboard" target="_blank">mock_api</a></li>-->
                        <li><a href="https://devtools.lilbaby.cn/dashboard#/idcard/index" target="_blank">coder烂笔头</a></li>
                    </ul>
                </li>
<#--                <li class="dropdown">-->
<#--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">佳薪棠测试-->
<#--                        <span class="caret"></span></a>-->
<#--                    <ul class="dropdown-menu">-->
<#--                        <li class="dropdown-header">佳薪棠</li>-->
<#--&lt;#&ndash;                        <li><a href="https://op-test1.ipaynow.cn/businessAccount"  >测试环境-运营后台</a></li>&ndash;&gt;-->
<#--                        <li><a href="https://mch-test.ipaynow.cn/jiaxin_supplier/login#/user/login"  >供应商后台</a></li>-->
<#--                        <li><a href="https://mch-test.ipaynow.cn/jiaxin_frontend/#/index"  >商户后台</a></li>-->
<#--                        <li class="divider"></li>-->
<#--                        <li class="dropdown-header">池塘Saas-慧财税</li>-->
<#--&lt;#&ndash;                        <li><a href="https://op-test1.ipaynow.cn/businessAccount"  >测试环境-运营后台</a></li>&ndash;&gt;-->
<#--                        <li><a href="https://mch-test.ipaynow.cn/pond_supplier/#/user/login"  >供应商后台</a></li>-->
<#--                        <li><a href="https://mch-test.ipaynow.cn/pond_front/#/login"  >商户后台</a></li>-->
<#--                    </ul>-->
<#--                </li>-->
<#--                <li class="dropdown">-->
<#--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">佳薪棠生产-->
<#--                        <span class="caret"></span></a>-->
<#--                    <ul class="dropdown-menu">-->
<#--                        <li class="dropdown-header">佳薪棠</li>-->
<#--&lt;#&ndash;                        <li><a href="https://op.ipaynow.cn/login"  >生产环境-运营后台</a></li>&ndash;&gt;-->
<#--                        <li><a href="https://sp.ipaynow.cn/#/user/login"  >供应商后台</a></li>-->
<#--                        <li><a href="https://tang.ipaynow.cn/#/login?redirect=%2Findex"  >商户后台</a></li>-->
<#--                        <li class="divider"></li>-->
<#--                        <li class="dropdown-header">池塘Saas-慧财税</li>-->
<#--&lt;#&ndash;                        <li><a href="https://op.ipaynow.cn/login"  >生产环境-运营后台</a></li>&ndash;&gt;-->
<#--                        <li><a href="https://spp.ipaynow.cn/#/user/login"  >供应商后台</a></li>-->
<#--                        <li><a href="https://mpp.ipaynow.cn/#/login"  >商户后台</a></li>-->
<#--                        <li class="divider"></li>-->
<#--                        <li class="dropdown-header">池塘Saas-众邦灵工</li>-->
<#--&lt;#&ndash;                        <li><a href="https://op.ipaynow.cn/login"  >生产环境-运营后台</a></li>&ndash;&gt;-->
<#--                        <li><a href="https://spp-zb.ipaynow.cn/#/user/login"  >供应商后台</a></li>-->
<#--                        <li><a href="https://mpp-zb.ipaynow.cn/#/login"  >商户后台</a></li>-->
<#--                    </ul>-->
<#--                </li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">自动化
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
<#--                        <li class="dropdown-header">聚合交易</li>-->
                        <li><a href="/auto/thread" >多线程处理</a></li>
                        <li><a href="/auto/index" >文件处理</a></li>
<#--                        <li><a href="#" >小程序自动化回归</a></li>-->
<#--                        <li><a href="#" >聚合码自动化回归</a></li>-->
<#--                        <li class="divider"></li>-->
<#--                        <li class="dropdown-header">佳薪棠</li>-->
<#--                        <li><a href="#" >商户后台UI回归</a></li>-->
<#--                        <li><a href="#" >供应商后台UI回归</a></li>-->
<#--                        <li><a href="#" >商户后台接口回归</a></li>-->
<#--                        <li><a href="#" >供应商后台接口回归</a></li>-->
<#--                        <li><a href="#" >API接口回归</a></li>-->
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle" >佳薪棠
                        <span class="caret"></span></a>
                </li>
                <li>
                    <a href="/monitor" class="dropdown-toggle"  >监控系统
                        <span class="caret"></span></a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">更多
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="http://redmine.ipaynow.cn/redmine/projects" target="_blank" >RedMine</a></li>
                        <li><a href="http://zentao.ipaynow.cn/index.php?m=my&f=index" target="_blank">禅道</a></li>
                        <li><a href="http://sonar.ipaynow.cn/" target="_blank">Sonar</a></li>
                        <li><a href="http://code.ipaynow.cn:8089/login?from=%2F" target="_blank">Jenkins</a></li>
                        <li><a href="http://posp.ipaynow.cn:10808/QRCSample/" target="_blank">银联仿真码</a></li>

                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="关键字">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </div>
    </div>
</nav>
</div>
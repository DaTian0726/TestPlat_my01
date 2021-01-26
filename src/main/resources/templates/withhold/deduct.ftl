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
        <#include "../common/menu.ftl">
        <h3 class="text-center text-info">
            公有云-代付测试Demo</h3>
        <div class="col-md-9" style="padding: 0px 0px 0px 0px;">
            <div id="tabs-302048" class="tabbable">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="/sign">签约接口</a></li>
                    <li class=""><a href="/signquery">签约查询接口</a></li>
                    <li class=""><a href="/unbundle">解约接口</a></li>
                    <li class=""><a href="/deduct">扣款申请</a></li>
                    <li class=""><a href="/deductquery">扣款查询</a></li>
                </ul>
            </div>
            <form class="form-horizontal" role="form" style="padding: 20px 0px 0px 0px" action="deduct" method="post">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-3 control-label">我司公钥</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="privateKey" autocomplete="off" placeholder="内置公钥，如修改后可填写" value="${(signModel.publicKey)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户私钥</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="publicKey" autocomplete="off" placeholder="内置私钥，如修改后可填写" value="${(signModel.privateKey)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">应用ID</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="appId" autocomplete="off" placeholder="内置appID，如修改后可填写" value="${(signModel.appId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">版本号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="version" value="${(signModel.version)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户后台通知地址</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="notifyUrl" value="${(signModel.notifyUrl)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户AppID（非必填）</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtSubAppId" value="${(signModel.mhtSubAppId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">现在支付签约id(签约后返回contract_code)</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="contractId" value="${(signModel.contractId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户订单号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderNo" value="${(signModel.mhtOrderNo)!''}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">订单名称</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderName" value="${(signModel.mhtOrderName)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">订单详情</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderDetail" value="${(signModel.mhtOrderDetail)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">订单金额</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderAmt" value="${(signModel.mhtOrderAmt)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">支付渠道</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="payChannelType" value="${(signModel.payChannelType)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户保留域</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtReserved" value="${(signModel.mhtReserved)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-7">
                        <button type="submit" class="btn btn-primary" name="submit" value="test">测试环境</button>
                        <button type="submit" class="btn btn-primary" name="submit" value="line">生产环境</button>
                    </div>
                </div>
            </form>
        </div>
        <#include "../common/msg.ftl">
    </div>
</div>
</body>
</html>

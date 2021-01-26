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
            <form class="form-horizontal" role="form" style="padding: 20px 0px 0px 0px" action="unbundle" method="post">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-3 control-label">我司公钥</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="privateKey" autocomplete="off" placeholder="内置公钥，如修改后可填写" value="${(signModel.privateKey)!''}"/>
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
                    <label for="inputPassword3" class="col-sm-3 control-label">商户通知地址</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="notifyUrl" value="${(signModel.notifyUrl)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户签约协议号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtContractCode" autocomplete="off" placeholder="请输入该值进行解约！" value="${(signModel.mhtContractCode)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">签约模板ID</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="planId" value="${(signModel.planId)!''}"/>
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

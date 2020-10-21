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
            <form class="form-horizontal" role="form" style="padding: 20px 0px 0px 0px" action="sign" method="post">
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
                    <label for="inputPassword3" class="col-sm-3 control-label">签约模板ID</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="planId" value="${(signModel.planId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">渠道类型（微信）</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="payChannelType" value="${(signModel.payChannelType)!''}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">签约方式（01公众号/02H5/03小程序）</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="contractType" value="${(signModel.contractType)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">签约显示名称</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtContractDisplayName" value="${(signModel.mhtContractDisplayName)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户签约用户标识</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtContractUserId" value="${(signModel.mhtContractUserId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">公众号签约回调标识</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="returnWeb" value="${(signModel.returnWeb)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">H5签约回到appID</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="callbackAppId" value="${(signModel.callbackAppId)!''}"/>
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

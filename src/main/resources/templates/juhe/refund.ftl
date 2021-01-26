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
        <div class="col-md-9" style="padding: 0px 0px 0px 0px;">
            <h3 class="text-center text-info">
                退款测试Demo</h3>
            <HR align=center width=100% color=#987cb9 SIZE=1>
            <form class="form-horizontal" role="form" action="refund" method="post">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">环境选择</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="URL">
                            <option name="refund-test" value="refund-test">测试环境</option>
                            <option name="refund-pre" value="refund-pre">预发布环境</option>
                            <option name="refund-line" value="refund-line">生产环境</option>
                        </select>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">服务选择</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="Service">
                            <option name="juhe" value="juhe">公有云</option>
                            <option name="cmb" value="cmb">招商云</option>
                            <option name="zg" value="zg">紫光云</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-3 control-label">应用ID</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="appId" value="${(refundModel.appId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">应用秘钥</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="appKey" value="${(refundModel.appKey)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">现在支付流水号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="oriTransId" value="${(refundModel.oriTransId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户订单号(比原单优先级弱)</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderNo" value="${(refundModel.mhtOrderNo)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">退款金额（分）</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="amount" value="${(refundModel.amount)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">退款单号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtRefundNo" value="${(refundModel.mhtRefundNo)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">功能码（R001退款/R002撤销）</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="funcode" value="${(refundModel.funcode)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户后台通知地址</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="notifyUrl" value="${(refundModel.notifyUrl)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">版本号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="version" value="${(refundModel.version)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-6 col-sm-6">
                        <button type="submit" class="btn btn-primary" name="submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>
        <#include "../common/msg.ftl">
    </div>
</div>
</body>
</html>

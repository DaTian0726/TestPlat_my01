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
                被扫测试Demo</h3>
            <HR align=center width=100% color=#987cb9 SIZE=1>
            <form class="form-horizontal" role="form" action="barcodePay" method="post">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">环境选择</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="URL">
                            <option name="test" value="test">测试环境</option>
                            <option name="pre" value="pre">预发布环境</option>
                            <option name="line" value="line">生产环境</option>
                        </select>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">服务选择</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="Service">
                            <option name="juhe" value="juhe">公有云</option>
                            <option name="cmb" value="cmb">招商云</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-3 control-label">应用ID</label>
                    <div class="col-sm-9">
                    <input type="text" class="form-control" name="appId" value="${(barcodeModel.appId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">应用秘钥</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="appKey" value="${(barcodeModel.appKey)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">支付码</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="channelAuthCode" value="${(barcodeModel.channelAuthCode)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">现在支付支付网关</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="payChannelType" value="${(barcodeModel.payChannelType)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">订单名称</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderName" value="${(barcodeModel.mhtOrderName)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">订单金额（分）</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderAmt" value="${(barcodeModel.mhtOrderAmt)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">订单详情</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderDetail" value="${(barcodeModel.mhtOrderDetail)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">超时时间</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtOrderTimeOut" value="${(barcodeModel.mhtOrderTimeOut)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户后台通知地址</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="notifyUrl" value="${(barcodeModel.notifyUrl)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">是否限制银行卡（0/1）</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtLimitPay" value="${(barcodeModel.mhtLimitPay)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户终端号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtTermId" value="${(barcodeModel.mhtTermId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">商户门店号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtStoreId" value="${(barcodeModel.mhtStoreId)!''}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-3 control-label">版本号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="mhtStoreId" value="${(barcodeModel.version)!''}"/>
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

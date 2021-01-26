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
            <div class="item1 update_pic">
                <div class="alert alert-dismissable alert-warning">
                    <center>
                        <strong>说明：本模块用于模拟商户异步通知，地址为：http://ipaynow.natapp1.cc/asyn.业务枚举类型暂未覆盖待优化！</strong>
                    </center>
                </div>
            </div>
            <h3 class="text-center text-info">
                通知系统</h3>
            <HR align=center width=100% color=#987cb9 SIZE=1>
            <div class="col-sm-12">
                <form class="form-horizontal" role="form" action="notify" method="post">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-1 control-label">流水号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="transId" id="transId"/>
                        </div>
                        <label for="inputEmail3" class="col-sm-1 control-label">订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="mhtOrderNo" id="mhtOrderNo"/>
                        </div>
                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-primary" name="submit">查询</button>
                        </div>
                    </div>
                </form>
            </div>
            <HR align=center width=100% color=#987cb9 SIZE=1>

            <#if state == "1">
                <span><h4 class="text-center text-error">暂无通知信息</h4></span>
            <#elseif state == "0">
            <#list list as req>
                <p>${(req)!''}</p>
                <HR align=center width=100% color=#987cb9 SIZE=1>
            </#list>
                <#else>
                <span></span>
            </#if>
        </div>
        <#include "../common/msg.ftl">
    </div>
</div>
</body>
</html>

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
        <div class="col-md-10" style="padding: 0px 0px 0px 0px;">
            <div class="row clearfix">
            <div class="col-md-5 column">
                <h5>请求参数：</h5>
                <#--            <p id="request_show" style="width: 100%;"><span>${request}</span></p>-->
                <textarea id="content" name="content" rows="30" cols="150" class="form-control" style="width: 100%;height: 40%">
                ${request}
            </textarea>
            </div>
            <div class="col-md-5 column">
                <h5>返回参数：</h5>
                <textarea id="content" name="content" rows="30" cols="150" class="form-control" style="width: 100%;height: 40%">${response}</textarea>
                <#--            <p id="response_show" style="width: 100%;"><span style="width: 500px"></span></p>-->
            </div>
            </div>
<#--            -->
<#--            <HR align=center width=100% color=#987cb9 SIZE=1>-->
            <HR align=center width=100% color=#987cb9 SIZE=1>
            <#if img!=''>
                <#if state == '0'>
                    <h5>支付二维码：</h5>
                    <img src="${(img)!''}">
                    <HR align=center width=100% color=#987cb9 SIZE=1>
                <#elseif state == '1'>
                    <h5>支付链接凭证：</h5>
                    <p>${(img)!''}</p>
                    <HR align=center width=100% color=#987cb9 SIZE=1>
                <#else >
                    <span></span>
                </#if>
            </#if>
            <div class="form-group" style="padding: 50px 0px 0px 0px">
                <a href="http://www.json.cn/" target="_blank">JSON格式转换链接</a>
            </div>
            <div class="form-group" style="padding: 20px 0px 0px 0px">
                <a href="https://cli.im/" style="padding: 50px 100px 0px 0px" target="_blank">草料二维码生成链接</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

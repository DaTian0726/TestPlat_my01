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
    <body>
    <center><h3 style="color: blue">退款同步结算报文解析</h3></center>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <form class="form-horizontal" role="form" action="des" method="post">
                    <div class="form-group">
                        <label for="verifySign">同步报文内容:</label>
                        <textarea class="form-control" rows="20" id="verifySign" name="verifySign" autocomplete="off" placeholder="加密报文">${(des)!''}</textarea>
                        <b>解密秘钥：</b>
                        <input type="text" class="form-control" id="key" name="key" autocomplete="off" placeholder="此处不需要填写，如更换秘钥时填写，已内置秘钥，点击下方按钮即可！">
                        <div class="form-group">
                            <div class="col-sm-offset-5 col-sm-5" style="padding: 20px 0px 0px 0px">
                                <button type="submit" class="btn btn-primary" name="submit" value="test">测试环境</button>
                                <button type="submit" class="btn btn-primary" name="submit" value="line">生产环境</button>
                            </div>
                        </div>
                        <div>
                            <div class="form-group" style="padding: 50px 0px 0px 0px">
                                <a href="http://www.json.cn/" target="_blank">JSON格式转换链接</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </body>
</div>
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
    <center><h3 style="color: blue">URL编码/解码</h3></center>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <form class="form-horizontal" role="form" action="url" method="post">
                    <div class="form-group">
                        <label for="verifySign">转换内容:</label>
                        <textarea class="form-control" rows="15" id="verifySign" name="verifySign" autocomplete="off" placeholder="需要进行转换内容粘贴此处">${(res)!''}</textarea>
                        <div class="form-group">
                            <div class="col-sm-offset-8 col-sm-10" style="padding: 20px 0px 0px 0px">
                                <button type="submit" class="btn btn-primary" name="submit" value="encode">UrlEncode编码</button>
                                <button type="submit" class="btn btn-primary" name="submit" value="decode">UrlEncode解码</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </body>
</div>
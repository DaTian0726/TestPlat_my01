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
        <div class="col-md-12">
            <div class="item1 update_pic">
                <div class="alert alert-dismissable alert-warning">
                    <center>
                        <strong>说明：聚合交易CSV文件自动化处理系统，请使用本系统模板文件，请勿修改文件名及格式。</strong>
                    </center>
                </div>
                <form class="form-inline" action="upload" method="post" enctype="multipart/form-data">
                    <div class="container">
                        <div class="row">
                            <div class="form-group">
                                <div class="col-md-3 column control-label" style="padding: 5px 0px 0px 0px">选择文件：
                                </div>
                                <div class="col-md-9 column">
                                    <div class="input-group">
                                        <input id='location' class="form-control" onclick="$('#file').click();">
                                        <label class="input-group-btn">
                                            <input type="button" id="i-check" value="浏览文件" class="btn btn-primary"
                                                   onclick="$('#file').click();">
                                        </label>
                                    </div>
                                </div>
                                <input type="file" name="file" id='file'
                                       onchange="$('#location').val($('#file').val());" style="display: none">
                                <#--                                <input type="file" name="file"/>-->
                                <input type="submit" value="上传"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix" style="padding: 30px 0px 0px 0px;">
        <div class="col-md-4 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        自动化执行结果：
                    </th>
                </tr>
                </thead>
                <tbody>
                <#if list??>
                    <#list list as list>
                        <tr>
                            <td>
                                ${(list)}
                            </td>
                        </tr>
                    </#list>
                </#if>

                </tbody>
            </table>
        </div>
        <div class="col-md-8 column">
            <h4>
                聚合交易自动化文件说明，及其模板下载！
            </h4>
            <HR align=center width=100% color=#987cb9 SIZE=1>
                <div class="form-group">
                    <h5>
                        主扫说明：
                    </h5>
                    <p>
                        版本号,设备类型(08),支付类型,是否支持信用卡,APPID,AppKey,备注（类似支付宝ISV-新版本）,API地址
                    </p>
                    <div class="col-sm-8">
                        <a>主扫文件模板</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
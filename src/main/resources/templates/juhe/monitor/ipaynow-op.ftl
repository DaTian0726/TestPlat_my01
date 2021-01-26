<html>
<head>
    <meta charset="utf-8">
    <title>现在支付-测试平台</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <meta charset="utf-8">
    <link rel="icon"
          href="https://static.jianshukeji.com/highcharts/images/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <link
            href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
            rel="stylesheet">
    <script type="text/javascript"
            src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://img.hcharts.cn/highcharts/highcharts.js"></script>
    <script src="https://img.hcharts.cn/highcharts/highcharts-more.js"></script>
    <script src="https://img.hcharts.cn/highcharts/modules/exporting.js"></script>
    <script
            src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
    <script src="https://img.hcharts.cn/highcharts/themes/grid-light.js"></script>
</head>
<body>
<#include "../../common/top.ftl">
<div class="container" id="content">
    <div class="row">
        <#include "menu.ftl">
        <div class="col-md-9" style="padding: 0px 0px 0px 0px;">
            <h1>现在支付运营后台监控</h1>
            <hr size="1">
            <h2>监控日期：2020-12-29 18:00:29</h2>
            <p style="color:red;font-size:16px;">说明：失败率10%左右属正常，无需关注</p>
            <table><tbody><tr><td>
                        <h2>监控概要</h2>
                        <table width="60%" cellspacing="2" cellpadding="5" border="0" class="details" align="left">
                            <tbody><tr><th>总接口数</th><th>成功接口数</th><th>失败接口数</th><th>测试通过率</th></tr>
                            <tr align="center"><td>37</td><td>35</td><td>2</td><td>94.59%</td></tr>
                            </tbody></table>
                    </td></tr>

                <tr><td>
                        <h2>监控详情</h2>
                        <table width="95%" cellspacing="2" cellpadding="5" border="0" class="details" align="left">
                            <tbody><tr valign="top">
                                <th>被测接口</th><th>加载时间(ms)</th><th>时间</th><th>测试结果</th>
                            </tr>
                            <tr valign="top" class="">
                            </tr><tr><td>银联扫码应用配置</td><td>50</td><td>2020-12-29 18：00：18</td><td class="Failure">异常</td></tr>
                            <tr><td>银联扫码应用配置</td><td>60</td><td>2020-12-29 18：00：18</td><td class="Failure">异常</td></tr>
                            <tr><td>login</td><td>3228</td><td>2020-12-29 18：00：14</td><td class="Pass">正常</td></tr>
                            <tr><td>商户批量签约</td><td>100</td><td>2020-12-29 18：00：19</td><td class="Pass">正常</td></tr>
                            <tr><td>批量签约民生子商户</td><td>83</td><td>2020-12-29 18：00：19</td><td class="Pass">正常</td></tr>
                            <tr><td>退款</td><td>91</td><td>2020-12-29 18：00：18</td><td class="Pass">正常</td></tr>
                            <tr><td>微信进件</td><td>120</td><td>2020-12-29 18：00：18</td><td class="Pass">正常</td></tr>
                            <tr><td>手续费账户月账单</td><td>74</td><td>2020-12-29 18：00：22</td><td class="Pass">正常</td></tr>
                            <tr><td>日账单</td><td>117</td><td>2020-12-29 18：00：22</td><td class="Pass">正常</td></tr>
                            <tr><td>月账单</td><td>112</td><td>2020-12-29 18：00：23</td><td class="Pass">正常</td></tr>
                            <tr><td>服务商分润日账单</td><td>76</td><td>2020-12-29 18：00：22</td><td class="Pass">正常</td></tr>
                            <tr><td>服务商分润汇总账单</td><td>72</td><td>2020-12-29 18：00：22</td><td class="Pass">正常</td></tr>
                            <tr><td>卡认证及白名单采集</td><td>110</td><td>2020-12-29 18：00：20</td><td class="Pass">正常</td></tr>
                            <tr><td>虚拟账户余额详情</td><td>79</td><td>2020-12-29 18：00：20</td><td class="Pass">正常</td></tr>
                            <tr><td>资金审核</td><td>68</td><td>2020-12-29 18：00：21</td><td class="Pass">正常</td></tr>
                            <tr><td>手机号认证</td><td>70</td><td>2020-12-29 18：00：20</td><td class="Pass">正常</td></tr>
                            <tr><td>代理商关联商户列表</td><td>83</td><td>2020-12-29 18：00：24</td><td class="Pass">正常</td></tr>
                            <tr><td>代理商关联服务商列表</td><td>82</td><td>2020-12-29 18：00：24</td><td class="Pass">正常</td></tr>
                            <tr><td>商户服务商配置</td><td>85</td><td>2020-12-29 18：00：23</td><td class="Pass">正常</td></tr>
                            <tr><td>支付参数列表</td><td>83</td><td>2020-12-29 18：00：24</td><td class="Pass">正常</td></tr>
                            <tr><td>服务商列表</td><td>90</td><td>2020-12-29 18：00：23</td><td class="Pass">正常</td></tr>
                            <tr><td>民生直清机构商</td><td>71</td><td>2020-12-29 18：00：19</td><td class="Pass">正常</td></tr>
                            <tr><td>民生非直清机构商</td><td>76</td><td>2020-12-29 18：00：20</td><td class="Pass">正常</td></tr>
                            <tr><td>机构分润配置</td><td>79</td><td>2020-12-29 18：00：24</td><td class="Pass">正常</td></tr>
                            <tr><td>商户批量代付审核</td><td>70</td><td>2020-12-29 18：00：26</td><td class="Pass">正常</td></tr>
                            <tr><td>批量代付审核</td><td>74</td><td>2020-12-29 18：00：25</td><td class="Pass">正常</td></tr>
                            <tr><td>商户批量代付查询</td><td>75</td><td>2020-12-29 18：00：26</td><td class="Pass">正常</td></tr>
                            <tr><td>批量代付查询</td><td>75</td><td>2020-12-29 18：00：26</td><td class="Pass">正常</td></tr>
                            <tr><td>批量代付文件上传</td><td>77</td><td>2020-12-29 18：00：25</td><td class="Pass">正常</td></tr>
                            <tr><td>代付退票审批</td><td>80</td><td>2020-12-29 18：00：26</td><td class="Pass">正常</td></tr>
                            <tr><td>代付退票查询</td><td>114</td><td>2020-12-29 18：00：26</td><td class="Pass">正常</td></tr>
                            <tr><td>车场管理</td><td>85</td><td>2020-12-29 18：00：24</td><td class="Pass">正常</td></tr>
                            <tr><td>订单管理</td><td>81</td><td>2020-12-29 18：00：25</td><td class="Pass">正常</td></tr>
                            <tr><td>民生内部户余额管理</td><td>56</td><td>2020-12-29 18：00：21</td><td class="Pass">正常</td></tr>
                            <tr><td>民生内部户入账管理</td><td>57</td><td>2020-12-29 18：00：21</td><td class="Pass">正常</td></tr>
                            <tr><td>民生内部户出账管理</td><td>55</td><td>2020-12-29 18：00：21</td><td class="Pass">正常</td></tr>
                            <tr><td>民生内部户渠道结算退票</td><td>64</td><td>2020-12-29 18：00：22</td><td class="Pass">正常</td></tr>
                            </tbody></table></td></tr>
                </tbody></table>
        </div>
        <#include "../../common/msg.ftl">
    </div>
</div>
</body>
</html>

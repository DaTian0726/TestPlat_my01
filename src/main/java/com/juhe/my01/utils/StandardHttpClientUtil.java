package com.juhe.my01.utils;

import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * http工具类
 */
public class StandardHttpClientUtil {

    private static final Logger LOGGER              = LogManager.getLogger(StandardHttpClientUtil.class);

    private static final int    SO_TIME_OUT         = 20000;

    private static final int    CONNECTION_TIME_OUT = 10000;

    public static String sendHttpsPost(String url, String reportContent, String charset) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse response = null;
        try {
            closeableHttpClient = createSSLClientDefault();

            // 请求参数设置
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECTION_TIME_OUT).setSocketTimeout(SO_TIME_OUT).build();
            httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);
            httpPost.setConfig(requestConfig);

            // 发送请求
            httpPost.setEntity(new StringEntity(reportContent, charset));
            response = closeableHttpClient.execute(httpPost);

            // 处理响应
            StatusLine statusLine = response.getStatusLine();
            String responseContent = EntityUtils.toString(response.getEntity(), charset);

            if (200 == statusLine.getStatusCode()) {
                // LOGGER.info("200 OK,apacheHttpsClient响应内容为：" + responseContent);
            } else {
                LOGGER.info("apacheHttpsClient请求失败,响应内容为：" + responseContent);
            }
            long end = System.currentTimeMillis();
            LOGGER.info("apacheHttpsClient请求耗时:" + (end - start) + "毫秒");
            return responseContent;
        } catch (Exception ex) {
            LOGGER.error("apacheHttpsClient请求异常----->", ex);
        } finally {
            try {
                if (response != null) response.close();
                if (closeableHttpClient != null) closeableHttpClient.close();
            } catch (Exception ex) {
                LOGGER.error("apacheHttpsClient调用--关闭流失败", ex);
            }
        }
        return null;
    }

    public static String sendHttpsPost(String url, String reportContent, String charset, String signature) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse response = null;
        try {
            closeableHttpClient = createSSLClientDefault();

            // 请求参数设置
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECTION_TIME_OUT).setSocketTimeout(SO_TIME_OUT).build();
            httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("signature", signature);

            // 发送请求
            httpPost.setEntity(new StringEntity(reportContent, charset));
            response = closeableHttpClient.execute(httpPost);
            // 处理响应
            StatusLine statusLine = response.getStatusLine();
            String responseContent = EntityUtils.toString(response.getEntity(), charset);

            if (200 == statusLine.getStatusCode()) {
                // LOGGER.info("200 OK,apacheHttpsClient响应内容为：" + responseContent);
            } else {
                LOGGER.info("apacheHttpsClient请求失败,响应内容为：" + responseContent);
            }
            long end = System.currentTimeMillis();
            LOGGER.info("apacheHttpsClient请求耗时:" + (end - start) + "毫秒");
            return responseContent;
        } catch (Exception ex) {
            LOGGER.error("apacheHttpsClient请求异常----->", ex);
        } finally {
            try {
                if (response != null) response.close();
                if (closeableHttpClient != null) closeableHttpClient.close();
            } catch (Exception ex) {
                LOGGER.error("apacheHttpsClient调用--关闭流失败", ex);
            }
        }
        return null;
    }

    public static Map<String, String> sendHttpsPostBackMap(String url, String reportContent, String charset, String signature) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse response = null;
        Map<String, String> backMap = new HashMap<>();
        try {
            closeableHttpClient = createSSLClientDefault();

            // 请求参数设置
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECTION_TIME_OUT).setSocketTimeout(SO_TIME_OUT).build();
            httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("signature", signature);

            // 发送请求
            httpPost.setEntity(new StringEntity(reportContent, charset));
            response = closeableHttpClient.execute(httpPost);
            String backSignature = response.getLastHeader("signature").getValue();
            // 处理响应
            StatusLine statusLine = response.getStatusLine();
            String responseContent = EntityUtils.toString(response.getEntity(), charset);

            if (200 == statusLine.getStatusCode()) {
                // LOGGER.info("200 OK,apacheHttpsClient响应内容为：" + responseContent);
            } else {
                LOGGER.info("apacheHttpsClient请求失败,响应内容为：" + responseContent);
            }
            long end = System.currentTimeMillis();
            LOGGER.info("apacheHttpsClient请求耗时:" + (end - start) + "毫秒");
            backMap.put("responseData", responseContent);
            backMap.put("signature", backSignature);
            return backMap;
        } catch (Exception ex) {
            LOGGER.error("apacheHttpsClient请求异常----->", ex);
        } finally {
            try {
                if (response != null) response.close();
                if (closeableHttpClient != null) closeableHttpClient.close();
            } catch (Exception ex) {
                LOGGER.error("apacheHttpsClient调用--关闭流失败", ex);
            }
        }
        return null;
    }

    public static String sendHttpsPostSupport302(String url, String reportContent, String charset) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse response = null;
        try {
            closeableHttpClient = createSSLClientDefault();

            // 请求参数设置
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECTION_TIME_OUT).setSocketTimeout(SO_TIME_OUT).build();
            httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);
            httpPost.setConfig(requestConfig);

            // 发送请求
            httpPost.setEntity(new StringEntity(reportContent, charset));
            response = closeableHttpClient.execute(httpPost);

            // 处理响应
            StatusLine statusLine = response.getStatusLine();
            String responseContent = EntityUtils.toString(response.getEntity(), charset);

            if (200 == statusLine.getStatusCode()) {
                LOGGER.info("200 OK,apacheHttpsClient响应内容为：" + responseContent);
            } else if (302 == statusLine.getStatusCode()) {
                return response.getFirstHeader("Location").getValue();
            } else {
                LOGGER.info("apacheHttpsClient请求失败,响应内容为：" + responseContent);
            }
            long end = System.currentTimeMillis();
            LOGGER.info("apacheHttpsClient请求耗时:" + (end - start) + "毫秒");
            return responseContent;
        } catch (Exception ex) {
            LOGGER.error("apacheHttpsClient请求异常----->", ex);
        } finally {
            try {
                if (response != null) response.close();
                if (closeableHttpClient != null) closeableHttpClient.close();
            } catch (Exception ex) {
                LOGGER.error("apacheHttpsClient调用--关闭流失败", ex);
            }
        }

        return null;
    }

    private static CloseableHttpClient createSSLClientDefault() throws Exception {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (Exception ex) {
            LOGGER.error("apacheHttpsClient创建CloseableHttpClient失败", ex);
            throw ex;
        }
    }

    /**
     * 重写验证方法，取消检测ssl
     */
    private static TrustManager truseAllManager = new X509TrustManager() {

        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // TODO Auto-generated method stub

        }

        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // TODO Auto-generated method stub

        }

        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }

    };

    public static String sendHttpsPost2DatarCenter(String url, String reportContent, String charset) {
        // 记录开始时间
        long start = System.currentTimeMillis();
        CloseableHttpClient closeableHttpClient = null;
        CloseableHttpResponse response = null;
        try {
            closeableHttpClient = createSSLClientDefault();

            // 请求参数设置
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECTION_TIME_OUT).setSocketTimeout(SO_TIME_OUT).build();
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);
            httpPost.setConfig(requestConfig);

            // 发送请求
            httpPost.setEntity(new StringEntity(reportContent, charset));
            response = closeableHttpClient.execute(httpPost);

            // 处理响应
            StatusLine statusLine = response.getStatusLine();
            String responseContent = EntityUtils.toString(response.getEntity(), charset);

            if (200 == statusLine.getStatusCode()) {
                // LOGGER.info("200 OK,apacheHttpsClient响应内容为：" + responseContent);
            } else {
                LOGGER.info("apacheHttpsClient请求失败,响应内容为：" + responseContent);
            }
            long end = System.currentTimeMillis();
            LOGGER.info("apacheHttpsClient请求耗时:" + (end - start) + "毫秒");
            return responseContent;
        } catch (Exception ex) {
            LOGGER.error("apacheHttpsClient请求异常----->", ex);
        } finally {
            try {
                if (response != null) response.close();
                if (closeableHttpClient != null) closeableHttpClient.close();
            } catch (Exception ex) {
                LOGGER.error("apacheHttpsClient调用--关闭流失败", ex);
            }
        }
        return null;
    }

}

package com.juhe.my01.web.controller;

import com.juhe.my01.web.model.dudect.DeductModel;
import com.juhe.my01.web.model.dudect.DeductModelQuery;
import com.juhe.my01.web.model.dudect.SignModel;
import com.juhe.my01.web.model.dudect.SignModelQuery;
import com.juhe.my01.web.service.deduct.DeductService;
import com.juhe.my01.web.service.deduct.SignServiceimp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * ClassName: DeductController
 * Description:
 * date: 2020/9/8 15:11
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@RequestMapping
@RestController
public class DeductController {

    private static String privateKeyTest = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDZbPdvg/Aew802OTfxt44cTq/enh8uBqECyjU3TGX5mzybCfuPe0QOTjBA1BWLsPSE1VXhBOzoPkybVLMF09R8HjFcRESZ7Qm6XoMyu1NI+O3PAuQjET+wgmbV6yMEczGn/ywsu7/ZqhuxCxitnx/dk5dX802Ldn4DFS3oBr5ocxdp0LZri1/aIS9Axvq2GL71BnJznUynCqnikYQw5cJ0KEfsGLY0Dx6MpVtAGLyoCSLfHzBSC6UYy1ywblpHvlqEyb+ngvo6RwqbXkTqaaUgcY3YGoTKy/qhIgUvx/jrpN8zha0VjdaaWxd9EkIb5ZnxDhgwOEoWm2r1qW/wmBKdAgMBAAECggEAQf2LoAIIeB3vg9yb+TY/4KGVSVjul7aVWdZrjmwWq0qNe3TtMCA2iKz8gkCchXhgzow9c31eNiLqd16es08Wt9EmJB3oQFusTy9uXJB0d7pt2x3Chk4u6XC6q4ShbTFVSertymn1kafKndKDW/bm4gZwsdX7nC+LkX31H+4kDmkI5J8/NDpwo7xgbSUWMhPUMnk9sAj1seryN41KCaqhbQ9E8aOBppjc0i5YlZungU/C0j/5eHvh+8YykW48e3GM3OA+h4ng5Ett7rWU4zpmHCpGo0vQ3QIWEx3mlnwt7VgwG6RtZ+svCbkqXJNt7Dz8Wn5GnDCJXf3GvwsdNISZ4QKBgQDsTQdtyFQFoFSXpfsD+x74zZf7AbOiy8maZKEC+pUfs3NyYF+AINaBgdCV+//uQUAbbBc99YwGc6Zp/7PXrm6tjP5j1ZJ/QX3wFKP43dzp/VpGFLyzJjGpcwlqYM9JCpLSloNBxQBLZJlehtNb9daXC8r+wpzPOziYOg9oZZMjSQKBgQDrjR106uhRj9lHszsED81u0DfA53khZVr6r/jZkPaysKKv7XQbkvn4FctaRvApMBwG5VIOfVNhBvsXA8Gg4u2TUzxAFnRrZY9Tnc9le52I+ZEf3wgM3FteQOZTKxYGkNLdKc1KZrh3XYxwY/di1sEGBE9F7Vd0PCRUQp/Heu8gtQKBgHwC6PUqfz38qKh1iUjLj7OPYkVu3TGAtar7SKzhiUV7zgimnzgFA84vrKIqAGSvhc9eaMwxg20XYKycb2uvtZILPq5yNVHnswo+Kte+x+Nc/PVuiKGUV9fP8Y8Mg3yXufoe13+6va7TetHq/B105Uub+sq8o8L2F3t8bP2i4RdRAoGADxlfnwQD2l6XNgJmMQ92Qrk0Kbhsylg96b3n/MJPHgs2koJtI+ta/K0g+Ot9L5a25TZD+UvNUXXqGIKUIeUKB5yZSx5lXhEHi/uctMukwIgG5n0cff6OGM+eNAyZ/9e+vJCWaUOGZZhojTfLPtm3S9Rw5HGfXoMQbRpMNbRKqdUCgYB85O6LayLHNqq3Vh0mGh0bEfSyRq9g87huk1WXG58Tg+LxD9v1oCpvVTQDcnegL/qnTk/I3axVItFTlWRpQKuScTn+T2N9BBrS8KqS85+XptHUIFzChnTPNjKKKw431NcveD5WHyhLhk1AlGmfNZjFTy3rflFIX9jBpFI6yrL7aA==";
    private static String publicKeyTest = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAudtyg8SDCvVcD2sJClzwpZZ/MwcLANAMZuuHsyC4afEocnuviKYn/9uKHDzQ/Gj5oUfGy3SlXqwXaSHgjoPZsweS1tduY3ccyyThHeNvSR1RsLF8I8PjIURiQyYlUozwvMj78FZCsuUu0PqABLGiZKJ1I6IiB1q+36AjVEKBhypFn1Ib9Qp2vCRzo3mWb7Xf/+IDc8WSTb4Urbxq0Xoo/oha25GRniLmJ8grTsd72HY8MrpPbEvUbocPr5xEaxPBGpZlfeqUtND3pyDFugojkWMFlih3TvofNc5/OdGtzR3pX1MVIz5dQNTwef0SA0LX86gblzh8BTjdkqhewFjAfwIDAQAB";

    private static String privateKeyLine = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCN4iiCthH7fbYdbiBRiElI9sDKHYnlO7iCbIhBgoQAOvbrJWzLNuijsPS0gfiKg4JiSK7zxKOpJcDwuuUe4mxgFyZKcNOdfXKWWYO+6LuEQ57F798sJ5T0jVAws4pYSfqD1uYuFB1XbBqrvtEsPVQ8YIKZAE1x1DKfCrvYSboHJsDH8kJsfcJVMxkXGPc22pllVu6jPRP/ZGGCOpc6xyEqls24FJbTyKLpF4IS/kiLVOaaxCc6GrFM/Qn5ZHHednxZGu20dUCNfdOKKqgL0jf8T3yJ9fU508IIm1O9Qx1NftnnCsDj5G+VnYIQ/ead6J4oI0iqDGtuZc9Qtt1GV4E5AgMBAAECggEAGmUYZDi6365jUtZJ7OENwSUmeHNGU/7oNFs8ffNp2yEdDmHH+4YbgVhKLcqAEkSk3OPoqDDMwYrkeeRK+5Pj1Xx5AyA6PfI4fv/oInvpZpGt1+Tn/67dZyFi6ax88C/TCvPPnoLfcoQJ8iltgG1oXlMV+KC1x5dSU4QLrhEJKoskHqA6c9u3jaIAxluurSARGozod9jrohFNoWwSoA0r9JTaCAoa7p6PBXDS9jwKV5NUFOgMCeUqNXdJEt9R9SHz6PfUFN16Dmp8CfRXEAbGyWRzwDrcGkYFBcnVK82lv+2Nu4J6QjBFKY2zzuxDlZCvmh1PvZsCHwdJl0l1ZzLKgQKBgQDFH1uyHFiVTW0YB+Vusp1zm1eDbN4JPSmadj6ZtOn0VLT0I82kSNjgPhamjThslgKSSeZ9TX+twdu5PfZVYL1QNAzXAeGlrmKtydEDZFLXu3xg6mHWcpAS8RS4d4ZN3EC//WaIACFgiqAipH7O4lmtozyfZD7NAeK4c4lGNZL/+wKBgQC4QwmbUFoEhOKYEJ6ZISha+8LiCqrlPJUoFNn5PKEfXD+cgAhll9by9kLdY9yxNzfhPs4wmkVCJPev7lHKFoCKp9UJqiUY8ScFvf2Rv7tekeP3PdgPjW9fjtCfhYKoL6lSKc4Yii0RMDiOh18fwdoV627abeR4P/fSW8UtOZUZWwKBgQDCqwoyJh4xK+ptzfZ9ULV/osxVBSFtPFKmsNl3kBtvaGvforAF6s8K/SX/Sv2K9sYJVCPkYLGTlhv4n0Fy5XtwBkcb2kbOCR54hBL+54eMdyIIz87ZKgAwRJby6U7f+4CSWZx0+LP9lEk6jPqSMyTe/pLy0dvXN2KAR9EsXeITGwKBgGGXqAPp9/OCyl0OGGI0bKJby+lbCw6lGr8C5Dwcv53ThyGFsmzUkhVXFy0ZEi+OdntHf3/AhcQ1vjYhPJKTfntxzuTyh/mA6FEjQqUqbrv0+0/dIo2CNKXhB2AmH4Ci1cRdvfnDXYFID/x1eI1iZ/bKHol0QNjr0H9K+dEtOWoXAoGBAMBnwmLyH25m09GUGpmGSAJY17JP9lRAeCaSnQs7HfkjLOSRRgLbRBXRWbMygRpJi7B8ktNP9ZmtHsbuqOyFF3e+5bAOHXWB0LlgLMav5UlZcREmEgYoTUyVIkOCDDPOfn2bcW0IwUgVZhYlrHeAHoiggFrkWlkHRiQYFUAB9e/I";
    private static String publicKeyLine = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApyUwWTGCPQmX8q6OPvd+mCGn74hZ2NLtQFdwe5GVHlhCKblIBc7yrnI+CJlaLsL6hb27IMFiK8QN3MekGUda+MU9NZ2RNjhTo2V9vAkbb8GNIdwYaRi/AdIQBs8FADDHX43tNpN4O45X8aWRPQGSdkSCSN6TJRyw22omr3/1/7omOgs2BGA2fRwR4/sasf/44V8U+xa+Aj4KL8Nlejk7SOHg53/qsTMewzkEVxlPl1zfpFC2SED8UCRmxcUrBkkl4B6ZaqgHY00Gg7mMg3txld9F7fEv3nA5yTALs4KD4lavNx9ZvEYnruMDwIMyKXelL0I7ZkaW7FA1SutRxUoUXQIDAQAB";

    private static String appIdTest = "158106788169583";
    private static String appIdLine = "158158414466552";

    public SignModel InitModel(SignModel signModel,HttpServletRequest request){
        if(request.getParameter("submit").equals("test")){
            signModel.setUrl("https://dby.ipaynow.cn/deduct/deductapi");
        }else {
            signModel.setUrl("https://pay.ipaynow.cn/deduct/deductapi");
        }

        //判断默认情况下appID的值
        if (signModel.getAppId().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setAppId(appIdTest);
            } else{
                signModel.setAppId(appIdLine);
            }
        }
        //判断默认情况下privateKey的值
        if (signModel.getPrivateKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPrivateKey(privateKeyTest);
            } else {
                signModel.setPrivateKey(privateKeyLine);
            }
        }
        //判断默认情况下publicKey的值
        if (signModel.getPublicKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPublicKey(publicKeyTest);
            } else {
                signModel.setPublicKey(publicKeyLine);
            }
        }
        return signModel;
    }

    @GetMapping("/sign")
    public ModelAndView SignGet(Map map){
        map.put("signModel",new SignModel());
        return new ModelAndView("withhold/sign",map);
    }

    @PostMapping("/sign")
    public ModelAndView SignPost(SignModel signModel,
                                   HttpServletRequest request, HttpServletResponse response,Map map){
        signModel = InitModel(signModel,request);
        SignServiceimp signServiceimp = new SignServiceimp();
        Map result = signServiceimp.Sign(signModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        map.put("state","1");
        return new ModelAndView("common/result",map);
    }

    @GetMapping("/signquery")
    public ModelAndView SignQueryGet(Map map){
        map.put("signModel",new SignModelQuery());
        return new ModelAndView("withhold/querySign",map);
    }

    @PostMapping("/signquery")
    public ModelAndView SignQueryPost(SignModelQuery signModel,
                                      HttpServletRequest request, HttpServletResponse response, Map map){
        if(request.getParameter("submit").equals("test")){
            signModel.setUrl("https://dby.ipaynow.cn/deduct/deductapi");
        }else {
            signModel.setUrl("https://pay.ipaynow.cn/deduct/deductapi");
        }

        //判断默认情况下appID的值
        if (signModel.getAppId().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setAppId(appIdTest);
            } else{
                signModel.setAppId(appIdLine);
            }
        }
        //判断默认情况下privateKey的值
        if (signModel.getPrivateKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPrivateKey(privateKeyTest);
            } else {
                signModel.setPrivateKey(privateKeyLine);
            }
        }
        //判断默认情况下publicKey的值
        if (signModel.getPublicKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPublicKey(publicKeyTest);
            } else {
                signModel.setPublicKey(publicKeyLine);
            }
        }
        SignServiceimp signServiceimp = new SignServiceimp();
        Map result = signServiceimp.SignQuery(signModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        return new ModelAndView("common/result",map);
    }

    @GetMapping("/unbundle")
    public ModelAndView UnbundleGet(Map map){
        map.put("signModel",new SignModelQuery());
        return new ModelAndView("withhold/unbundle",map);
    }

    @PostMapping("/unbundle")
    public ModelAndView UnbundlePost(SignModelQuery signModel,
                                      HttpServletRequest request, HttpServletResponse response, Map map){
        if(request.getParameter("submit").equals("test")){
            signModel.setUrl("https://dby.ipaynow.cn/deduct/deductapi");
        }else {
            signModel.setUrl("https://pay.ipaynow.cn/deduct/deductapi");
        }

        //判断默认情况下appID的值
        if (signModel.getAppId().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setAppId(appIdTest);
            } else{
                signModel.setAppId(appIdLine);
            }
        }
        //判断默认情况下privateKey的值
        if (signModel.getPrivateKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPrivateKey(privateKeyTest);
            } else {
                signModel.setPrivateKey(privateKeyLine);
            }
        }
        //判断默认情况下publicKey的值
        if (signModel.getPublicKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPublicKey(publicKeyTest);
            } else {
                signModel.setPublicKey(publicKeyLine);
            }
        }
        SignServiceimp signServiceimp = new SignServiceimp();
        Map result = signServiceimp.Unbundle(signModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        return new ModelAndView("common/result",map);
    }

    @GetMapping("/deduct")
    public ModelAndView DeductGet(Map map){
        map.put("signModel",new DeductModel());
        return new ModelAndView("withhold/deduct",map);
    }

    @PostMapping("/deduct")
    public ModelAndView DeductPost(DeductModel signModel,
                                   HttpServletRequest request, HttpServletResponse response, Map map){
        if(request.getParameter("submit").equals("test")){
            signModel.setUrl("https://dby.ipaynow.cn/deduct/deductapi");
        }else {
            signModel.setUrl("https://pay.ipaynow.cn/deduct/deductapi");
        }

        //判断默认情况下appID的值
        if (signModel.getAppId().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setAppId(appIdTest);
            } else{
                signModel.setAppId(appIdLine);
            }
        }
        //判断默认情况下privateKey的值
        if (signModel.getPrivateKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPrivateKey(privateKeyTest);
            } else {
                signModel.setPrivateKey(privateKeyLine);
            }
        }
        //判断默认情况下publicKey的值
        if (signModel.getPublicKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPublicKey(publicKeyTest);
            } else {
                signModel.setPublicKey(publicKeyLine);
            }
        }
        DeductService deductService = new DeductService();
        Map result = deductService.Deduct(signModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        return new ModelAndView("common/result",map);
    }

    @GetMapping("/deductquery")
    public ModelAndView DeductQueryGet(Map map){
        map.put("signModel",new DeductModelQuery());
        return new ModelAndView("withhold/deductQuery",map);
    }

    @PostMapping("/deductquery")
    public ModelAndView DeductQueryPost(DeductModelQuery signModel,
                                        HttpServletRequest request, HttpServletResponse response, Map map){
        if(request.getParameter("submit").equals("test")){
            signModel.setUrl("https://dby.ipaynow.cn/deduct/deductapi");
        }else {
            signModel.setUrl("https://pay.ipaynow.cn/deduct/deductapi");
        }

        //判断默认情况下appID的值
        if (signModel.getAppId().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setAppId(appIdTest);
            } else{
                signModel.setAppId(appIdLine);
            }
        }
        //判断默认情况下privateKey的值
        if (signModel.getPrivateKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPrivateKey(privateKeyTest);
            } else {
                signModel.setPrivateKey(privateKeyLine);
            }
        }
        //判断默认情况下publicKey的值
        if (signModel.getPublicKey().equals("") || signModel.getAppId() == null) {
            if (signModel.getUrl().equals("https://dby.ipaynow.cn/deduct/deductapi")) {
                signModel.setPublicKey(publicKeyTest);
            } else {
                signModel.setPublicKey(publicKeyLine);
            }
        }
        DeductService deductService = new DeductService();
        Map result = deductService.DeductQuery(signModel);
        map.put("request",result.get("request"));
        map.put("response",result.get("response"));
        map.put("img",result.get("img"));
        return new ModelAndView("common/result",map);
    }
}

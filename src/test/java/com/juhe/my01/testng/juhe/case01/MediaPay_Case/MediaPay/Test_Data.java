package com.juhe.my01.testng.juhe.case01.MediaPay_Case.MediaPay;

import org.testng.annotations.DataProvider;

public class Test_Data {

    @DataProvider(name = "mediapay_zfb")
    public Object[][] media_zfb(){
        return new Object[][]{
//                {"canal","appId","appKey"},
//                {"支付宝-ISV","151142883517952","gh4HwH7UarOCXRtP96lPD9KQd8xiEpT9"},
//                {"易宝-支付宝","154113053321091","d2ZpGmAP8BIZIpuHSWNnlNAOuRZAA722"},
                {"随行付-支付宝","154113053321091","d2ZpGmAP8BIZIpuHSWNnlNAOuRZAA722"},
//                {"亿联-支付宝","154113053321091","d2ZpGmAP8BIZIpuHSWNnlNAOuRZAA722"},
//                {"联动优势-支付宝","156146374859918","AHxAHVuHQhldpUmR9VbMzrX0XXcXT6uD"},
                {"河北银商-支付宝","156886027164964","9ME2X8J0YxCXcnPf6vFaWdmdzNLyxVfs"},
                {"汇付天下-微信","156817458081430","1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh"},
        };
    }
    @DataProvider(name = "mediapay_wx")
    public Object[][] media_wx(){
        return new Object[][]{
//                {"canal","appId","appKey","mhtSubAppId","consumerId"},
//                {"微信-分账","151142883517952","gh4HwH7UarOCXRtP96lPD9KQd8xiEpT9","wx73aa38c2253a7180","oSuWV1QMaiAWbvOdnxdVTSsWhqik"},
//                {"易宝-微信","154113053321091","d2ZpGmAP8BIZIpuHSWNnlNAOuRZAA722","wx99df53752bdf6df2","oxBhM0wVqGvbw0ZnCYIxr9u4V3tQ"},
//                {"随行付-微信","154113053321091","d2ZpGmAP8BIZIpuHSWNnlNAOuRZAA722","",""},
//                {"亿联-微信","154113053321091","d2ZpGmAP8BIZIpuHSWNnlNAOuRZAA722","wxf0863664cbc3aa31","oNNKI04mms-MFiswIYhoAT5UxNU8"},
//                {"信钛-微信","155921496704086","L78ukqB8FvxJ78hw3F5Rat0DH3oPcGdN","wxf0863664cbc3aa31","oNNKI04mms-MFiswIYhoAT5UxNU8"},
//                {"联动优势-微信","156146374859918","AHxAHVuHQhldpUmR9VbMzrX0XXcXT6uD","wxf0863664cbc3aa31","oNNKI04mms-MFiswIYhoAT5UxNU8"},
                {"河北银商-微信","156886027164964","9ME2X8J0YxCXcnPf6vFaWdmdzNLyxVfs","wx7d1e1ed7dbbbfbd7","oxBhM0wVqGvbw0ZnCYIxr9u4V3tQ"},
                {"汇付天下-微信","156817458081430","1FBy7IO7Y8AInewku1HTNnpOQK1M0tNh","wx99df53752bdf6df2","oxBhM0wVqGvbw0ZnCYIxr9u4V3tQ"},

        };
    }
}

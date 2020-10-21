package com.juhe.my01.testng.juhe.case01.ActiceScan_Case;

import org.testng.annotations.DataProvider;

public class TestCase_Data {

    @DataProvider(name = "AllCanal")
    private Object[][] ActiveCanal() {
        return new Object[][]{
//                {"canal","appId","appKey","payChannelType"},
//           注： 主扫微信关停--
                {"微信-分账", "151142878420675", "qiMP78S5HHvHEmFUcrr9kOG4wngkrXos", "13"},
                {"支付宝-ISV","151142878420675","qiMP78S5HHvHEmFUcrr9kOG4wngkrXos","12"},
                {"亿联-微信","154831452366234","joS8CUdGsjDfJbLb7K8mZfjLwJOGQzcE","13"},
                {"亿联-支付宝","154831452366234","joS8CUdGsjDfJbLb7K8mZfjLwJOGQzcE","12"},
                {"易宝-支付宝","154113042260144","tgq0x5zfhC1PZkTxUaOJynVS5Eb5281c","12"},
                {"易宝-微信","154113042260144","tgq0x5zfhC1PZkTxUaOJynVS5Eb5281c","13"},
                {"随行付-支付宝","154113042260144","tgq0x5zfhC1PZkTxUaOJynVS5Eb5281c","12"},
                {"随行付-微信","154113042260144","tgq0x5zfhC1PZkTxUaOJynVS5Eb5281c","13"},
                {"随行付-银联","154113042260144","tgq0x5zfhC1PZkTxUaOJynVS5Eb5281c","27"},
                {"联动优势-微信","156146371585758","HtW4hrNsz3VEaA6kcggSyrffe4zguokL","13"},
                {"联动优势-支付宝","156146371585758","HtW4hrNsz3VEaA6kcggSyrffe4zguokL","12"},
                {"联动优势-银联","156146371585758","HtW4hrNsz3VEaA6kcggSyrffe4zguokL","27"},
                {"汇付天下-微信","156817447672951","hr4wPSqDJHymrHaInYBn4iX9Ut4vwXwz","13"},
                {"汇付天下-支付宝","156817447672951","hr4wPSqDJHymrHaInYBn4iX9Ut4vwXwz","12"},
        };
    }
}

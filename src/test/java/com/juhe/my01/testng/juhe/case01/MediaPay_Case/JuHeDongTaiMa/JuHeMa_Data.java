package com.juhe.my01.testng.juhe.case01.MediaPay_Case.JuHeDongTaiMa;

import org.testng.annotations.DataProvider;

public class JuHeMa_Data {

    @DataProvider(name = "juhema")
    public Object[][] Juhema() {
        return new Object[][]{
                /**
                 * mhtLimitPay
                 * 0不限制信用卡  1禁用信用卡  默认为0，不限制信用卡
                 * outputType
                 * //0 返回二维码串1 返回支付链接 默认为1，返回支付链接
                */
//                {"canal","appId","appKey","mhtLimitPay","outputType"},
                {"联动优势-可信用-链接", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "", ""},
                {"联动优势-可信用-二维码", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "", "0"},
                {"联动优势-可信用-链接", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "", "1"},
                {"联动优势-可信用-链接", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "0", ""},
                {"联动优势-可信用-二维码", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "0", "0"},
                {"联动优势-可信用-链接", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "0", "1"},
                {"联动优势-禁信用-链接", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "1", ""},
                {"联动优势-禁信用-二维码", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "1", "0"},
                {"联动优势-禁信用-链接", "156146415517478", "OVX7kmRY0hHHhyYG2nOXYxaAaPmA46Vr", "1", "1"},

                {"河北银商-可信用-链接",  "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "", ""},
                {"河北银商-可信用-二维码", "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "", "0"},
                {"河北银商-可信用-链接",  "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "", "1"},
                {"河北银商-可信用-链接",  "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "0", ""},
                {"河北银商-可信用-二维码", "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "0", "0"},
                {"河北银商-可信用-链接",  "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "0", "1"},
                {"河北银商-禁信用-链接",  "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "1", ""},
                {"河北银商-禁信用-二维码", "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "1", "0"},
                {"河北银商-禁信用-链接",  "156886024666838", "3VzjWmoiu9jKHAhSYMgAk7ZkSRS2vNJx", "1", "1"},

                {"汇付天下-可信用-链接",  "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "", ""},
                {"汇付天下-可信用-二维码", "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "", "0"},
                {"汇付天下-可信用-链接",  "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "", "1"},
                {"汇付天下-可信用-链接",  "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "0", ""},
                {"汇付天下-可信用-二维码", "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "0", "0"},
                {"汇付天下-可信用-链接",  "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "0", "1"},
                {"汇付天下-禁信用-链接",  "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "1", ""},
                {"汇付天下-禁信用-二维码", "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "1", "0"},
                {"汇付天下-禁信用-链接",  "156817453863276", "ODPntYi8vILc863o5ITOtbCjtyNoMWXo", "1", "1"},
        };
    }
}

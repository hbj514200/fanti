package com.qq.qzone.a1336892373.fantai;

import java.io.IOException;
import taobe.tec.jcc.JChineseConvertor;

public class tools {

    public static String tojianti(String st){
        try {
            JChineseConvertor jChineseConvertor = JChineseConvertor.getInstance();
            st = jChineseConvertor.s2t(st);
        } catch (IOException e) {
            st = "该死，程序内部出现了错误，我们会在将来修复这个BUG。";
        }
        return st;
    }

    public static String tofanti(String st){
        try {
            JChineseConvertor jChineseConvertor = JChineseConvertor.getInstance();
            st = jChineseConvertor.t2s(st);
        } catch (IOException e) {
            st = "该死，程序内部出现了错误，我们会在将来修复这个BUG。";
        }
        return st;
    }

}

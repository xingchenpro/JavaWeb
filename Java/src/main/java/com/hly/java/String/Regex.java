package com.hly.java.String;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/7/26
 */
public class Regex {

    public static void main(String[] args){
        String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
        String str1 = "hhh@";
        String str2 = "hhhhh";
        String str3 = "1144211@qq.com";
        if(str1.matches(regex)){
            System.out.println(str1+"是一个合格的字符串");
        }
        if(str2.matches(regex)){
            System.out.println(str2+"是一个合格的字符串");
        }
        if(str3.matches(regex)){
            System.out.println(str3+"是一个合格的字符串");
        }

    }
}

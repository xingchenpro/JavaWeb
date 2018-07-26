package com.hly.java.String;

import java.util.Date;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/7/26
 */
public class theClassOfString {

    /**
     * 字符串声明
     */

    public void decareString() {
        //字符数组赋值
        char chars1[] = {'h', 'l', 'y'};
        String s1 = new String(chars1);
        //offset开始的位置,count长度
        char x2[] = {'h', 'l', 'y'};
        String s2 = new String(chars1, 0, 1);
        //直接赋值
        String s3 = "hly";
    }

    /**
     * 字符串链接
     */

    public void connectString() {
        String s1 = new String("l");
        String s2 = new String("y");
        String s3 = s1 + s2;
        s1.concat(s2);
    }

    /**
     * 获取字符串信息
     */

    public void getStringInfo() {
        String str = "I am Hly";
        //获取长度
        int size = str.length();
        //字符串查找
        //返回首次出现的位置
        str.indexOf("Hly");
        //返回最后一次出现的位置
        str.lastIndexOf("Hly");
    }

    /**
     * 获取索引位置的字符串
     */

    public void getIndexChar() {
        String str = "I am Hly";
        str.charAt(2);
    }

    /**
     * 截取子串
     */
    public void getChildString() {
        String str = "I am hly";
        //从指定的位置开始截取到结尾
        str.substring(0);
        //开始位置到结束位置
        str.substring(0, 3);
    }

    /**
     * 去除空格
     */

    public void remoceblank() {
        String str = "I am hly";
        str.trim();
    }

    /**
     * 字符串替换
     */

    public void replaceString() {
        String str = "I am hly";
        //replace(old,new);
        str.replace("hly", "engineer");
    }

    /**
     * 判断字符串开头或者结尾,boolean类型
     */

    public void judgeStartOrEnd() {
        String str = "I am hly";
        str.startsWith("I");
        str.endsWith("y");
    }

    /**
     * 比价字符串是否相等
     */

    public void equalString() {
        String str = "I am hly";
        String str2 = "I am engineer";
        //区分大小写
        str.equals(str2);
        //不区分大小写
        str.equalsIgnoreCase(str2);
    }

    /**
     * 按字典顺序比较各个字符的Unicode
     */

    public void compareString() {
        String str = "abc";
        String str2 = "aac";
        //每一个字符一次比较，相同就往后推，遇到不同的，前面的一个字符减后面的一个字符，str的减str2的；
        str.compareTo(str2);
        System.out.println(str.compareTo(str2));
    }

    /**
     * 字符串大小写转换
     */

    public void toggleCase() {
        String str = "I am hly";
        //转化为小写
        str.toLowerCase();
        //转化为大写
        str.toUpperCase();
    }

    /**
     * 字符串分割
     */

    public void splitString() {
        String str = "I am hly";
        //根据给定的分割符进行分割
        str.split(" ");
        //限定分割的次数
        str.split(" ", 1);
    }

    /**
     *格式化字符串
     */

    public void formatString() {
        Date date = new Date();
        String form = String.format("%tF",date);
        //格式化十六进制
        String hexadecimal = String.format("%x",200);
    }


    public static void main(String[] args) {
        theClassOfString theClassOfString = new theClassOfString();
        theClassOfString.compareString();
    }


}

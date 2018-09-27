<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/17
  Time: 13:38
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>声明周期</title>
</head>
<body>
<%!
private int init;
private int service;
private int destroy;
%>
<%!
    public void jspInit(){
        init++;
        System.out.println("初始化"+init+"次");
    }
    public void jspDestroy(){
        destroy++;
        System.out.println("销毁了"+destroy+"次");
    }
%>
<%
    service++;
    System.out.println("响应了"+service+"次请求");
%>
<%
    out.println("初始化"+init+"次");
    out.println("销毁了"+destroy+"次");
    out.println("响应了"+service+"次请求");
%>
</body>
</html>

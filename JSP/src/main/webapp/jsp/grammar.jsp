<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/17
  Time: 15:01
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>语法</title>
</head>
<body>
<%
    out.println("IP" + request.getRemoteAddr());
%>

<%!
    int x = 3;
%>

<%=(new Date())%>

<%@include file="buildCycle.jsp" %>
<jsp:include page="buildCycle.jsp"/>

<%--判断语句--%>
<%
    if (x == 1)
        out.println("yes");
    else
        out.println("no x:"+x);
%>

<%
    if (x == 100) {
%>
<p style="color: green">正确</p>
<% } else {
%>
<p style="color: red">错误</p>
<%
    }
%>
<%--switch语句--%>

<%
    switch (new Date().getDate()) {
        case 0:
            out.println("1");
            break;
        case 1:
            out.println("2");
            break;
        default:
            out.println(0);
    }
%>

<%--循环语句--%>
<%
    for (int i=0;i<2;i++){
%>
<%
    out.println("i:"+i);
    }
%>

<%
    while(x>1){
%>
<%
    out.println("x:"+x);
    x--;
    }
%>


</body>
</html>

<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/17
  Time: 19:23
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交后</title>
</head>
<body>
<%=request.getParameter("user")%>
<%=request.getParameter("password")%>
<%=request.getParameter("check")%>

<%--读取表单所有参数名称--%>
<%
    Enumeration params = request.getParameterNames();
    while(params.hasMoreElements()){
        String paramName = (String)params.nextElement();
        out.print(paramName);
        String paramVal =request.getParameter(paramName);
        out.print(paramVal);
    }
%>
</body>
</html>

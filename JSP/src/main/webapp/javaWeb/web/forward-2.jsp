<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/11/25
  Time: 15:33
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%=request.getParameter("username")%>
<%=request.getParameter("password")%>--%>

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

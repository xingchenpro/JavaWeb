<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/18
  Time: 18:57
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<%
    String userId = (String) session.getAttribute("userId");
    Integer visitNum = (Integer) session.getAttribute("visitNum");
%>
<html>
<head>
    <title>session</title>
</head>
<body>
欢迎<%=userId%>第<%=visitNum%>次访问!
</body>
</html>

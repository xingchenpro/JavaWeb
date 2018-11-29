<%--
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

<jsp:forward page="forward-2.jsp">
    <jsp:param name="username" value="hly"/>
    <jsp:param name="password" value="123"/>
</jsp:forward>

</body>
</html>

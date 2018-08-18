<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/18
  Time: 14:58
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie user = new Cookie("user","hly");
    Cookie password = new Cookie("password","123");
        /*设置有效期*/
    user.setMaxAge(60*60);
    password.setMaxAge(60*60);

    response.addCookie(user);
    response.addCookie(password);
%>
<html>
<head>
    <title>coolie</title>
</head>
<body>
<%=request.getParameter("user")%>
<%=request.getParameter("password")%>


</body>
</html>

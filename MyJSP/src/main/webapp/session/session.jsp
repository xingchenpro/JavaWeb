
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
    Date createTime = new Date(session.getCreationTime());
    Date lastTime = new Date(session.getLastAccessedTime());
    String userId = request.getParameter("userId");
    Integer visitNum = 0;


    if(session.isNew()){
        session.setAttribute("visitNum",visitNum);
    }
    else{
        /*未解决报错*/
        visitNum = (Integer) session.getAttribute("visitNum");
        visitNum+=1;
        session.setAttribute("visitNum",visitNum);
    }
%>
<html>
<head>
    <title>session</title>
</head>
<body>
欢迎<%=userId%>第<%=visitNum%>次访问！

</body>
</html>

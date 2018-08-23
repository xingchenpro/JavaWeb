<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/18
  Time: 19:00
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Date createTime = new Date(session.getCreationTime());
    Date lastTime = new Date(session.getLastAccessedTime());
    Integer visitNum = 0;

    if(session.isNew()){
        session.setAttribute("visitNum",visitNum);
    }
    else{
        visitNum = (Integer) session.getAttribute("visitNum");
        /*词句需要放在一开始运行的网页，不然会出现空指针报错*/
        visitNum+=1;
        session.setAttribute("visitNum",visitNum);
    }
%>
<html>
<head>
    <title>mySession</title>
</head>
<body>
<form action="/MySession" method="get">
    <input type="text" placeholder="userId" name="userId">
    <input type="submit" value="提交">
</form>
</body>
</html>

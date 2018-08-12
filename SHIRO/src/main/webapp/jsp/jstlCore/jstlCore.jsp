<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/11
  Time: 20:22
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%String path= request.getContextPath();%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="<title>Title</title>要显示的数据对象（未使用转义字符）" escapeXml="true" default="默认值"></c:out><br/>
<c:out value="<title>Title</title>要显示的数据对象（使用转义字符）" escapeXml="false" default="默认值"></c:out><br/>

<c:set var="sum" scope="page" value="${3*2}"/>
<c:out value="${sum}"/>

<c:set var="salary" scope="session" value="${2000*2}"/>
<c:out value="${salary}"/>

<c:set var="salary" scope="session" value="${2000*2}"/>
<p>salary 变量值: <c:out value="${salary}"/></p>
<c:remove var="salary"/>
<p>删除 salary 变量后的值: <c:out value="${salary}"/></p>
</body>
</html>

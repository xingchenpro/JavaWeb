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

c:out实例:
<c:out value="<title>Title</title>要显示的数据对象（未使用转义字符）" escapeXml="true" default="默认值"></c:out><br/>
<c:out value="<title>Title</title>要显示的数据对象（使用转义字符）" escapeXml="false" default="默认值"></c:out><br/>

c:set实例:<br/>
<c:set var="sum" scope="page" value="${3*2}"/>
<c:out value="${sum}"/> <br/>

c:remove实例:<br/>
<c:remove var="sum"/>
<c:out value="${sum}"/>

c:catch实例:<br/>
<c:catch var="catchException">
    <% int x = 5/0;%>
</c:catch>
异常:${catchException}<br/>
异常:${catchException.message}<br/>


c:if实例:<br/>
<c:if test="${2+1==3}" var="myif">
    true
</c:if><br/>
<c:out value="${myif}"/><br/>

c:choose、when、otherwise 实例:<br/>
<c:set var="judge" value="${false}"/>
<c:choose>
    <c:when test="${judge==null}">
        为空
    </c:when>
    <c:when test="${judge==true}">
        为true
    </c:when>
    <c:otherwise>
        为false
    </c:otherwise>
</c:choose>
<br/>

c:import实例:<br/>
<c:import url="http://localhost:8080" var="data" charEncoding="utf-8" />
<c:out value="${data}"/><br/>

c:forEach实例:<br/>
<c:forEach items="A,B,C,D,E" begin="1" end="5" step="1" var="myforEach" varStatus="status">
    <c:out value="${myforEach}"/>&nbsp;
    <c:out value="${status}"/><br/>
</c:forEach>

c:forToken实例:<br/>
<c:forTokens items="A/B/C/D/E" begin="1" end="5" step="1" var="myforTokens" varStatus="status" delims="/">
    <c:out value="${myforTokens}"/> <br/>
</c:forTokens>

c:param实例:<br/>
<c:url var="main" value="http://localhost:8080">
    <c:param name="hly" value="max"/>
</c:url>
<a href="<c:out value="${main}"/>">为url发送参数</a>
<%--f12即可看到--%>

c:redirect实例:<br/>
<%--<c:redirect url="http://localhost:8080"/>--%>

c:url实例:<br/>
<a href="<c:url value="http://localhost:8080"/>">url</a>

</body>
</html>

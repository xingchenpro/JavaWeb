<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/17
  Time: 16:13
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动作元素</title>
</head>
<body>
<%--useBean--%>
<jsp:useBean id="myBean" class="com.hly.jsp.bean.MyBean"/>
<jsp:setProperty name="myBean" property="user_name" value="ly"/>
<jsp:getProperty name="myBean" property="user_name"/>

</body>
</html>

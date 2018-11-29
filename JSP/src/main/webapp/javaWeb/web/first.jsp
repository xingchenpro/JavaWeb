<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
第一个JSP!<br>
<!--第一个注释是HTML注释，该类注释在客户端是可见 -->
<!--第二个注释是HTML结合JSP表达式的注释<%= (new java.util.Date()).toLocaleString() %>-->
<%--第三个注释是 JSP注释，该注释在客户端是不可见的--%>
<%
    //第四个注释是Java注释，即Java语言中的单行、多行注释，该注释在客户端是不可见
  /*
  User user = new User();
  */
%>


</body>
</html>

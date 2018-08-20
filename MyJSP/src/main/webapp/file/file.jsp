<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/20
  Time: 21:30
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file</title>
</head>
<body>
<%--enctype不对字符进行编码--%>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>
</body>
</html>

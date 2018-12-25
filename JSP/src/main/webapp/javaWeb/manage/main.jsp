<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/11/29
  Time: 10:49
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>main</title>
    <style>
        a, a:focus {
            text-decoration: none;
        }
    </style>
</head>
<body>

<a href="selectAllEmp.do">点击查询所有用户信息</a><br/>

<form action="selectByEmpName.do">
    <input type="text" name="selectName" placeholder="请输入名字">
    <input type="submit" value="模糊查询">
</form>

<form action="addEmp.do">
    <input type="text" name="addName" placeholder="请输入姓名">
    <input type="text" name="addNote" placeholder="请输入Note">
    <input type="submit" value="添加">
</form>

<form action="updateEmp.do">
    <input type="text" placeholder="需要修改的id"name="updateId" >
    <input type="text" placeholder="需要修改的name" name="updateName">
    <input type="text" placeholder="需要修改的note" name="updateNote">
    <input type="submit" value="修改">
</form>

<table border="1" cellpadding="3" cellspacing="0" width="400">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>note</th>
        <th>delete</th>
    </tr>
    <c:forEach var="e" items="${list}">
        <tr>

            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.note}</td>
            <td><a href="deleteEmp.do?deleteId=${e.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<script type="javascript">

</script>
</body>
</html>

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
        a,a:focus{
            text-decoration: none;
        }
    </style>
</head>
<body>

<a href="selectAllEmp.do">点击查询所有</a><br/>

<form action="selectByEmpName.do">
    <input type="text" name="selectName" placeholder="请输入名字">
    <input type="submit" value="模糊查询">
</form>

<form action="addEmp.do">
    <input type="text" name="addId" placeholder="请输入id">
    <input type="text" name="addName" placeholder="请输入姓名">
    <input type="text" name="addNote" placeholder="请输入Note">
    <input type="submit" value="添加">
</form>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>note</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    <c:forEach var="e" items="${list}">
    <tr>
        <td>${e.id}</td>
        <td>${e.name}</td>
        <td>${e.note}</td>
        <td><a href="deleteEmp.do">删除</a></td>
        <td><a href="updateEmp.do">修改</a></td>

    </tr>
    </c:forEach>

</table>

</body>
</html>

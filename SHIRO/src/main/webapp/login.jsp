<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/28
  Time: 19:37
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%String path = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link rel="stylesheet" href="static/css/login.css">
</head>
<body>
<main>
    <form class="form" id="login_form" method="post" action="/login">
        <div class="form__cover"></div>
        <div class="form__loader">
            <div class="spinner active">
                <svg class="spinner__circular" viewBox="25 25 50 50">
                    <circle class="spinner__path" cx="50" cy="50" r="20" fill="none" stroke-width="4"
                            stroke-miterlimit="10"></circle>
                </svg>
            </div>
        </div>
        <div class="form__content">
            <h1>Authorization</h1>
            <div class="styled-input">
                <input type="text" class="styled-input__input" name="userId" id="user_id" autocomplete="off" >
                <div class="styled-input__placeholder">
                    <span class="styled-input__placeholder-text">username</span>
                </div>
                <div class="styled-input__circle"></div>
            </div>

            <div class="styled-input">
                <input type="password" class="styled-input__input" id="user_password" name="userPassword" autocomplete="off" >
                <div class="styled-input__placeholder">
                    <span class="styled-input__placeholder-text">password</span>
                </div>
                <div class="styled-input__circle"></div>
            </div>
            <button id="login_button" type="button" class="styled-button" onclick="checkUser();">
                    <span class="styled-button__real-text-holder">
                        <span class="styled-button__real-text">Submit</span>
                        <span class="styled-button__moving-block face">
                            <span class="styled-button__text-holder">
                                <span class="styled-button__text">Submit</span>
                            </span>
                        </span><span class="styled-button__moving-block back">
                            <span class="styled-button__text-holder">
                                <span class="styled-button__text">Submit</span>
                            </span>
                        </span>
                    </span>
            </button>
        </div>
    </form>
</main>
<script src="static/js/login.js"></script>
<script>
    function checkUser() {
        var user_id = document.getElementById("user_id").value;
        var user_password = document.getElementById("user_password").value;
        if(user_id ==""){
            alert("请输入账号");
            return false;
        }
        if(user_password == ""){
            alert("请输入用户名");
            return false;
        }
        else{document.getElementById("login_form").submit();
        }
    }

</script>

</body>
</html>



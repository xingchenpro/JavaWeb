<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/18
  Time: 14:58
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie user = new Cookie("user","hly");
    Cookie password = new Cookie("password","123");
        /*设置有效期*/
    user.setMaxAge(60*60);
    password.setMaxAge(60*60);
        /*添加cookie*/
    response.addCookie(user);
    response.addCookie(password);
%>
<html>
<head>
    <title>coolie</title>
</head>
<body>
<%
    /*获得所有cookie*/
    Cookie[] cookies = request.getCookies();
   for(int i = 0 ;i<cookies.length;i++){
       out.println(cookies[i].getName()+" "+cookies[i].getValue());
       if(cookies[i].getName().compareTo("userId")==0){
           cookies[i].setMaxAge(0);
           /*google设置路径才能删除*/
           cookies[i].setPath("/");
           response.addCookie(cookies[i]);
           out.println("已将删除cookie:"+cookies[i].getName());
       }

   }



%>


</body>
</html>

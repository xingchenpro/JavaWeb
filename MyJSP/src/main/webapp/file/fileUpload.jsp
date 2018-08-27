<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/20
  Time: 21:30
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>file</title>

</head>
<body>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <a class="upload"><input class="file" type="file" name="file"></a>
    <input type="submit" value="上传">
</form>
${message}
<a href="/FileDownload?fileName=${fileName}" rel="nofollow">${fileName}</a>
<%--https://www.baidu.com/s?wd=nofollow%E6%A0%87%E7%AD%BE&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao--%>
<%--nofollow不要追踪此特定链接--%>

<%--
<script>
    var message;
    window.onload= function (ev) {
        message = ${message}
        if(message!=null){
            alert(message);
        }
    }
</script>
--%>
<%--
${empty xx}
${empty eq null}
empty 对""和null返回true
null 对null 返回true ""返回false
--%>
</body>
</html>

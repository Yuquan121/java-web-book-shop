<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册页面</title>
    <!-- 写上当前页面的所有相对路径的参照 -->
    <%@include file="/Pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/悦读logo.jpg">
    <span class="wel_word"></span>
    <%@include file="common/logiin_success_menu.jsp" %>
</div>

<div id="main">

    <h1>注册成功! <a href="">转到主页</a></h1>

</div>

</body>
</html>
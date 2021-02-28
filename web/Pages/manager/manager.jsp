<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <%@include file="/Pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="Pages/static/img/悦读logo.jpg">
    <span class="wel_word">后台管理系统</span>
    <div>
        <a href="manager/BookServlet?action=page" >图书管理</a>
        <a href="Pages/manager/order_manager.jsp">订单管理</a>
        <a href="">返回商城</a>
    </div>
</div>

<div id="main">
    <h1>欢迎管理员进入后台管理系统</h1>
</div>

</body>
</html>
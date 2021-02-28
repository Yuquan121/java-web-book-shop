<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <%@include file="/Pages/common/head.jsp"%>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="Pages/css/login.css"/>
</head>
<script src="bootstrap/jq/jquery-3.5.1.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<body>
<!--Logo-->
<div id="login_header" class="container-fluid">
    <img src="img/悦读logo.jpg" style="height: 87px;width: 164px;position: relative;top: 25px;left: 40px"/>
</div>

<!--轮播图和登录框-->
<div class="container c1">
    <!--轮播图-->
    <div id="myCarousel" class="col-md-7 lu carousel slide" data-ride="carousel ">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="img/轮播图1.jpg" alt="无法访问" style="width: 672px;height: 367px;">
            </div>
            <div class="item">
                <img src="img/轮播图2.jpg" alt="无法访问" style="width: 672px;height: 367px;">
            </div>
            <div class="item">
                <img src="img/轮播图1.jpg" alt="无法访问" style="width: 672px;height: 367px;">
            </div>
            <div class="item">
                <img src="img/轮播图2.jpg" alt="无法访问" style="width: 672px;height: 367px;">
            </div>
            <!-- 控制 -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <!--登录框-->
    <div class="col-md-3 col-md-offset-1" id="login_box" >
        <form action="http://localhost:8080/BookShop/UserServlet" method="post">
            <input type="hidden" name="action" value="login">
            <h1 align="center">用户登录</h1>
            <div class="form-group">
                <label for="name">用户名</label>
                <input type="text" name="username" class="form-control" id="name" placeholder="姓名"
                value="${requestScope.username}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="密码">
            </div>
            <input type="checkbox">记住密码
            <br>
            <button type="submit" class="btn btn-danger" id="btn_login">登录</button>
            <a href="${pageContext.request.contextPath}/Pages/register.jsp" target="_self">立即注册</a>
            <div>
                <span class="errorMsg" style="color: red">
                    ${empty requestScope.msg?"":requestScope.msg}
                </span>
            </div>
        </form>
    </div>

</div>
</div>
</body>
</html>
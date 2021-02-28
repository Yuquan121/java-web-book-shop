<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <%@include file="/Pages/common/head.jsp" %>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="Pages/css/regist.css"/>
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
    <!--注册框-->
    <div class="col-md-3 col-md-offset-1" id="register_box">
        <form action="http://localhost:8080/BookShop/UserServlet" method="post">
            <input type="hidden" name="action" value="register">
            <div class="form-group">
                <label>用户名称</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名">
            </div>
            <div class="form-group">
                <label>用户密码</label>
                <input type="password" name="password" class="form-control" placeholder="请输入密码">
            </div>
            <div class="form-group">
                <label>确认密码</label>
                <input type="password" name="repassword" class="form-control" placeholder="请再次输入密码">
            </div>
            <div class="form-group">
                <label>电子邮件：</label>
                <input class="form-control" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                       name="email" id="email"/>
            </div>
            <div class="form-group">
                <label>验证码：</label>
                <input type="text" name="code" style="width: 150px;" id="code"/>
                <img class="img-kap" src="Kaptcha.jpg" alt="图片无法显示" style="width: 148px">
            </div>
            <button type="submit" class="btn btn-danger" id="btn_register">立即注册</button>
            <div>
                <span class="errorMsg" style="color: red">
                    ${empty requestScope.msg?"":requestScope.msg}
                </span>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {

        $(".img-kap").click(function () {
            this.src = "${param.basePath}Kaptcha.jpg";
        });

        $("#username").blur(function () {
            let username = this.value;
            $.getJSON("UserServlet", "action=ajaxExistName&username=" + username, function (data) {
                if(data.existsUserName){
                    $(".errorMsg").text("用户名已存在");
                }else{
                    $(".errorMsg").text("用户名可用");
                }
            });
        });
    });
</script>
</html>






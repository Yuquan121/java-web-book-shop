<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@include file="/Pages/common/head.jsp" %>
    <link type="text/css" rel="stylesheet" href="Pages/static/css/style.css">
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="Pages/static/img/悦读logo.jpg">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="Pages/Login.jsp">登录</a> |
            <a href="Pages/register.jsp">注册</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>
            <a href="Pages/order/order.jsp">我的订单</a>
            <a href="UserServlet?action=loginOut">注销</a>&nbsp;&nbsp;
            <a href="">返回</a>
        </c:if>

        <a href="Pages/cart/cart.jsp">购物车</a>
        <a href="Pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/ClientBookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="text-align: center">
            <span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>

            <c:if test="${empty sessionScope.cart.items}">
                <div>
                    <span style="color: red">购物车为空</span>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <div>
                    您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>

        </div>

        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%--分页条--%>
    <%@include file="/Pages/common/page_nav.jsp" %>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $("button.addToCart").click(function () {
            var bookId = $(this).attr("bookId")
            location.href = "CartServlet?action=addItem&id=" + bookId;
        });
    });
</script>
</html>
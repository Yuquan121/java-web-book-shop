<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/Pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="Pages/static/img/悦读logo.jpg">
    <span class="wel_word">购物车</span>
    <%@include file="/Pages/common/logiin_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">
        <table>
            <tr>
                <td colspan="5"><a href="" style="text-decoration: none">当前购物车为空，快去浏览吧！！</a></td>
            </tr>
            </c:if>

            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount" type="text" style="width: 60px" bookId="${entry.value.id}"
                               value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a href="CartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>


        </table>
        <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="CartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="OrderServlet?action=createOrder">去结账</a></span>
        </div>
        </c:if>

</div>
</body>
<script type="text/javascript">
    $(function () {
        $(".updateCount").change(function () {
            var name = $(this).parent().parent().find("td:first").text();
            var count = this.value;
            var id = $(this).attr("bookId");

            if (confirm("你确定将【" + name + "】商品数量修改为：" + count + "吗？")) {
                location.href = "CartServlet?action=updateCount&count=" + count + "&id=" + id;
            } else {
                this.value = this.defaultValue;
            }
        });
    });
</script>
</html>
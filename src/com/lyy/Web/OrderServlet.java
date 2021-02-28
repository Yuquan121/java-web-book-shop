package com.lyy.Web;

import com.lyy.Service.Impl.OrderServiceImpl;
import com.lyy.Service.OrderService;
import com.lyy.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Moon
 */

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        domain.User loginUser = (domain.User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/Pages/Login.jsp").forward(req, resp);
            return;
        }

        Integer userId = loginUser.getId();
//        调用orderService.createOrder(Cart,Userid);生成订单
        String orderId = orderService.createOrder(cart, userId);

        req.getSession().setAttribute("orderId", orderId);

        resp.sendRedirect(req.getContextPath() + "/Pages/cart/checkout.jsp");

    }
}

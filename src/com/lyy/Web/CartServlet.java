package com.lyy.Web;

import com.lyy.Service.BookService;
import com.lyy.Service.Impl.BookServiceImpl;
import com.lyy.Utils.WebUtils;
import com.lyy.domain.Book;
import com.lyy.domain.Cart;
import com.lyy.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Moon
 */

public class CartServlet extends BaseServlet {
    BookService bs = new BookServiceImpl();

    /**
     * 加入购物车操作
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到图书信息
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //把图书信息转换为商品项
        Book book = bs.queryBookById(id);
        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(item);
        //重定向
        resp.sendRedirect(req.getHeader("Referer"));
        //添加最后一个商品的名称
        req.getSession().setAttribute("lastName", item.getName());

    }

    /**
     * 删除购物车商品
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 更改购物车商品数量
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            //重定向
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}

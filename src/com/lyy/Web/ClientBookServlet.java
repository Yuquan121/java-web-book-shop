package com.lyy.Web;

import com.lyy.Service.BookService;
import com.lyy.Service.Impl.BookServiceImpl;
import com.lyy.Utils.WebUtils;
import com.lyy.domain.Book;
import com.lyy.domain.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Moon
 */

public class ClientBookServlet extends BaseServlet {
    private BookService bs = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bs.page(pageNo, pageSize);
        page.setUrl("client/ClientBookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/Pages/client/index.jsp").forward(req, resp);

    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        Page<Book> page = bs.pageByPrice(pageNo, pageSize,min,max);

        StringBuilder stringBuilder = new StringBuilder("client/ClientBookServlet?action=pageByPrice");
        if(req.getParameter("min")!=null){
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }


        page.setUrl(stringBuilder.toString());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/Pages/client/index.jsp").forward(req, resp);

    }
}

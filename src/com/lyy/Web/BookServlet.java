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
import java.util.List;

/**
 * @description:
 * @author: Moon
 */

public class BookServlet extends BaseServlet {

    private BookService bs = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.请求参数封装成bean对象
        Book book = WebUtils.copyParamsToBeans(req.getParameterMap(), new Book());
        //2.调用BookService.addBook方法保存图书到数据库
        bs.addBook(book);
        //3.跳到图书列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo="+req.getParameter("pageNo")+1);


    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.请求参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用BookService.deliteBook方法在数据库删除图书
        bs.deleteBookById(id);
        //3.跳到图书列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamsToBeans(req.getParameterMap(), new Book());
        bs.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bs.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/Pages/manager/book_edit.jsp").forward(req, resp);

    }

    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page  = bs.page(pageNo,pageSize);
        page.setUrl("manager/BookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/Pages/manager/book_manager.jsp").forward(req,resp);

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.查询所有图书信息
        List<Book> books = bs.queryBook();
        //2.保存到request域中
        req.setAttribute("books", books);
        //3.请求转发页面
        req.getRequestDispatcher("/Pages/manager/book_manager.jsp").forward(req, resp);
    }


}

package com.lyy.Web;

import com.lyy.Service.Impl.UserServiceImpl;
import com.lyy.Service.UserService;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Moon
 */

public class Register extends HttpServlet {
    UserService us = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abc".equals(code)) {
            if (us.existsUserName(username)) {
                //不可用
                req.setAttribute("msg","用户名不可用");
                req.setAttribute("username",username);
                System.out.println("用户名不可用");
                req.getRequestDispatcher("/Pages/register.jsp").forward(req, resp);;
            } else {
                //保存到数据库
                us.register(new User(null, username, password, email));
                req.getRequestDispatcher("/Pages/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg","验证码错误");
            req.setAttribute("code",code);
            System.out.println("验证码错误" + code + "跳回注册页面");
            req.getRequestDispatcher("/Pages/register.jsp").forward(req, resp);

        }
    }
}

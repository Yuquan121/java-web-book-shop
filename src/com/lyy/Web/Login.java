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

public class Login extends HttpServlet {
    UserService us = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(us.login(new User(null,username,password,null)) == null){
            //登录失败
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            System.out.println("登录失败");
            req.getRequestDispatcher("/Pages/Login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/Pages/login_success.jsp").forward(req,resp);
        }

    }
}

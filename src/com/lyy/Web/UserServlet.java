package com.lyy.Web;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.google.gson.Gson;
import com.lyy.Service.Impl.UserServiceImpl;
import com.lyy.Service.UserService;
import com.lyy.Utils.WebUtils;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.runner.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @description:
 * @author: Moon
 */

public class UserServlet extends BaseServlet {
    UserService us = new UserServiceImpl();

    /**
     * 处理登录业务
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");

        User user = WebUtils.copyParamsToBeans(req.getParameterMap(), new User());
        User loginUser = us.login(user);
        if (loginUser == null) {
            //登录失败
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", user.getUsername());
            System.out.println("登录失败");
            req.getRequestDispatcher("/Pages/Login.jsp").forward(req, resp);
        } else {
            //保存用户登录的信息
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/Pages/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 处理注册业务
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("name");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        User user = WebUtils.copyParamsToBeans(req.getParameterMap(), new User());


        if (token != null && token.equals(code)) {
            if (us.existsUserName(user.getUsername())) {
                //不可用
                req.setAttribute("msg", "用户名已被注册");
                req.setAttribute("username", user.getUsername());
                System.out.println("用户名不可用");
                req.getRequestDispatcher("/Pages/register.jsp").forward(req, resp);
            } else {
                //保存到数据库
                us.register(user);
                req.getRequestDispatcher("/Pages/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("code", code);
            System.out.println("验证码错误" + code + "跳回注册页面");
            req.getRequestDispatcher("/Pages/register.jsp").forward(req, resp);
        }
    }

    /**
     * 注销登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * ajax验证用户名是否可用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxExistName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existsUserName = us.existsUserName(username);
        Map<String,Object> result = new HashMap<>();
        result.put("existsUserName",existsUserName);

        Gson gson = new Gson();
        String json = gson.toJson(result);

        resp.getWriter().write(json);
    }

}

package com.lyy.filter;

import org.junit.runner.Request;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description:
 * @author: Moon
 */

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        domain.User user = (domain.User) httpServletRequest.getSession().getAttribute("user");

        if (user == null || !"admin".equals(user.getUsername()) ) {
            httpServletRequest.getRequestDispatcher("/Pages/Login.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}

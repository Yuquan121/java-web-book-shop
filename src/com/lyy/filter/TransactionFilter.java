package com.lyy.filter;

import com.lyy.Utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description:
 * @author: Moon
 */

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commit();
        } catch (Exception e) {
            JdbcUtils.rollBack();
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}

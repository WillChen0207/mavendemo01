package com.testsql;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "/logstatement", urlPatterns = "/post.jsp")
public class LogStatementFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getSession().getAttribute("UserName") == null) {
            System.out.println("Not logged in yet. Redirect to log in page.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            System.out.println("User already logged in.");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy(){

    }
}

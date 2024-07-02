package com.cz.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response= (HttpServletResponse)servletResponse;
        //设置编码
        request.setCharacterEncoding("UTF-8");
        String url =  request.getRequestURI();
        //接受参数
        Object username = request.getSession().getAttribute("username");
        //System.out.println(username);
        //逻辑代码
        if(url.endsWith("login")||url.endsWith("register.jsp")||url.endsWith("index.jsp")||url.endsWith("register")) {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            if (username == null) {
                //跳转页面
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }

    }
}

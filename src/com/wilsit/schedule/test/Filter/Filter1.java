package com.wilsit.schedule.test.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter1 before dofilter invoked");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter1 after dofilter invoked");

    }

    @Override
    public void destroy() {

    }
}


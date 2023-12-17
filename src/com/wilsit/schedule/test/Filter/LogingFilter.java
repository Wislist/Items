package com.wilsit.schedule.test.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 1 实现Filter接口
 * 2.重写过滤方法
 * 3.配置过滤器
 * web.xml
 * 注解
 * @DATA 2023/12/5
 * @author <a href="mailto:WISLIST"
 */
@WebFilter("/*")
// "/*" 过滤全部资源    /a/*    *.html
public class LogingFilter implements Filter {
    /*
    * 过滤请求的方法
    * 1 请求到达目标资源之前，先经过该方法
    * 2 该方法有能力控制请求是否继续进行
    * 3 响应的时候还会经过该方法 但是无法控制是否响应
    *
    * */

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain/*过滤链 允许多个过滤器*/ filterChain) throws IOException, ServletException {
        /*
        * 1 判断是否登录 校验权限是否满足
        * 2 放行代码
        *
        *  3 响应之前 HttpServletResponse 转化为响应报文之前的功能代码
        * */
        //请求到达目标资源之前 打印日志   yyy-MM-dd 被访问了
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //功能代码
        //参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //System.out.println("logingFilter before doFilter invoked");
        String requestURI = request.getRequestURI();
        String dataTime = dateFormat.format(new Date());
        String beforeLoging = requestURI+"在"+dataTime+"被访问了";
        System.out.println(beforeLoging);


        //放行代码
        long beforeTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        //响应之前的功能代码
        long afterTime = System.currentTimeMillis();
        String afterLoging = requestURI+"资源在"+dataTime+"耗时"+(afterTime-beforeTime)+"毫秒";
        System.out.println(afterLoging);
        //System.out.println("logingFilter before doFilter invoked");
    }

    @Override
    public void destroy() {

    }


}


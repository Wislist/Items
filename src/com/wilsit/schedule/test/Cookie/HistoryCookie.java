package com.wilsit.schedule.test.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Cookie")
public class HistoryCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        /**
         * get now time
         */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String curTime = format.format(new Date());

        Cookie[] cookies = req.getCookies();
        String lastLogonTime = null;
        if(cookies != null){
            for(Cookie c : cookies){
                if(c.getName().equals("lastTime")){
                    lastLogonTime = c.getValue();

                    //1.把上次访问时间显示到浏览器
                    out.write("欢迎回来！你上次访问的时间为："+lastLogonTime+"当前的时间为："+curTime);
                    //2.更新cookie
                    c.setValue(curTime);
                    //3.把更新后的cookie发送到浏览器
                    resp.addCookie(c);
                    return;
                }
            }
        }

        //第一次访问（没有cookie 或 有cookie，但是没有名为lastTime的cookie）
        if (cookies == null || lastLogonTime == null) {
            //1.显示当前时间到显示器
            out.write("首次访问本站，当前时间："+curTime + "<br/>");
            //2.创建Cookie对象
            Cookie cookie = new Cookie("lastTime",curTime);
            cookie.setMaxAge(1*30*24*60*60);//这个表示cookie存放的最大时间为 一个月 单位是秒数
            //3.把cookie发送到浏览器保存
            resp.addCookie(cookie);
        }


    }
}

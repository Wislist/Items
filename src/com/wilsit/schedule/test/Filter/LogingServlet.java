package com.wilsit.schedule.test.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(value = "/servlet1",name = "servleta")
public class LogingServlet extends HttpServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service ");
        res.getWriter().write("servlet1 meassage");
    }


}

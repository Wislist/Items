package com.wilsit.schedule.test.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class Servlet3 extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO 向应用域删除数据

        ServletContext application = this.getServletContext();
        application.removeAttribute("keya");

    }
}

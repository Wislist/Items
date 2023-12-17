package com.wilsit.schedule.controller;

import com.wilsit.schedule.sevice.SysScheduleService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/*
增加  /schedule/add
查   /schedule/find
修改 /schedule/update
删除 /schedule/remove
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断此次请求是 增删改查？
        String requestURL = req.getRequestURI();// /schedule/add
        String[] split = requestURL.split("/");
        String methodName = split[split.length-1];
        //使用 反射 来获取下面的方法
        Class aClass = this.getClass();
        //获取方法
        try{
            Method method = aClass.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }


//        if (methodName.equals("add")){
//            add(req,resp);
//        } else if (methodName.equals("find")){
//            find(req,resp);
//        }else if (methodName.equals("update")){
//            update(req,resp);
//        }else if (methodName.equals("remove")){
//            remove(req,resp);
//        }


    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        System.out.println("remove");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        System.out.println("update");
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        System.out.println("find");
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        System.out.println("add");
    }


}


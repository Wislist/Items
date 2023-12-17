package com.wilsit.schedule.controller;


import com.wilsit.schedule.pojo.SysUser;
import com.wilsit.schedule.sevice.SysUserService;
import com.wilsit.schedule.sevice.impl.SysUserServiceImpl;
import com.wilsit.schedule.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController{
    private SysUserService userService = new SysUserServiceImpl();
    /**
     * 接收用户注册请求的业务接口实现（业务接口 不是interface）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        //1、接收cilent提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //2、调用服务层方法，完成注册
           //将参数放入一个SysUser对象中，在调用regist方法时传入
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);
        //3 根据注册结果（成功 失败）做页面跳转
        if (rows > 0 ){
            resp.sendRedirect("/registSuccess.html");
        }else {
            resp.sendRedirect("/registFail.html");
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1 接收用户名和密码
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //2 调用服务层方法，根据用户名查询用户信息
        SysUser loginUser = userService.findByUsername(username);
        if (null == loginUser){
            //跳转到用户名有误的提示页
            resp.sendRedirect("/loginUsernameError.html");
        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
            //3 判断密码是否匹配
            // 跳转到密码有误
            resp.sendRedirect("/loginUserPwdError.html");

        }else {
            //跳转到首页
            resp.sendRedirect("/showSchedule.html");
        }
    }


}

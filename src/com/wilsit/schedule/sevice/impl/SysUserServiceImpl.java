package com.wilsit.schedule.sevice.impl;

import com.wilsit.schedule.dao.SysUserDao;
import com.wilsit.schedule.dao.impl.SysUserDaoImpl;
import com.wilsit.schedule.pojo.SysUser;
import com.wilsit.schedule.sevice.SysUserService;
import com.wilsit.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao userDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {
        //将用户的明文转换成密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        //调用dao层的方法 将sysUser信息存入数据库、
        return userDao.addSysUser(sysUser);
    }


    @Override
    public SysUser findByUsername(String username) {
        //调用服务层方法 继续查询
        return userDao.findByUsername(username);
    }

}

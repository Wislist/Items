package com.wilsit.schedule.dao.impl;

import com.wilsit.schedule.dao.BaseDao;
import com.wilsit.schedule.dao.SysUserDao;
import com.wilsit.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "INSERT INTO sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql,sysUser.getUsername(),sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd userPwd from sys_user where username = ?";
        List<SysUser> userList = baseQuery(SysUser.class, sql,username);
        return null != userList&&userList.size()>0?userList.get(0):null;
    }
}

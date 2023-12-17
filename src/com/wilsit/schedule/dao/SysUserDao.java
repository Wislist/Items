package com.wilsit.schedule.dao;

import com.wilsit.schedule.pojo.SysUser;

public interface SysUserDao {
    int addSysUser(SysUser sysUser);

    SysUser findByUsername(String username);
}

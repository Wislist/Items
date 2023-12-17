package com.wilsit.schedule.sevice;

import com.wilsit.schedule.pojo.SysUser;

public interface SysUserService {

    int regist(SysUser sysUser);

    SysUser findByUsername(String username);
}

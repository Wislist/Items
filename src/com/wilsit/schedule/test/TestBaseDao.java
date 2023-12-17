package com.wilsit.schedule.test;

import com.wilsit.schedule.dao.BaseDao;
import com.wilsit.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
   public static void initBaseDao(){
        baseDao=new BaseDao();
   }

    @Test
    public void testBaseQueryObject(){
        // 查询用户数量  baseQueryObject 查询结果集是单行 单列的 一个值的数据的方法
        String sql ="select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }
    @Test
    public void testBaseQuery(){
        //查出来的字段如果和实体类名字不同 则要求我们起别名
        String sql ="select uid,username,user_pwd userPwd from sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate(){
        String sql ="insert into sys_schedule values(DEFAULT,?,?,?)";

        int rows = baseDao.baseUpdate(sql, 1, "学习JAVA", 0);
        System.out.println(rows);
    }


}
